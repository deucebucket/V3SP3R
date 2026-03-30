package com.vesper.flipper.ble

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.inject.Singleton

/**
 * JSON-RPC 2.0 client for delphinOS firmware.
 *
 * Sends newline-delimited JSON-RPC requests over BLE serial and
 * dispatches responses/notifications to the appropriate handlers.
 *
 * Protocol matches delphinOS ai_bridge service:
 * - Request:      {"jsonrpc":"2.0","method":"...", "params":{...}, "id":N}
 * - Response:     {"jsonrpc":"2.0","result":{...}, "id":N}
 * - Error:        {"jsonrpc":"2.0","error":{"code":N,"message":"..."}, "id":N}
 * - Notification: {"jsonrpc":"2.0","method":"...", "params":{...}}  (no id)
 */
@Singleton
class JsonRpcClient @Inject constructor() {

    companion object {
        private const val TAG = "JsonRpc"
        private const val DEFAULT_TIMEOUT_MS = 10_000L
    }

    private val nextId = AtomicLong(1)
    private val pendingRequests = ConcurrentHashMap<Long, CompletableDeferred<JsonRpcResponse>>()
    private val rxBuffer = StringBuilder()

    /** Outgoing data — BLE service subscribes to this and sends bytes over BLE serial */
    private val _outgoing = MutableSharedFlow<ByteArray>(extraBufferCapacity = 16)
    val outgoing: SharedFlow<ByteArray> = _outgoing

    /** Incoming notifications from firmware (ptt.started, ptt.stopped, etc.) */
    private val _notifications = MutableSharedFlow<JsonRpcNotification>(extraBufferCapacity = 32)
    val notifications: SharedFlow<JsonRpcNotification> = _notifications

    /** Whether we've gotten a successful ping back from delphinOS firmware */
    private val _firmwareDetected = MutableStateFlow(false)
    val firmwareDetected: StateFlow<Boolean> = _firmwareDetected

    /**
     * Send a JSON-RPC request and await the response.
     */
    suspend fun request(
        method: String,
        params: JsonObject? = null,
        timeoutMs: Long = DEFAULT_TIMEOUT_MS
    ): JsonRpcResponse {
        val id = nextId.getAndIncrement()
        val deferred = CompletableDeferred<JsonRpcResponse>()
        pendingRequests[id] = deferred

        val request = buildJsonObject {
            put("jsonrpc", "2.0")
            put("method", method)
            if (params != null) put("params", params)
            put("id", id)
        }

        val line = Json.encodeToString(JsonObject.serializer(), request) + "\n"
        Log.d(TAG, "TX: $line")
        _outgoing.emit(line.toByteArray(Charsets.UTF_8))

        return try {
            withTimeout(timeoutMs) { deferred.await() }
        } catch (e: TimeoutCancellationException) {
            pendingRequests.remove(id)
            JsonRpcResponse.Error(-32000, "Request timed out: $method")
        }
    }

    /**
     * Send a fire-and-forget notification (no id, no response expected).
     */
    suspend fun notify(method: String, params: JsonObject? = null) {
        val notification = buildJsonObject {
            put("jsonrpc", "2.0")
            put("method", method)
            if (params != null) put("params", params)
        }
        val line = Json.encodeToString(JsonObject.serializer(), notification) + "\n"
        _outgoing.emit(line.toByteArray(Charsets.UTF_8))
    }

    /**
     * Feed incoming BLE data. Called by BLE service when data arrives.
     * Accumulates bytes, splits on newlines, parses JSON-RPC frames.
     */
    fun feedData(data: ByteArray) {
        val text = String(data, Charsets.UTF_8)
        rxBuffer.append(text)

        while (true) {
            val newlineIdx = rxBuffer.indexOf('\n')
            if (newlineIdx < 0) break

            val line = rxBuffer.substring(0, newlineIdx).trim()
            rxBuffer.delete(0, newlineIdx + 1)

            if (line.isNotEmpty()) {
                parseLine(line)
            }
        }
    }

    /**
     * Probe whether connected device is running delphinOS.
     * Sends system.ping and checks for delphinOS response.
     */
    suspend fun detectFirmware(): Boolean {
        return try {
            val resp = request("system.ping", timeoutMs = 3000)
            if (resp is JsonRpcResponse.Success) {
                val result = resp.result
                val isDelphinOS = result?.toString()?.contains("delphinOS") == true
                _firmwareDetected.value = isDelphinOS
                isDelphinOS
            } else {
                _firmwareDetected.value = false
                false
            }
        } catch (e: Exception) {
            _firmwareDetected.value = false
            false
        }
    }

    /** Reset state on disconnect */
    fun reset() {
        rxBuffer.clear()
        _firmwareDetected.value = false
        pendingRequests.values.forEach {
            it.completeExceptionally(CancellationException("Disconnected"))
        }
        pendingRequests.clear()
    }

    // ---- Convenience methods for common commands ----

    suspend fun setExpression(expr: String): JsonRpcResponse {
        return request("screen.set_expression", buildJsonObject {
            put("expression", expr)
        })
    }

    suspend fun pushChat(role: String, text: String): JsonRpcResponse {
        return request("screen.push_chat", buildJsonObject {
            put("role", role)
            put("text", text)
        })
    }

    suspend fun setStatusText(text: String): JsonRpcResponse {
        return request("screen.set_status", buildJsonObject {
            put("text", text)
        })
    }

    suspend fun getBattery(): JsonRpcResponse {
        return request("system.battery")
    }

    suspend fun getCapabilities(): JsonRpcResponse {
        return request("system.capabilities")
    }

    suspend fun ledColor(color: String): JsonRpcResponse {
        return request("system.led", buildJsonObject {
            put("color", color)
        })
    }

    suspend fun vibrate(): JsonRpcResponse {
        return request("system.vibrate")
    }

    suspend fun subghzTx(file: String, freq: Long? = null): JsonRpcResponse {
        return request("subghz.tx", buildJsonObject {
            put("file", file)
            if (freq != null) put("freq", freq)
        })
    }

    suspend fun nfcScan(timeoutMs: Long = 5000): JsonRpcResponse {
        return request("nfc.scan", buildJsonObject {
            put("timeout", timeoutMs)
        })
    }

    suspend fun irTx(file: String, signal: String? = null): JsonRpcResponse {
        return request("ir.tx", buildJsonObject {
            put("file", file)
            if (signal != null) put("signal", signal)
        })
    }

    suspend fun wifiScan(type: String = "ap", timeoutMs: Long = 10000): JsonRpcResponse {
        return request("wifi.scan", buildJsonObject {
            put("type", type)
            put("timeout", timeoutMs)
        })
    }

    suspend fun gpioRead(pin: Int): JsonRpcResponse {
        return request("gpio.read", buildJsonObject {
            put("pin", pin)
        })
    }

    suspend fun gpioWrite(pin: Int, value: Boolean): JsonRpcResponse {
        return request("gpio.write", buildJsonObject {
            put("pin", pin)
            put("value", value)
        })
    }

    // ---- Internal parsing ----

    private fun parseLine(line: String) {
        Log.d(TAG, "RX: $line")
        try {
            val json = Json.parseToJsonElement(line).jsonObject

            val id = json["id"]?.jsonPrimitive?.longOrNull

            if (id != null) {
                // Response (has id)
                val deferred = pendingRequests.remove(id)
                if (deferred == null) {
                    Log.w(TAG, "Response for unknown id=$id")
                    return
                }

                val error = json["error"]?.jsonObject
                if (error != null) {
                    val code = error["code"]?.jsonPrimitive?.intOrNull ?: -1
                    val message = error["message"]?.jsonPrimitive?.contentOrNull ?: "Unknown error"
                    deferred.complete(JsonRpcResponse.Error(code, message))
                } else {
                    val result = json["result"]
                    deferred.complete(JsonRpcResponse.Success(result))
                }
            } else {
                // Notification (no id)
                val method = json["method"]?.jsonPrimitive?.contentOrNull ?: return
                val params = json["params"]?.jsonObject
                val notification = JsonRpcNotification(method, params)

                // Emit to subscribers
                _notifications.tryEmit(notification)
            }
        } catch (e: Exception) {
            Log.w(TAG, "Failed to parse JSON-RPC: $line", e)
        }
    }
}

/** JSON-RPC response */
sealed class JsonRpcResponse {
    data class Success(val result: JsonElement?) : JsonRpcResponse()
    data class Error(val code: Int, val message: String) : JsonRpcResponse()

    val isSuccess: Boolean get() = this is Success
}

/** JSON-RPC notification from firmware */
data class JsonRpcNotification(
    val method: String,
    val params: JsonObject?
)
