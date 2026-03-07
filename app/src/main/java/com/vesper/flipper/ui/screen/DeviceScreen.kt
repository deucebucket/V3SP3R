package com.vesper.flipper.ui.screen

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vesper.flipper.ble.CliCapabilityLevel
import com.vesper.flipper.ble.CliCapabilityStatus
import com.vesper.flipper.ble.CommandPipelineAutotuneStatus
import com.vesper.flipper.ble.ConnectionCheckLevel
import com.vesper.flipper.ble.ConnectionDiagnosticsReport
import com.vesper.flipper.ble.ConnectionState
import com.vesper.flipper.ble.FirmwareCompatibilityProfile
import com.vesper.flipper.ble.FirmwareTransportMode
import com.vesper.flipper.ble.FlipperDevice
import com.vesper.flipper.domain.model.FlipperRemoteButton
import com.vesper.flipper.ui.theme.*
import com.vesper.flipper.ui.viewmodel.DeviceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceScreen(
    viewModel: DeviceViewModel = hiltViewModel()
) {
    val connectionState by viewModel.connectionState.collectAsState()
    val discoveredDevices by viewModel.discoveredDevices.collectAsState()
    val connectedDevice by viewModel.connectedDevice.collectAsState()
    val deviceInfo by viewModel.deviceInfo.collectAsState()
    val storageInfo by viewModel.storageInfo.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val cliCapabilityStatus by viewModel.cliCapabilityStatus.collectAsState()
    val connectionDiagnostics by viewModel.connectionDiagnostics.collectAsState()
    val isRunningDiagnostics by viewModel.isRunningDiagnostics.collectAsState()
    val autotuneStatus by viewModel.autotuneStatus.collectAsState()
    val firmwareCompatibility by viewModel.firmwareCompatibility.collectAsState()
    val isSendingRemoteInput by viewModel.isSendingRemoteInput.collectAsState()
    val remoteInputStatus by viewModel.remoteInputStatus.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Device", fontWeight = FontWeight.Bold)
                },
                actions = {
                    if (connectionState is ConnectionState.Connected) {
                        IconButton(
                            onClick = { viewModel.refreshDeviceInfo() },
                            enabled = !isRefreshing
                        ) {
                            if (isRefreshing) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(20.dp),
                                    color = VesperOrange,
                                    strokeWidth = 2.dp
                                )
                            } else {
                                Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Connection Status Card
            item {
                ConnectionStatusCard(
                    connectionState = connectionState,
                    connectedDevice = connectedDevice,
                    onDisconnect = { viewModel.disconnect() }
                )
            }

            item {
                CommandAutomationStatusCard(
                    connectionState = connectionState,
                    cliStatus = cliCapabilityStatus,
                    diagnostics = connectionDiagnostics,
                    autotuneStatus = autotuneStatus,
                    firmwareCompatibility = firmwareCompatibility,
                    isRunningDiagnostics = isRunningDiagnostics,
                    onRunDiagnostics = { viewModel.runConnectionDiagnostics() }
                )
            }

            if (connectionState is ConnectionState.Connected) {
                item {
                    RemoteControlCard(
                        isSendingRemoteInput = isSendingRemoteInput,
                        statusText = remoteInputStatus,
                        onSendButton = { button, longPress ->
                            viewModel.sendRemoteButton(button, longPress)
                        }
                    )
                }
            }

            // Device Info Card (when connected)
            if (connectionState is ConnectionState.Connected && deviceInfo != null) {
                item {
                    DeviceInfoCard(
                        deviceInfo = deviceInfo!!,
                        storageInfo = storageInfo
                    )
                }
            }

            // Scan/Connect Section
            if (connectionState !is ConnectionState.Connected) {
                item {
                    ScanSection(
                        isScanning = connectionState is ConnectionState.Scanning,
                        onStartScan = { viewModel.startScan() },
                        onStopScan = { viewModel.stopScan() },
                        onConnectUsb = { viewModel.connectUsb() }
                    )
                }

                // Discovered Devices
                if (discoveredDevices.isNotEmpty()) {
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "Discovered Devices",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Showing Flipper devices only, including custom device names.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    items(discoveredDevices) { device ->
                        DeviceListItem(
                            device = device,
                            isConnecting = connectionState is ConnectionState.Connecting &&
                                    (connectionState as ConnectionState.Connecting).deviceName == device.name,
                            onClick = { viewModel.connectToDevice(device) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ConnectionStatusCard(
    connectionState: ConnectionState,
    connectedDevice: FlipperDevice?,
    onDisconnect: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = when (connectionState) {
                is ConnectionState.Connected -> VesperAccent.copy(alpha = 0.1f)
                is ConnectionState.Connecting -> RiskMedium.copy(alpha = 0.1f)
                is ConnectionState.Error -> RiskHigh.copy(alpha = 0.1f)
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Status Icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(
                        when (connectionState) {
                            is ConnectionState.Connected -> VesperAccent
                            is ConnectionState.Connecting -> RiskMedium
                            is ConnectionState.Error -> RiskHigh
                            else -> MaterialTheme.colorScheme.secondary
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when (connectionState) {
                        is ConnectionState.Connected -> Icons.Default.BluetoothConnected
                        is ConnectionState.Connecting -> Icons.Default.BluetoothSearching
                        is ConnectionState.Scanning -> Icons.Default.BluetoothSearching
                        is ConnectionState.Error -> Icons.Default.BluetoothDisabled
                        else -> Icons.Default.Bluetooth
                    },
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Status Text
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = when (connectionState) {
                        is ConnectionState.Connected -> "Connected"
                        is ConnectionState.Connecting -> "Connecting..."
                        is ConnectionState.Scanning -> "Scanning..."
                        is ConnectionState.Error -> "Error"
                        else -> "Disconnected"
                    },
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = when (connectionState) {
                        is ConnectionState.Connected -> connectedDevice?.name ?: connectionState.deviceName
                        is ConnectionState.Connecting -> connectionState.deviceName
                        is ConnectionState.Error -> connectionState.message
                        else -> "No device connected"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Disconnect Button
            if (connectionState is ConnectionState.Connected) {
                IconButton(onClick = onDisconnect) {
                    Icon(
                        Icons.Default.LinkOff,
                        contentDescription = "Disconnect",
                        tint = RiskHigh
                    )
                }
            }
        }
    }
}

@Composable
private fun DeviceInfoCard(
    deviceInfo: com.vesper.flipper.domain.model.DeviceInfo,
    storageInfo: com.vesper.flipper.domain.model.StorageInfo?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Device Information",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            // Battery
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        if (deviceInfo.isCharging) Icons.Default.BatteryChargingFull
                        else Icons.Default.Battery5Bar,
                        contentDescription = null,
                        tint = when {
                            deviceInfo.batteryLevel > 50 -> VesperAccent
                            deviceInfo.batteryLevel > 20 -> RiskMedium
                            else -> RiskHigh
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Battery")
                }
                Text(
                    "${deviceInfo.batteryLevel}%${if (deviceInfo.isCharging) " (Charging)" else ""}",
                    fontWeight = FontWeight.Medium
                )
            }

            Divider()

            // Firmware
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Memory, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Firmware")
                }
                Text(deviceInfo.firmwareVersion, fontWeight = FontWeight.Medium)
            }

            // Storage
            storageInfo?.let { storage ->
                Divider()

                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Storage, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Internal Storage")
                        }
                        Text(
                            "${formatBytes(storage.internalFree)} / ${formatBytes(storage.internalTotal)}",
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Storage progress bar
                    val usedPercent = if (storage.internalTotal > 0L) {
                        (1f - (storage.internalFree.toFloat() / storage.internalTotal.toFloat()))
                            .coerceIn(0f, 1f)
                    } else {
                        0f
                    }
                    LinearProgressIndicator(
                        progress = usedPercent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = when {
                            usedPercent < 0.7f -> VesperAccent
                            usedPercent < 0.9f -> RiskMedium
                            else -> RiskHigh
                        },
                        trackColor = MaterialTheme.colorScheme.surface
                    )
                }

                if (storage.hasSdCard && storage.externalTotal != null) {
                    Spacer(modifier = Modifier.height(12.dp))

                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.SdCard, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("SD Card")
                            }
                            Text(
                                "${formatBytes(storage.externalFree ?: 0)} / ${formatBytes(storage.externalTotal)}",
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        val sdUsedPercent = 1f - ((storage.externalFree ?: 0).toFloat() / storage.externalTotal.toFloat())
                        LinearProgressIndicator(
                            progress = sdUsedPercent,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = when {
                                sdUsedPercent < 0.7f -> VesperAccent
                                sdUsedPercent < 0.9f -> RiskMedium
                                else -> RiskHigh
                            },
                            trackColor = MaterialTheme.colorScheme.surface
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CommandAutomationStatusCard(
    connectionState: ConnectionState,
    cliStatus: CliCapabilityStatus,
    diagnostics: ConnectionDiagnosticsReport,
    autotuneStatus: CommandPipelineAutotuneStatus,
    firmwareCompatibility: FirmwareCompatibilityProfile,
    isRunningDiagnostics: Boolean,
    onRunDiagnostics: () -> Unit
) {
    val (title, detail, tint) = when {
        connectionState !is ConnectionState.Connected -> Triple(
            "Automation Channel",
            "Connect a Flipper to check CLI/RPC automation readiness.",
            MaterialTheme.colorScheme.onSurfaceVariant
        )
        cliStatus.level == CliCapabilityLevel.READY && cliStatus.supportsCli -> Triple(
            "Automation Ready",
            cliStatus.firmwareHint?.let { "CLI/RPC responsive ($it)." }
                ?: "CLI/RPC responsive and ready for autonomous command workflows.",
            VesperAccent
        )
        cliStatus.level == CliCapabilityLevel.READY && cliStatus.supportsRpc -> Triple(
            "RPC Ready (CLI Limited)",
            if (cliStatus.details.isNotBlank()) {
                "RPC automation is responsive. ${cliStatus.details}"
            } else {
                "RPC automation is responsive, but direct CLI commands are unavailable on this connection."
            },
            RiskMedium
        )
        cliStatus.level == CliCapabilityLevel.READY -> Triple(
            "Automation Ready",
            "Transport is responsive.",
            VesperAccent
        )
        cliStatus.level == CliCapabilityLevel.UNAVAILABLE -> Triple(
            "Automation Unavailable",
            cliStatus.details,
            RiskHigh
        )
        else -> Triple(
            "Probing Automation Channel",
            "Checking CLI/RPC transport capabilities...",
            RiskMedium
        )
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Memory,
                    contentDescription = null,
                    tint = tint
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = detail,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            FilledTonalButton(
                onClick = onRunDiagnostics,
                enabled = !isRunningDiagnostics
            ) {
                if (isRunningDiagnostics) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        strokeWidth = 2.dp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Running link diagnostics...")
                } else {
                    Icon(Icons.Default.BugReport, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Run Link Diagnostics")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Divider()
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Compatibility Layer",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = buildString {
                    append("Firmware: ")
                    append(firmwareCompatibility.label)
                    append(" | Mode: ")
                    append(
                        when (firmwareCompatibility.transportMode) {
                            FirmwareTransportMode.CLI_AND_RPC -> "CLI + RPC"
                            FirmwareTransportMode.CLI_ONLY -> "CLI-only"
                            FirmwareTransportMode.RPC_ONLY -> "RPC-only"
                            FirmwareTransportMode.UNAVAILABLE -> "Unavailable"
                        }
                    )
                    append(" | Confidence: ")
                    append((firmwareCompatibility.confidence * 100f).toInt())
                    append('%')
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = firmwareCompatibility.notes,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(10.dp))
            Divider()
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Connection Autotuner",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = buildString {
                    append("Profile: ")
                    append(autotuneStatus.profileLabel)
                    append(" | Success: ")
                    append((autotuneStatus.successRate * 100f).toInt())
                    append("% | Avg latency: ")
                    append(autotuneStatus.averageLatencyMs)
                    append("ms")
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "Retries cli=${autotuneStatus.cliRetryAttempts} rpc=${autotuneStatus.rpcRetryAttempts} write=${autotuneStatus.fileWriteRetryAttempts} | busy=${autotuneStatus.busySignals} disconnect=${autotuneStatus.disconnectSignals}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (diagnostics.checks.isNotEmpty()) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "${diagnostics.summary} (${diagnostics.durationMs} ms)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                diagnostics.checks.forEach { check ->
                    val (icon, checkTint) = when (check.level) {
                        ConnectionCheckLevel.PASS -> Icons.Default.CheckCircle to VesperAccent
                        ConnectionCheckLevel.WARN -> Icons.Default.Warning to RiskMedium
                        ConnectionCheckLevel.FAIL -> Icons.Default.Error to RiskHigh
                        ConnectionCheckLevel.SKIPPED -> Icons.Default.RemoveCircleOutline to MaterialTheme.colorScheme.onSurfaceVariant
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = checkTint,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${check.name}: ${check.detail}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RemoteControlCard(
    isSendingRemoteInput: Boolean,
    statusText: String?,
    onSendButton: (FlipperRemoteButton, Boolean) -> Unit
) {
    val controlsEnabled = !isSendingRemoteInput
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Gamepad,
                    contentDescription = null,
                    tint = VesperOrange
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Remote Buttons",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Direct Flipper button control over RPC",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            DPadRow {
                RemoteControlButton(
                    icon = Icons.Default.KeyboardArrowUp,
                    label = "Up",
                    enabled = controlsEnabled,
                    onClick = { onSendButton(FlipperRemoteButton.UP, false) }
                )
            }
            DPadRow {
                RemoteControlButton(
                    icon = Icons.Default.KeyboardArrowLeft,
                    label = "Left",
                    enabled = controlsEnabled,
                    onClick = { onSendButton(FlipperRemoteButton.LEFT, false) }
                )
                Spacer(modifier = Modifier.width(10.dp))
                RemoteControlButton(
                    icon = Icons.Default.Check,
                    label = "OK",
                    enabled = controlsEnabled,
                    onClick = { onSendButton(FlipperRemoteButton.OK, false) }
                )
                Spacer(modifier = Modifier.width(10.dp))
                RemoteControlButton(
                    icon = Icons.Default.KeyboardArrowRight,
                    label = "Right",
                    enabled = controlsEnabled,
                    onClick = { onSendButton(FlipperRemoteButton.RIGHT, false) }
                )
            }
            DPadRow {
                RemoteControlButton(
                    icon = Icons.Default.KeyboardArrowDown,
                    label = "Down",
                    enabled = controlsEnabled,
                    onClick = { onSendButton(FlipperRemoteButton.DOWN, false) }
                )
            }

            DPadRow {
                OutlinedButton(
                    onClick = { onSendButton(FlipperRemoteButton.BACK, false) },
                    enabled = controlsEnabled,
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Back")
                }
            }

            if (isSendingRemoteInput) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = VesperOrange
                )
            }

            statusText?.let { status ->
                Text(
                    text = status,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun DPadRow(content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}

@Composable
private fun RemoteControlButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    enabled: Boolean,
    onClick: () -> Unit
) {
    FilledTonalButton(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.widthIn(min = 86.dp)
    ) {
        Icon(icon, contentDescription = label)
        Spacer(modifier = Modifier.width(4.dp))
        Text(label)
    }
}

@Composable
private fun ScanSection(
    isScanning: Boolean,
    onStartScan: () -> Unit,
    onStopScan: () -> Unit,
    onConnectUsb: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            onClick = if (isScanning) onStopScan else onStartScan,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isScanning) RiskHigh else VesperOrange
            )
        ) {
            if (isScanning) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = Color.White,
                    strokeWidth = 2.dp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Stop Scanning")
            } else {
                Icon(Icons.Default.BluetoothSearching, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Scan for Flipper")
            }
        }

        OutlinedButton(
            onClick = onConnectUsb,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Usb, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Connect via USB")
        }
    }
}

@Composable
private fun DeviceListItem(
    device: FlipperDevice,
    isConnecting: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = !isConnecting, onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(VesperOrange),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Toys,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = device.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (device.isConfirmedFlipper) "Flipper signature detected" else "Unverified Flipper",
                    style = MaterialTheme.typography.labelSmall,
                    color = if (device.isConfirmedFlipper) VesperAccent else RiskMedium
                )
                Text(
                    text = device.address,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (isConnecting) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = VesperOrange,
                    strokeWidth = 2.dp
                )
            } else {
                // Signal strength indicator
                val signalBars = when {
                    device.rssi >= -50 -> 4
                    device.rssi >= -60 -> 3
                    device.rssi >= -70 -> 2
                    else -> 1
                }
                Icon(
                    when (signalBars) {
                        4 -> Icons.Default.SignalCellular4Bar
                        else -> Icons.Default.SignalCellular4Bar
                    },
                    contentDescription = "Signal: $signalBars bars",
                    tint = VesperAccent.copy(alpha = signalBars / 4f)
                )
            }
        }
    }
}

private fun formatBytes(bytes: Long): String {
    return when {
        bytes < 1024 -> "$bytes B"
        bytes < 1024 * 1024 -> "${bytes / 1024} KB"
        bytes < 1024 * 1024 * 1024 -> "${bytes / (1024 * 1024)} MB"
        else -> "${"%.1f".format(bytes.toFloat() / (1024 * 1024 * 1024))} GB"
    }
}
