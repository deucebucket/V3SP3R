package com.vesper.flipper.domain.model

import kotlin.math.PI
import kotlin.math.sin
import kotlin.random.Random

/**
 * Protocol Alchemy - Visual Signal Synthesizer
 * Craft custom RF signals like a DJ mixing tracks!
 */

/**
 * Represents a synthesized signal project
 */
data class AlchemyProject(
    val id: String = java.util.UUID.randomUUID().toString(),
    val name: String,
    val frequency: Long,                    // Hz
    val modulation: ModulationType,
    val preset: SignalPreset,
    val layers: List<SignalLayer>,
    val tempo: Int = 120,                   // BPM for timing
    val createdAt: Long = System.currentTimeMillis()
)

/**
 * A layer in the signal composition
 */
data class SignalLayer(
    val id: String = java.util.UUID.randomUUID().toString(),
    val name: String,
    val type: LayerType,
    val enabled: Boolean = true,
    val volume: Float = 1.0f,              // 0.0 - 1.0 amplitude
    val pattern: BitPattern,
    val timing: TimingConfig,
    val color: Long = 0xFFFF6B00           // For visualization
)

enum class LayerType(val displayName: String, val icon: String) {
    CARRIER("Carrier Wave", "〜"),
    DATA("Data Bits", "▪▪▪"),
    PREAMBLE("Preamble", "▶"),
    SYNC("Sync Word", "◆"),
    NOISE("Noise/Jammer", "▓"),
    SWEEP("Frequency Sweep", "↗"),
    BURST("Burst Pattern", "█░█")
}

/**
 * Modulation types supported by Flipper
 */
enum class ModulationType(
    val displayName: String,
    val flipperPreset: String,
    val description: String
) {
    OOK_270("OOK 270kHz", "FuriHalSubGhzPresetOok270Async", "On-Off Keying, narrow bandwidth"),
    OOK_650("OOK 650kHz", "FuriHalSubGhzPresetOok650Async", "On-Off Keying, standard"),
    FSK_238("2FSK 2.38kHz", "FuriHalSubGhzPreset2FSKDev238Async", "Frequency Shift Keying"),
    FSK_476("2FSK 4.76kHz", "FuriHalSubGhzPreset2FSKDev476Async", "FSK wider deviation"),
    GFSK("GFSK", "FuriHalSubGhzPresetGFSK", "Gaussian FSK"),
    MSK("MSK", "FuriHalSubGhzPresetMSK", "Minimum Shift Keying"),
    CUSTOM("Custom RAW", "FuriHalSubGhzPresetCustom", "Raw timing data")
}

/**
 * Common frequency presets
 */
enum class SignalPreset(
    val displayName: String,
    val frequency: Long,
    val region: String
) {
    GARAGE_300("Garage 300MHz", 300_000_000, "US"),
    GARAGE_315("Garage 315MHz", 315_000_000, "US"),
    GARAGE_390("Garage 390MHz", 390_000_000, "US"),
    CAR_KEY_433("Car Key 433MHz", 433_920_000, "EU"),
    CAR_KEY_868("Car Key 868MHz", 868_350_000, "EU"),
    TPMS_315("TPMS 315MHz", 315_000_000, "US"),
    TPMS_433("TPMS 433MHz", 433_920_000, "EU"),
    WEATHER_433("Weather Station", 433_920_000, "Global"),
    KEYFOB_315("Key Fob 315MHz", 315_000_000, "US"),
    KEYFOB_433("Key Fob 433MHz", 433_920_000, "EU"),
    CUSTOM("Custom", 433_920_000, "Any")
}

/**
 * Bit pattern configuration
 */
data class BitPattern(
    val bits: List<Boolean>,               // true = high, false = low
    val bitDuration: Int = 500,            // microseconds per bit
    val encoding: BitEncoding = BitEncoding.NRZ
)

enum class BitEncoding(val displayName: String) {
    NRZ("NRZ (Non-Return-to-Zero)"),
    MANCHESTER("Manchester"),
    BIPHASE("Bi-Phase"),
    PWM("Pulse Width Modulation"),
    PPM("Pulse Position Modulation")
}

/**
 * Timing configuration for a layer
 */
data class TimingConfig(
    val delayBefore: Int = 0,              // microseconds
    val repeatCount: Int = 1,
    val repeatDelay: Int = 10000,          // microseconds between repeats
    val dutyCycle: Float = 0.5f            // for PWM
)

/**
 * Signal synthesis engine
 */
object SignalAlchemist {

    /**
     * Generate RAW timing data from an Alchemy project
     */
    fun synthesize(project: AlchemyProject): List<Int> {
        val rawData = mutableListOf<Int>()

        project.layers
            .filter { it.enabled }
            .sortedBy { it.timing.delayBefore }
            .forEach { layer ->
                // Add delay if needed
                if (layer.timing.delayBefore > 0) {
                    rawData.add(-layer.timing.delayBefore)
                }

                // Generate layer data
                repeat(layer.timing.repeatCount) { rep ->
                    rawData.addAll(generateLayerData(layer, project.modulation))

                    if (rep < layer.timing.repeatCount - 1 && layer.timing.repeatDelay > 0) {
                        rawData.add(-layer.timing.repeatDelay)
                    }
                }
            }

        return rawData
    }

    private fun generateLayerData(layer: SignalLayer, modulation: ModulationType): List<Int> {
        return when (layer.type) {
            LayerType.CARRIER -> generateCarrier(layer)
            LayerType.DATA -> generateDataBits(layer)
            LayerType.PREAMBLE -> generatePreamble(layer)
            LayerType.SYNC -> generateSync(layer)
            LayerType.NOISE -> generateNoise(layer)
            LayerType.SWEEP -> generateSweep(layer)
            LayerType.BURST -> generateBurst(layer)
        }
    }

    private fun generateCarrier(layer: SignalLayer): List<Int> {
        val duration = layer.pattern.bitDuration * layer.pattern.bits.size
        return listOf(duration) // Simple carrier pulse
    }

    private fun generateDataBits(layer: SignalLayer): List<Int> {
        val result = mutableListOf<Int>()
        val bitDuration = layer.pattern.bitDuration

        when (layer.pattern.encoding) {
            BitEncoding.NRZ -> {
                // Group consecutive same bits
                var currentValue = layer.pattern.bits.firstOrNull() ?: return result
                var count = 0

                layer.pattern.bits.forEach { bit ->
                    if (bit == currentValue) {
                        count++
                    } else {
                        result.add(if (currentValue) bitDuration * count else -bitDuration * count)
                        currentValue = bit
                        count = 1
                    }
                }
                result.add(if (currentValue) bitDuration * count else -bitDuration * count)
            }

            BitEncoding.MANCHESTER -> {
                // Each bit is a transition
                layer.pattern.bits.forEach { bit ->
                    if (bit) {
                        result.add(-bitDuration / 2)
                        result.add(bitDuration / 2)
                    } else {
                        result.add(bitDuration / 2)
                        result.add(-bitDuration / 2)
                    }
                }
            }

            BitEncoding.PWM -> {
                val highDuty = (bitDuration * layer.timing.dutyCycle).toInt()
                val lowDuty = bitDuration - highDuty
                layer.pattern.bits.forEach { bit ->
                    if (bit) {
                        result.add(highDuty)
                        result.add(-lowDuty)
                    } else {
                        result.add(lowDuty)
                        result.add(-highDuty)
                    }
                }
            }

            else -> {
                // Default NRZ-like
                layer.pattern.bits.forEach { bit ->
                    result.add(if (bit) bitDuration else -bitDuration)
                }
            }
        }

        return result.map { (it * layer.volume).toInt() }
    }

    private fun generatePreamble(layer: SignalLayer): List<Int> {
        // Standard preamble: alternating bits
        val result = mutableListOf<Int>()
        val bitDuration = layer.pattern.bitDuration

        repeat(layer.pattern.bits.size) { i ->
            result.add(if (i % 2 == 0) bitDuration else -bitDuration)
        }

        return result
    }

    private fun generateSync(layer: SignalLayer): List<Int> {
        // Sync word - longer pulse followed by pattern
        val result = mutableListOf<Int>()
        val bitDuration = layer.pattern.bitDuration

        // Long sync pulse
        result.add(bitDuration * 4)
        result.add(-bitDuration)

        // Pattern
        layer.pattern.bits.forEach { bit ->
            result.add(if (bit) bitDuration else -bitDuration)
        }

        return result
    }

    private fun generateNoise(layer: SignalLayer): List<Int> {
        // Random noise pattern for jamming/testing
        val result = mutableListOf<Int>()
        val minPulse = layer.pattern.bitDuration / 4
        val maxPulse = layer.pattern.bitDuration * 2

        var totalDuration = 0
        val targetDuration = layer.pattern.bitDuration * layer.pattern.bits.size

        while (totalDuration < targetDuration) {
            val pulse = Random.nextInt(minPulse, maxPulse)
            result.add(if (Random.nextBoolean()) pulse else -pulse)
            totalDuration += pulse
        }

        return result
    }

    private fun generateSweep(layer: SignalLayer): List<Int> {
        // Frequency sweep - varying pulse widths
        val result = mutableListOf<Int>()
        val steps = layer.pattern.bits.size
        val minPulse = layer.pattern.bitDuration / 2
        val maxPulse = layer.pattern.bitDuration * 2

        repeat(steps) { i ->
            val progress = i.toFloat() / steps
            val pulse = (minPulse + (maxPulse - minPulse) * progress).toInt()
            result.add(pulse)
            result.add(-pulse)
        }

        return result
    }

    private fun generateBurst(layer: SignalLayer): List<Int> {
        // Burst pattern: rapid pulses with gaps
        val result = mutableListOf<Int>()
        val bitDuration = layer.pattern.bitDuration

        repeat(3) { burst ->
            repeat(5) {
                result.add(bitDuration / 4)
                result.add(-bitDuration / 4)
            }
            if (burst < 2) {
                result.add(-bitDuration * 2)
            }
        }

        return result
    }

    /**
     * Export project to Flipper .sub file format
     */
    fun exportToFlipperFormat(project: AlchemyProject): String {
        val rawData = synthesize(project)

        return buildString {
            appendLine("Filetype: Flipper SubGhz RAW File")
            appendLine("Version: 1")
            appendLine("# Generated by Vesper Protocol Alchemy")
            appendLine("# Project: ${project.name}")
            appendLine("Frequency: ${project.frequency}")
            appendLine("Preset: ${project.modulation.flipperPreset}")
            appendLine("Protocol: RAW")

            // Split raw data into lines of ~500 chars
            val chunks = rawData.chunked(50)
            chunks.forEach { chunk ->
                appendLine("RAW_Data: ${chunk.joinToString(" ")}")
            }
        }
    }

    /**
     * Generate waveform visualization data
     */
    fun generateWaveformPreview(project: AlchemyProject, width: Int = 500): List<Float> {
        val rawData = synthesize(project)
        if (rawData.isEmpty()) return List(width) { 0.5f }

        val totalDuration = rawData.sumOf { kotlin.math.abs(it) }
        val samplesPerUnit = width.toFloat() / totalDuration

        val samples = mutableListOf<Float>()
        var currentSample = 0f
        var isHigh = true

        rawData.forEach { timing ->
            val duration = kotlin.math.abs(timing)
            val sampleCount = (duration * samplesPerUnit).toInt().coerceAtLeast(1)
            val value = if (timing > 0) 1f else 0f

            repeat(sampleCount) {
                samples.add(value)
            }
        }

        // Resample to exact width
        return if (samples.size >= width) {
            samples.take(width)
        } else {
            samples + List(width - samples.size) { 0.5f }
        }
    }
}

/**
 * Pattern presets for quick layer creation
 */
object PatternPresets {

    val PRINCETON_PREAMBLE = BitPattern(
        bits = List(12) { it % 2 == 0 },
        bitDuration = 350,
        encoding = BitEncoding.NRZ
    )

    val KEELOQ_PREAMBLE = BitPattern(
        bits = List(24) { it % 2 == 0 },
        bitDuration = 400,
        encoding = BitEncoding.MANCHESTER
    )

    val GARAGE_SYNC = BitPattern(
        bits = listOf(true, true, true, true, false, false),
        bitDuration = 500,
        encoding = BitEncoding.NRZ
    )

    val SIMPLE_TOGGLE = BitPattern(
        bits = listOf(true, false, true, false, true, false, true, false),
        bitDuration = 500,
        encoding = BitEncoding.NRZ
    )

    val NOISE_BURST = BitPattern(
        bits = List(100) { Random.nextBoolean() },
        bitDuration = 100,
        encoding = BitEncoding.NRZ
    )

    fun customBits(hexString: String, bitDuration: Int = 500): BitPattern {
        val bits = hexString.flatMap { char ->
            val nibble = char.toString().toIntOrNull(16) ?: 0
            (3 downTo 0).map { (nibble shr it) and 1 == 1 }
        }
        return BitPattern(bits = bits, bitDuration = bitDuration)
    }
}
