package com.vesper.flipper.ai

import com.vesper.flipper.ble.JsonRpcClient
import com.vesper.flipper.ble.JsonRpcResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Tool executor for delphinOS firmware.
 * Uses JSON-RPC 2.0 over BLE instead of CLI commands.
 *
 * This is the delphinOS equivalent of FlipperToolExecutor.
 * When the firmware is detected as delphinOS, the AI agent
 * routes tool calls through here instead.
 */
@Singleton
class DelphinToolExecutor @Inject constructor(
    private val jsonRpc: JsonRpcClient
) {

    suspend fun execute(tool: String, parameters: Map<String, String>): ToolResult =
        withContext(Dispatchers.IO) {
            try {
                val params = buildJsonObject {
                    parameters.forEach { (k, v) -> put(k, v) }
                }
                val response = jsonRpc.request(tool, params)
                when (response) {
                    is JsonRpcResponse.Success -> {
                        val resultStr = response.result?.toString() ?: "ok"
                        ToolResult.Success(
                            message = resultStr.take(200),
                            data = mapOf("raw" to resultStr)
                        )
                    }
                    is JsonRpcResponse.Error -> {
                        ToolResult.Error("${response.message} (code ${response.code})")
                    }
                }
            } catch (e: Exception) {
                ToolResult.Error("JSON-RPC error: ${e.message}")
            }
        }

    // ---- High-level operations matching the AI tool schema ----

    suspend fun subghzTransmit(file: String, freq: Long? = null): ToolResult {
        val resp = jsonRpc.subghzTx(file, freq)
        return toToolResult(resp, "SubGHz TX")
    }

    suspend fun nfcScan(timeoutMs: Long = 5000): ToolResult {
        val resp = jsonRpc.nfcScan(timeoutMs)
        return toToolResult(resp, "NFC scan")
    }

    suspend fun irTransmit(file: String, signal: String? = null): ToolResult {
        val resp = jsonRpc.irTx(file, signal)
        return toToolResult(resp, "IR TX")
    }

    suspend fun wifiScan(type: String = "ap"): ToolResult {
        val resp = jsonRpc.wifiScan(type)
        return toToolResult(resp, "WiFi scan")
    }

    suspend fun getBattery(): ToolResult {
        val resp = jsonRpc.getBattery()
        return toToolResult(resp, "Battery")
    }

    suspend fun getCapabilities(): ToolResult {
        val resp = jsonRpc.getCapabilities()
        return toToolResult(resp, "Capabilities")
    }

    suspend fun setExpression(expr: String): ToolResult {
        val resp = jsonRpc.setExpression(expr)
        return toToolResult(resp, "Expression")
    }

    suspend fun pushChat(role: String, text: String): ToolResult {
        val resp = jsonRpc.pushChat(role, text)
        return toToolResult(resp, "Chat push")
    }

    suspend fun gpioRead(pin: Int): ToolResult {
        val resp = jsonRpc.gpioRead(pin)
        return toToolResult(resp, "GPIO read")
    }

    suspend fun gpioWrite(pin: Int, value: Boolean): ToolResult {
        val resp = jsonRpc.gpioWrite(pin, value)
        return toToolResult(resp, "GPIO write")
    }

    suspend fun ledColor(color: String): ToolResult {
        val resp = jsonRpc.ledColor(color)
        return toToolResult(resp, "LED")
    }

    suspend fun vibrate(): ToolResult {
        val resp = jsonRpc.vibrate()
        return toToolResult(resp, "Vibrate")
    }

    private fun toToolResult(resp: JsonRpcResponse, label: String): ToolResult {
        return when (resp) {
            is JsonRpcResponse.Success -> {
                val resultStr = resp.result?.toString() ?: "ok"
                ToolResult.Success(
                    message = "$label: $resultStr".take(200),
                    data = mapOf("raw" to resultStr)
                )
            }
            is JsonRpcResponse.Error -> {
                ToolResult.Error("$label failed: ${resp.message}")
            }
        }
    }
}
