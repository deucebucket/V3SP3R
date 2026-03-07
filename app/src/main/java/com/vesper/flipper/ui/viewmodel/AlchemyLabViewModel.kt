package com.vesper.flipper.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vesper.flipper.ble.FlipperFileSystem
import com.vesper.flipper.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class AlchemyLabViewModel @Inject constructor(
    private val fileSystem: FlipperFileSystem
) : ViewModel() {

    // Current project
    private val _project = MutableStateFlow(createDefaultProject())
    val project: StateFlow<AlchemyProject> = _project.asStateFlow()

    // Waveform preview
    private val _waveformPreview = MutableStateFlow<List<Float>>(emptyList())
    val waveformPreview: StateFlow<List<Float>> = _waveformPreview.asStateFlow()

    // UI State
    private val _selectedLayerIndex = MutableStateFlow<Int?>(null)
    val selectedLayerIndex: StateFlow<Int?> = _selectedLayerIndex.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _isSaving = MutableStateFlow(false)
    val isSaving: StateFlow<Boolean> = _isSaving.asStateFlow()

    private val _showExportDialog = MutableStateFlow(false)
    val showExportDialog: StateFlow<Boolean> = _showExportDialog.asStateFlow()

    private val _message = MutableStateFlow<String?>(null)
    val message: StateFlow<String?> = _message.asStateFlow()

    private val _exportedCode = MutableStateFlow<String?>(null)
    val exportedCode: StateFlow<String?> = _exportedCode.asStateFlow()

    init {
        // Auto-update waveform when project changes
        viewModelScope.launch {
            _project.collect { proj ->
                _waveformPreview.value = SignalAlchemist.generateWaveformPreview(proj, 300)
            }
        }
    }

    // Project Management

    fun updateProjectName(name: String) {
        _project.value = _project.value.copy(name = name)
    }

    fun updateFrequency(frequency: Long) {
        _project.value = _project.value.copy(frequency = frequency)
    }

    fun selectPreset(preset: SignalPreset) {
        _project.value = _project.value.copy(
            preset = preset,
            frequency = preset.frequency
        )
    }

    fun updateModulation(modulation: ModulationType) {
        _project.value = _project.value.copy(modulation = modulation)
    }

    // Layer Management

    fun addLayer(type: LayerType) {
        val newLayer = createDefaultLayer(type)
        val currentLayers = _project.value.layers.toMutableList()
        currentLayers.add(newLayer)
        _project.value = _project.value.copy(layers = currentLayers)
        _selectedLayerIndex.value = currentLayers.size - 1
    }

    fun removeLayer(index: Int) {
        val currentLayers = _project.value.layers.toMutableList()
        if (index in currentLayers.indices) {
            currentLayers.removeAt(index)
            _project.value = _project.value.copy(layers = currentLayers)
            _selectedLayerIndex.value = null
        }
    }

    fun selectLayer(index: Int?) {
        _selectedLayerIndex.value = index
    }

    fun toggleLayerEnabled(index: Int) {
        updateLayer(index) { it.copy(enabled = !it.enabled) }
    }

    fun updateLayerVolume(index: Int, volume: Float) {
        updateLayer(index) { it.copy(volume = volume.coerceIn(0f, 1f)) }
    }

    fun updateLayerBitDuration(index: Int, duration: Int) {
        updateLayer(index) { layer ->
            layer.copy(pattern = layer.pattern.copy(bitDuration = duration.coerceIn(50, 5000)))
        }
    }

    fun updateLayerEncoding(index: Int, encoding: BitEncoding) {
        updateLayer(index) { layer ->
            layer.copy(pattern = layer.pattern.copy(encoding = encoding))
        }
    }

    fun updateLayerRepeatCount(index: Int, count: Int) {
        updateLayer(index) { layer ->
            layer.copy(timing = layer.timing.copy(repeatCount = count.coerceIn(1, 100)))
        }
    }

    fun updateLayerBits(index: Int, hexPattern: String) {
        updateLayer(index) { layer ->
            val bits = hexPattern.flatMap { char ->
                val nibble = char.toString().toIntOrNull(16) ?: 0
                (3 downTo 0).map { (nibble shr it) and 1 == 1 }
            }
            layer.copy(pattern = layer.pattern.copy(bits = bits))
        }
    }

    fun moveLayerUp(index: Int) {
        if (index > 0) {
            val layers = _project.value.layers.toMutableList()
            val temp = layers[index]
            layers[index] = layers[index - 1]
            layers[index - 1] = temp
            _project.value = _project.value.copy(layers = layers)
            _selectedLayerIndex.value = index - 1
        }
    }

    fun moveLayerDown(index: Int) {
        val layers = _project.value.layers
        if (index < layers.size - 1) {
            val mutableLayers = layers.toMutableList()
            val temp = mutableLayers[index]
            mutableLayers[index] = mutableLayers[index + 1]
            mutableLayers[index + 1] = temp
            _project.value = _project.value.copy(layers = mutableLayers)
            _selectedLayerIndex.value = index + 1
        }
    }

    fun duplicateLayer(index: Int) {
        val layers = _project.value.layers
        if (index in layers.indices) {
            val original = layers[index]
            val duplicate = original.copy(
                id = java.util.UUID.randomUUID().toString(),
                name = "${original.name} (copy)"
            )
            val mutableLayers = layers.toMutableList()
            mutableLayers.add(index + 1, duplicate)
            _project.value = _project.value.copy(layers = mutableLayers)
        }
    }

    private fun updateLayer(index: Int, transform: (SignalLayer) -> SignalLayer) {
        val currentLayers = _project.value.layers.toMutableList()
        if (index in currentLayers.indices) {
            currentLayers[index] = transform(currentLayers[index])
            _project.value = _project.value.copy(layers = currentLayers)
        }
    }

    // Playback & Export

    fun playPreview() {
        viewModelScope.launch {
            _isPlaying.value = true
            // Simulate playback
            kotlinx.coroutines.delay(2000)
            _isPlaying.value = false
            _message.value = "Signal preview complete"
        }
    }

    fun showExport() {
        _exportedCode.value = SignalAlchemist.exportToFlipperFormat(_project.value)
        _showExportDialog.value = true
    }

    fun hideExport() {
        _showExportDialog.value = false
    }

    fun saveToFlipper() {
        viewModelScope.launch {
            _isSaving.value = true
            try {
                val content = SignalAlchemist.exportToFlipperFormat(_project.value)
                val filename = _project.value.name
                    .replace(Regex("[^a-zA-Z0-9_-]"), "_")
                    .take(32)
                val path = "/ext/subghz/alchemy_$filename.sub"

                val result = fileSystem.writeFile(path, content)
                if (result.isSuccess) {
                    _message.value = "Saved to $path"
                    _showExportDialog.value = false
                } else {
                    _message.value = "Failed to save: ${result.exceptionOrNull()?.message}"
                }
            } catch (e: Exception) {
                _message.value = "Error: ${e.message}"
            } finally {
                _isSaving.value = false
            }
        }
    }

    fun clearMessage() {
        _message.value = null
    }

    fun newProject() {
        _project.value = createDefaultProject()
        _selectedLayerIndex.value = null
    }

    // Quick Add Templates

    fun addPrincetonTemplate() {
        _project.value = _project.value.copy(
            name = "Princeton Clone",
            frequency = 433_920_000,
            modulation = ModulationType.OOK_650,
            preset = SignalPreset.CAR_KEY_433,
            layers = listOf(
                SignalLayer(
                    name = "Preamble",
                    type = LayerType.PREAMBLE,
                    pattern = PatternPresets.PRINCETON_PREAMBLE,
                    timing = TimingConfig(repeatCount = 1),
                    color = 0xFF4CAF50
                ),
                SignalLayer(
                    name = "Sync",
                    type = LayerType.SYNC,
                    pattern = PatternPresets.GARAGE_SYNC,
                    timing = TimingConfig(delayBefore = 100),
                    color = 0xFF2196F3
                ),
                SignalLayer(
                    name = "Data",
                    type = LayerType.DATA,
                    pattern = PatternPresets.customBits("A5F0", 350),
                    timing = TimingConfig(delayBefore = 50, repeatCount = 5, repeatDelay = 10000),
                    color = 0xFFFF6B00
                )
            )
        )
    }

    fun addJammerTemplate() {
        _project.value = _project.value.copy(
            name = "Test Jammer",
            frequency = 433_920_000,
            modulation = ModulationType.OOK_650,
            preset = SignalPreset.CAR_KEY_433,
            layers = listOf(
                SignalLayer(
                    name = "Noise Burst 1",
                    type = LayerType.NOISE,
                    pattern = PatternPresets.NOISE_BURST,
                    timing = TimingConfig(repeatCount = 10, repeatDelay = 1000),
                    color = 0xFFF44336
                ),
                SignalLayer(
                    name = "Sweep",
                    type = LayerType.SWEEP,
                    pattern = BitPattern(List(50) { true }, 200),
                    timing = TimingConfig(delayBefore = 5000, repeatCount = 5),
                    color = 0xFF9C27B0
                )
            )
        )
    }

    fun addGarageDoorTemplate() {
        _project.value = _project.value.copy(
            name = "Garage Door",
            frequency = 315_000_000,
            modulation = ModulationType.OOK_650,
            preset = SignalPreset.GARAGE_315,
            layers = listOf(
                SignalLayer(
                    name = "Preamble",
                    type = LayerType.PREAMBLE,
                    pattern = BitPattern(List(20) { it % 2 == 0 }, 400),
                    timing = TimingConfig(),
                    color = 0xFF4CAF50
                ),
                SignalLayer(
                    name = "Code",
                    type = LayerType.DATA,
                    pattern = PatternPresets.customBits("DEADBEEF", 400),
                    timing = TimingConfig(delayBefore = 100, repeatCount = 8, repeatDelay = 15000),
                    color = 0xFFFF6B00
                )
            )
        )
    }

    // Helpers

    private fun createDefaultProject(): AlchemyProject {
        return AlchemyProject(
            name = "New Signal",
            frequency = 433_920_000,
            modulation = ModulationType.OOK_650,
            preset = SignalPreset.CAR_KEY_433,
            layers = listOf(
                createDefaultLayer(LayerType.PREAMBLE),
                createDefaultLayer(LayerType.DATA)
            )
        )
    }

    private fun createDefaultLayer(type: LayerType): SignalLayer {
        val color = when (type) {
            LayerType.CARRIER -> 0xFF9E9E9E
            LayerType.DATA -> 0xFFFF6B00
            LayerType.PREAMBLE -> 0xFF4CAF50
            LayerType.SYNC -> 0xFF2196F3
            LayerType.NOISE -> 0xFFF44336
            LayerType.SWEEP -> 0xFF9C27B0
            LayerType.BURST -> 0xFFFFEB3B
        }

        val defaultPattern = when (type) {
            LayerType.PREAMBLE -> BitPattern(List(12) { it % 2 == 0 }, 400)
            LayerType.SYNC -> BitPattern(listOf(true, true, true, false), 500)
            LayerType.DATA -> BitPattern(List(16) { Random.nextBoolean() }, 400)
            LayerType.NOISE -> PatternPresets.NOISE_BURST
            LayerType.SWEEP -> BitPattern(List(30) { true }, 200)
            LayerType.BURST -> BitPattern(List(15) { it % 3 == 0 }, 150)
            LayerType.CARRIER -> BitPattern(listOf(true), 5000)
        }

        return SignalLayer(
            name = type.displayName,
            type = type,
            pattern = defaultPattern,
            timing = TimingConfig(repeatCount = 1),
            color = color
        )
    }

    companion object {
        fun formatFrequency(hz: Long): String {
            return when {
                hz >= 1_000_000_000 -> String.format(java.util.Locale.US, "%.3f GHz", hz / 1_000_000_000.0)
                hz >= 1_000_000 -> String.format(java.util.Locale.US, "%.3f MHz", hz / 1_000_000.0)
                hz >= 1_000 -> String.format(java.util.Locale.US, "%.3f kHz", hz / 1_000.0)
                else -> "$hz Hz"
            }
        }
    }
}
