package com.vesper.flipper.domain.executor

import com.vesper.flipper.ble.FlipperFileSystem
import com.vesper.flipper.domain.model.*
import com.vesper.flipper.domain.service.AuditService
import com.vesper.flipper.domain.service.DiffService
import com.vesper.flipper.domain.service.PermissionService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.URI
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.system.measureTimeMillis

/**
 * Central command executor that processes all AI agent commands.
 * Enforces risk assessment, permissions, and audit logging.
 *
 * Key principle: The model issues commands, Android decides what executes.
 */
@Singleton
class CommandExecutor @Inject constructor(
    private val fileSystem: FlipperFileSystem,
    private val riskAssessor: RiskAssessor,
    private val permissionService: PermissionService,
    private val auditService: AuditService,
    private val diffService: DiffService
) {

    private val pendingApprovals = ConcurrentHashMap<String, PendingApproval>()

    private val _currentApproval = MutableStateFlow<PendingApproval?>(null)
    val currentApproval: StateFlow<PendingApproval?> = _currentApproval.asStateFlow()

    /**
     * Execute a command from the AI agent.
     * Returns immediately for safe operations or requests approval for risky ones.
     */
    suspend fun execute(command: ExecuteCommand, sessionId: String): CommandResult {
        val startTime = System.currentTimeMillis()
        val traceId = UUID.randomUUID().toString()
        clearExpiredApprovals()

        // Log command receipt
        auditService.log(
            AuditEntry(
                actionType = AuditActionType.COMMAND_RECEIVED,
                command = command,
                sessionId = sessionId,
                metadata = mapOf("trace_id" to traceId)
            )
        )

        // Assess risk (Android decides, not the model)
        val riskAssessment = riskAssessor.assess(command)

        return when (riskAssessment.level) {
            RiskLevel.LOW -> executeDirectly(
                command = command,
                sessionId = sessionId,
                startTime = startTime,
                riskLevel = riskAssessment.level,
                traceId = traceId
            )

            RiskLevel.MEDIUM -> {
                // Medium-risk operations can still require explicit user confirmation.
                if (riskAssessment.requiresDiff || riskAssessment.requiresConfirmation) {
                    requestApproval(
                        command = command,
                        riskAssessment = riskAssessment,
                        sessionId = sessionId,
                        startTime = startTime,
                        traceId = traceId
                    )
                } else {
                    executeDirectly(
                        command = command,
                        sessionId = sessionId,
                        startTime = startTime,
                        riskLevel = riskAssessment.level,
                        traceId = traceId
                    )
                }
            }

            RiskLevel.HIGH -> requestApproval(
                command = command,
                riskAssessment = riskAssessment,
                sessionId = sessionId,
                startTime = startTime,
                traceId = traceId
            )

            RiskLevel.BLOCKED -> {
                auditService.log(
                    AuditEntry(
                        actionType = AuditActionType.COMMAND_BLOCKED,
                        command = command,
                        riskLevel = RiskLevel.BLOCKED,
                        sessionId = sessionId,
                        metadata = mapOf(
                            "reason" to (riskAssessment.blockedReason ?: "Protected path"),
                            "trace_id" to traceId
                        )
                    )
                )
                CommandResult(
                    success = false,
                    action = command.action,
                    error = "Blocked: ${riskAssessment.blockedReason ?: "This path is protected"}"
                )
            }
        }
    }

    private suspend fun executeDirectly(
        command: ExecuteCommand,
        sessionId: String,
        startTime: Long,
        riskLevel: RiskLevel,
        traceId: String
    ): CommandResult {
        var executionTime: Long = 0
        val result = try {
            val data: CommandResultData?
            executionTime = measureTimeMillis {
                data = executeAction(command)
            }
            CommandResult(
                success = true,
                action = command.action,
                data = data,
                executionTimeMs = executionTime
            )
        } catch (e: Exception) {
            CommandResult(
                success = false,
                action = command.action,
                error = "${command.action.name}: ${e.message ?: "Unknown error"}",
                executionTimeMs = System.currentTimeMillis() - startTime
            )
        }

        // Log execution result
        auditService.log(
            AuditEntry(
                actionType = if (result.success) AuditActionType.COMMAND_EXECUTED else AuditActionType.COMMAND_FAILED,
                command = command,
                result = result,
                riskLevel = riskLevel,
                userApproved = true,
                approvalMethod = ApprovalMethod.AUTO,
                sessionId = sessionId,
                metadata = mapOf("trace_id" to traceId)
            )
        )

        return result
    }

    private suspend fun requestApproval(
        command: ExecuteCommand,
        riskAssessment: RiskAssessment,
        sessionId: String,
        startTime: Long,
        traceId: String
    ): CommandResult {
        val diff = if (command.action == CommandAction.WRITE_FILE && command.args.path != null) {
            computeDiff(command.args.path, command.args.content ?: "")
        } else {
            null
        }

        val approval = PendingApproval(
            command = command,
            riskAssessment = riskAssessment,
            diff = diff,
            traceId = traceId
        )

        pendingApprovals[approval.id] = approval
        _currentApproval.value = approval

        auditService.log(
            AuditEntry(
                actionType = AuditActionType.APPROVAL_REQUESTED,
                command = command,
                riskLevel = riskAssessment.level,
                sessionId = sessionId,
                metadata = mapOf(
                    "approval_id" to approval.id,
                    "trace_id" to traceId
                )
            )
        )

        return CommandResult(
            success = true,
            action = command.action,
            data = CommandResultData(
                diff = diff,
                message = "Awaiting user approval for ${riskAssessment.reason}"
            ),
            requiresConfirmation = true,
            pendingApprovalId = approval.id,
            executionTimeMs = System.currentTimeMillis() - startTime
        )
    }

    /**
     * Approve a pending action.
     * Called when user confirms via UI.
     */
    suspend fun approve(approvalId: String, sessionId: String): CommandResult {
        clearExpiredApprovals()
        val approval = pendingApprovals.remove(approvalId)
            ?: return CommandResult(
                success = false,
                action = CommandAction.LIST_DIRECTORY,
                error = "Approval not found or expired"
            ).also {
                auditService.log(
                    AuditEntry(
                        actionType = AuditActionType.APPROVAL_TIMEOUT,
                        sessionId = sessionId,
                        metadata = mapOf("approval_id" to approvalId)
                    )
                )
            }

        if (_currentApproval.value?.id == approvalId) {
            _currentApproval.value = null
        }

        val startTime = System.currentTimeMillis()
        val traceId = approval.traceId ?: approval.id

        auditService.log(
            AuditEntry(
                actionType = AuditActionType.APPROVAL_GRANTED,
                command = approval.command,
                riskLevel = approval.riskAssessment.level,
                userApproved = true,
                approvalMethod = if (approval.riskAssessment.level == RiskLevel.HIGH) {
                    ApprovalMethod.HOLD_CONFIRM
                } else {
                    ApprovalMethod.DIFF_REVIEW
                },
                sessionId = sessionId,
                metadata = mapOf(
                    "approval_id" to approvalId,
                    "trace_id" to traceId
                )
            )
        )

        // Execute the command
        return try {
            val data = executeAction(approval.command)
            val result = CommandResult(
                success = true,
                action = approval.command.action,
                data = data,
                executionTimeMs = System.currentTimeMillis() - startTime
            )

            auditService.log(
                AuditEntry(
                    actionType = AuditActionType.COMMAND_EXECUTED,
                    command = approval.command,
                    result = result,
                    riskLevel = approval.riskAssessment.level,
                    userApproved = true,
                    sessionId = sessionId,
                    metadata = mapOf("trace_id" to traceId)
                )
            )

            result
        } catch (e: Exception) {
            CommandResult(
                success = false,
                action = approval.command.action,
                error = e.message ?: "Execution failed",
                executionTimeMs = System.currentTimeMillis() - startTime
            ).also { failed ->
                auditService.log(
                    AuditEntry(
                        actionType = AuditActionType.COMMAND_FAILED,
                        command = approval.command,
                        result = failed,
                        riskLevel = approval.riskAssessment.level,
                        userApproved = true,
                        sessionId = sessionId,
                        metadata = mapOf("trace_id" to traceId)
                    )
                )
            }
        }
    }

    /**
     * Reject a pending action.
     * Called when user cancels via UI.
     */
    suspend fun reject(approvalId: String, sessionId: String): CommandResult {
        clearExpiredApprovals()
        val approval = pendingApprovals.remove(approvalId)

        if (_currentApproval.value?.id == approvalId) {
            _currentApproval.value = null
        }

        if (approval == null) {
            return CommandResult(
                success = false,
                action = CommandAction.LIST_DIRECTORY,
                error = "Approval not found or expired"
            ).also {
                auditService.log(
                    AuditEntry(
                        actionType = AuditActionType.APPROVAL_TIMEOUT,
                        sessionId = sessionId,
                        metadata = mapOf("approval_id" to approvalId)
                    )
                )
            }
        }

        auditService.log(
            AuditEntry(
                actionType = AuditActionType.APPROVAL_DENIED,
                command = approval.command,
                riskLevel = approval.riskAssessment.level,
                userApproved = false,
                sessionId = sessionId,
                metadata = mapOf(
                    "approval_id" to approvalId,
                    "trace_id" to (approval.traceId ?: approval.id)
                )
            )
        )

        return CommandResult(
            success = false,
            action = approval.command.action,
            error = "Action rejected by user"
        )
    }

    private suspend fun executeAction(command: ExecuteCommand): CommandResultData? {
        return when (command.action) {
            CommandAction.LIST_DIRECTORY -> {
                val path = command.args.path ?: "/ext"
                val entries = fileSystem.listDirectory(path).getOrThrow()
                CommandResultData(entries = entries)
            }

            CommandAction.READ_FILE -> {
                val path = command.args.path ?: throw IllegalArgumentException("Path required")
                val content = fileSystem.readFile(path).getOrThrow()
                CommandResultData(content = content)
            }

            CommandAction.WRITE_FILE -> {
                val path = command.args.path ?: throw IllegalArgumentException("Path required")
                val content = command.args.content ?: throw IllegalArgumentException("Content required")
                val bytesWritten = fileSystem.writeFile(path, content).getOrThrow()
                CommandResultData(bytesWritten = bytesWritten)
            }

            CommandAction.CREATE_DIRECTORY -> {
                val path = command.args.path ?: throw IllegalArgumentException("Path required")
                fileSystem.createDirectory(path).getOrThrow()
                CommandResultData(message = "Directory created: $path")
            }

            CommandAction.DELETE -> {
                val path = command.args.path ?: throw IllegalArgumentException("Path required")
                fileSystem.delete(path, command.args.recursive).getOrThrow()
                CommandResultData(message = "Deleted: $path")
            }

            CommandAction.MOVE -> {
                val path = command.args.path ?: throw IllegalArgumentException("Source path required")
                val dest = command.args.destinationPath ?: throw IllegalArgumentException("Destination path required")
                fileSystem.move(path, dest).getOrThrow()
                CommandResultData(message = "Moved: $path -> $dest")
            }

            CommandAction.RENAME -> {
                val path = command.args.path ?: throw IllegalArgumentException("Path required")
                val newName = command.args.newName ?: throw IllegalArgumentException("New name required")
                fileSystem.rename(path, newName).getOrThrow()
                CommandResultData(message = "Renamed to: $newName")
            }

            CommandAction.COPY -> {
                val path = command.args.path ?: throw IllegalArgumentException("Source path required")
                val dest = command.args.destinationPath ?: throw IllegalArgumentException("Destination path required")
                fileSystem.copy(path, dest).getOrThrow()
                CommandResultData(message = "Copied: $path -> $dest")
            }

            CommandAction.GET_DEVICE_INFO -> {
                val deviceInfo = fileSystem.getDeviceInfo().getOrThrow()
                CommandResultData(deviceInfo = deviceInfo)
            }

            CommandAction.GET_STORAGE_INFO -> {
                val storageInfo = fileSystem.getStorageInfo().getOrThrow()
                CommandResultData(storageInfo = storageInfo)
            }

            CommandAction.PUSH_ARTIFACT -> {
                val path = command.args.path ?: throw IllegalArgumentException("Path required")
                val data = command.args.artifactData ?: throw IllegalArgumentException("Artifact data required")
                val bytes = android.util.Base64.decode(data, android.util.Base64.DEFAULT)
                val bytesWritten = fileSystem.writeFileBytes(path, bytes).getOrThrow()
                CommandResultData(bytesWritten = bytesWritten, message = "Artifact pushed: $path")
            }

            CommandAction.EXECUTE_CLI -> {
                val cliCommand = command.args.command
                    ?: command.args.content
                    ?: throw IllegalArgumentException("CLI command required")
                val output = fileSystem.executeCli(cliCommand).getOrThrow()
                CommandResultData(
                    content = output,
                    message = "Executed CLI command: $cliCommand"
                )
            }

            CommandAction.SEARCH_FAPHUB -> {
                val query = command.args.command
                    ?.trim()
                    ?.takeIf { it.isNotEmpty() }
                    ?: throw IllegalArgumentException("FapHub query required")
                executeFapHubSearch(query)
            }

            CommandAction.INSTALL_FAPHUB_APP -> {
                val appIdOrName = command.args.command
                    ?.trim()
                    ?.takeIf { it.isNotEmpty() }
                    ?: throw IllegalArgumentException("FapHub app id/name required")
                executeFapHubInstall(
                    appIdOrName = appIdOrName,
                    directDownloadUrl = command.args.content?.trim()?.takeIf { it.isNotEmpty() }
                )
            }
        }
    }

    private fun executeFapHubSearch(query: String): CommandResultData {
        val matches = FapHubCatalog.searchApps(query)
        if (matches.isEmpty()) {
            return CommandResultData(
                content = "No FapHub apps found for \"$query\".",
                message = "FapHub search returned 0 results"
            )
        }

        val previewLimit = 12
        val content = buildString {
            appendLine("FapHub matches for \"$query\":")
            matches.take(previewLimit).forEachIndexed { index, app ->
                appendLine(
                    "${index + 1}. ${app.name} (id=${app.id}, category=${app.category.name.lowercase()}, author=${app.author}, version=${app.version})"
                )
            }
            if (matches.size > previewLimit) {
                append("... ${matches.size - previewLimit} more result(s)")
            }
        }.trim()

        return CommandResultData(
            content = content,
            message = "FapHub search returned ${matches.size} result(s)"
        )
    }

    private suspend fun executeFapHubInstall(
        appIdOrName: String,
        directDownloadUrl: String?
    ): CommandResultData {
        val app = resolveCatalogFapApp(appIdOrName)
        if (app == null && directDownloadUrl.isNullOrBlank()) {
            throw IllegalArgumentException(
                "FapHub app \"$appIdOrName\" was not found in catalog. " +
                        "Run search_faphub first or provide args.download_url with a direct .fap URL."
            )
        }

        val installId = sanitizeAppIdentifier(app?.id ?: appIdOrName)
        val installName = app?.name ?: appIdOrName
        val category = app?.category ?: FapCategory.MISC
        val sourceUrl = directDownloadUrl ?: app?.downloadUrl
            ?: throw IllegalArgumentException("Missing source URL for FapHub app install")

        val resolvedBinaryUrl = resolveFapBinaryUrl(
            sourceUrl = sourceUrl,
            appIdHint = installId
        )
        val download = downloadBinary(resolvedBinaryUrl)
        if (looksLikeHtml(download.contentType, download.bytes)) {
            throw IOException(
                "Resolved URL returned HTML/non-binary content instead of a .fap file. " +
                        "Provide a direct .fap URL in args.download_url."
            )
        }
        if (download.bytes.isEmpty()) {
            throw IOException("Downloaded file is empty")
        }
        if (download.bytes.size > MAX_FAP_BYTES) {
            throw IOException("Downloaded file too large (${download.bytes.size} bytes)")
        }

        val installDir = "/ext/apps/${category.name.lowercase()}"
        ensureDirectoryExists(installDir)
        val targetPath = "$installDir/$installId.fap"
        val bytesWritten = fileSystem.writeFileBytes(targetPath, download.bytes).getOrThrow()

        return CommandResultData(
            bytesWritten = bytesWritten,
            content = "installed_app=$installName\napp_id=$installId\nsource_url=$resolvedBinaryUrl\ntarget_path=$targetPath",
            message = "Installed $installName to $targetPath"
        )
    }

    private fun resolveCatalogFapApp(appIdOrName: String): FapApp? {
        val needle = appIdOrName.trim().lowercase()
        if (needle.isBlank()) return null

        return FapHubCatalog.allApps.firstOrNull { it.id.equals(needle, ignoreCase = true) }
            ?: FapHubCatalog.allApps.firstOrNull { it.name.equals(appIdOrName, ignoreCase = true) }
            ?: FapHubCatalog.allApps.firstOrNull { it.id.lowercase().contains(needle) }
            ?: FapHubCatalog.allApps.firstOrNull { it.name.lowercase().contains(needle) }
    }

    private suspend fun resolveFapBinaryUrl(sourceUrl: String, appIdHint: String): String {
        val normalizedSource = sourceUrl.trim()
        if (normalizedSource.isBlank()) {
            throw IllegalArgumentException("FapHub source URL cannot be blank")
        }

        if (normalizedSource.contains(".fap", ignoreCase = true)) {
            return normalizedSource
        }

        val html = downloadText(normalizedSource)
        val candidates = extractFapCandidates(html, normalizedSource)
        if (candidates.isEmpty()) {
            throw IllegalArgumentException(
                "No .fap download URL found at $normalizedSource. " +
                        "Provide a direct .fap URL in args.download_url."
            )
        }

        return candidates.firstOrNull { it.contains(appIdHint, ignoreCase = true) }
            ?: candidates.first()
    }

    private suspend fun downloadText(url: String): String = withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url(url)
            .header("User-Agent", USER_AGENT)
            .header("Accept", "text/html,application/xhtml+xml")
            .build()

        httpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("HTTP ${response.code} while requesting $url")
            }
            val body = response.body?.string()
                ?: throw IOException("Empty response body from $url")
            if (body.length > MAX_HTML_CHARS) {
                body.take(MAX_HTML_CHARS)
            } else {
                body
            }
        }
    }

    private suspend fun downloadBinary(url: String): DownloadedPayload = withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url(url)
            .header("User-Agent", USER_AGENT)
            .header("Accept", "application/octet-stream,*/*")
            .build()

        httpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("HTTP ${response.code} while downloading $url")
            }
            val body = response.body?.bytes()
                ?: throw IOException("Empty download body from $url")
            DownloadedPayload(
                bytes = body,
                contentType = response.header("Content-Type")
            )
        }
    }

    private fun extractFapCandidates(html: String, baseUrl: String): List<String> {
        val hrefMatches = HREF_FAP_REGEX.findAll(html)
            .mapNotNull { match -> match.groupValues.getOrNull(1) }
            .toList()
        val absoluteMatches = ABSOLUTE_FAP_REGEX.findAll(html)
            .mapNotNull { match -> match.groupValues.getOrNull(1) }
            .toList()

        return (hrefMatches + absoluteMatches)
            .mapNotNull { it.trim().trim('"', '\'').takeIf { value -> value.isNotEmpty() } }
            .map { raw ->
                runCatching { URI(baseUrl).resolve(raw).toString() }.getOrElse { raw }
            }
            .filter { it.startsWith("http://", ignoreCase = true) || it.startsWith("https://", ignoreCase = true) }
            .distinct()
    }

    private suspend fun ensureDirectoryExists(path: String) {
        val createResult = fileSystem.createDirectory(path)
        if (createResult.isSuccess) return

        val errorMessage = createResult.exceptionOrNull()?.message?.lowercase().orEmpty()
        if ("already" in errorMessage && "exist" in errorMessage) return

        val exists = fileSystem.listDirectory(path).isSuccess
        if (!exists) {
            throw createResult.exceptionOrNull() ?: IOException("Failed to create directory: $path")
        }
    }

    private fun looksLikeHtml(contentType: String?, bytes: ByteArray): Boolean {
        val type = contentType.orEmpty().lowercase()
        if (type.contains("text/html") || type.contains("application/xhtml")) {
            return true
        }
        val preview = bytes
            .take(48)
            .toByteArray()
            .toString(Charsets.UTF_8)
            .trimStart()
            .lowercase()
        return preview.startsWith("<!doctype") || preview.startsWith("<html") || preview.startsWith("<head")
    }

    private fun sanitizeAppIdentifier(value: String): String {
        val sanitized = value.lowercase()
            .replace(Regex("[^a-z0-9_\\-.]+"), "_")
            .trim('_', '.', '-')
        return sanitized.ifBlank { "downloaded_app" }
    }

    private suspend fun computeDiff(path: String, newContent: String): FileDiff {
        val originalContent = try {
            fileSystem.readFile(path).getOrNull()
        } catch (e: Exception) {
            null
        }

        return diffService.computeDiff(originalContent, newContent)
    }

    fun getPendingApproval(approvalId: String): PendingApproval? {
        clearExpiredApprovals()
        return pendingApprovals[approvalId]
    }

    fun clearExpiredApprovals() {
        val now = System.currentTimeMillis()
        pendingApprovals.entries.removeIf { it.value.expiresAt < now }
        _currentApproval.value?.let {
            if (it.expiresAt < now) {
                _currentApproval.value = null
            }
        }
    }

    private data class DownloadedPayload(
        val bytes: ByteArray,
        val contentType: String?
    )

    companion object {
        private const val USER_AGENT = "VesperFlipper/1.0 (Android)"
        private const val MAX_FAP_BYTES = 6 * 1024 * 1024
        private const val MAX_HTML_CHARS = 256_000
        private val HREF_FAP_REGEX = Regex(
            """href\s*=\s*["']([^"']+\.fap(?:\?[^"']*)?)["']""",
            RegexOption.IGNORE_CASE
        )
        private val ABSOLUTE_FAP_REGEX = Regex(
            """(https?://[^\s"'<>]+\.fap(?:\?[^\s"'<>]*)?)""",
            RegexOption.IGNORE_CASE
        )
        private val httpClient = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .build()
    }
}
