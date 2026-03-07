@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.vesper.flipper.ui.screen

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.vesper.flipper.domain.model.*
import com.vesper.flipper.ui.theme.*
import com.vesper.flipper.ui.viewmodel.AlchemyLabViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlchemyLabScreen(
    viewModel: AlchemyLabViewModel = hiltViewModel()
) {
    val project by viewModel.project.collectAsState()
    val waveformPreview by viewModel.waveformPreview.collectAsState()
    val selectedLayerIndex by viewModel.selectedLayerIndex.collectAsState()
    val isPlaying by viewModel.isPlaying.collectAsState()
    val isSaving by viewModel.isSaving.collectAsState()
    val showExportDialog by viewModel.showExportDialog.collectAsState()
    val message by viewModel.message.collectAsState()
    val exportedCode by viewModel.exportedCode.collectAsState()

    var showAddLayerMenu by remember { mutableStateOf(false) }
    var showTemplateMenu by remember { mutableStateOf(false) }
    var showPresetMenu by remember { mutableStateOf(false) }

    // Snackbar
    LaunchedEffect(message) {
        message?.let {
            kotlinx.coroutines.delay(2000)
            viewModel.clearMessage()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        TopAppBar(
            title = {
                Column {
                    Text("Protocol Alchemy", fontWeight = FontWeight.Bold)
                    Text(
                        "Signal Synthesizer",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            actions = {
                // Templates
                Box {
                    IconButton(onClick = { showTemplateMenu = true }) {
                        Icon(Icons.Default.AutoAwesome, "Templates")
                    }
                    DropdownMenu(
                        expanded = showTemplateMenu,
                        onDismissRequest = { showTemplateMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Princeton Clone") },
                            onClick = {
                                viewModel.addPrincetonTemplate()
                                showTemplateMenu = false
                            },
                            leadingIcon = { Text("📡") }
                        )
                        DropdownMenuItem(
                            text = { Text("Garage Door") },
                            onClick = {
                                viewModel.addGarageDoorTemplate()
                                showTemplateMenu = false
                            },
                            leadingIcon = { Text("🚗") }
                        )
                        DropdownMenuItem(
                            text = { Text("Test Jammer") },
                            onClick = {
                                viewModel.addJammerTemplate()
                                showTemplateMenu = false
                            },
                            leadingIcon = { Text("📻") }
                        )
                        Divider()
                        DropdownMenuItem(
                            text = { Text("New Project") },
                            onClick = {
                                viewModel.newProject()
                                showTemplateMenu = false
                            },
                            leadingIcon = { Icon(Icons.Default.Add, null) }
                        )
                    }
                }

                IconButton(onClick = { viewModel.showExport() }) {
                    Icon(Icons.Default.Upload, "Export")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // Project Settings Bar
        ProjectSettingsBar(
            project = project,
            onNameChange = { viewModel.updateProjectName(it) },
            onPresetClick = { showPresetMenu = true },
            onModulationChange = { viewModel.updateModulation(it) }
        )

        // Waveform Preview
        WaveformPreviewCard(
            waveform = waveformPreview,
            isPlaying = isPlaying,
            onPlay = { viewModel.playPreview() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        // Layer Controls Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "SIGNAL LAYERS",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Box {
                FilledTonalButton(onClick = { showAddLayerMenu = true }) {
                    Icon(Icons.Default.Add, null, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Add Layer")
                }
                DropdownMenu(
                    expanded = showAddLayerMenu,
                    onDismissRequest = { showAddLayerMenu = false }
                ) {
                    LayerType.entries.forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type.displayName) },
                            onClick = {
                                viewModel.addLayer(type)
                                showAddLayerMenu = false
                            },
                            leadingIcon = { Text(type.icon) }
                        )
                    }
                }
            }
        }

        // Layers List
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(project.layers, key = { _, layer -> layer.id }) { index, layer ->
                LayerCard(
                    layer = layer,
                    index = index,
                    isSelected = selectedLayerIndex == index,
                    onSelect = { viewModel.selectLayer(index) },
                    onToggleEnabled = { viewModel.toggleLayerEnabled(index) },
                    onVolumeChange = { viewModel.updateLayerVolume(index, it) },
                    onBitDurationChange = { viewModel.updateLayerBitDuration(index, it) },
                    onEncodingChange = { viewModel.updateLayerEncoding(index, it) },
                    onRepeatChange = { viewModel.updateLayerRepeatCount(index, it) },
                    onBitsChange = { viewModel.updateLayerBits(index, it) },
                    onMoveUp = { viewModel.moveLayerUp(index) },
                    onMoveDown = { viewModel.moveLayerDown(index) },
                    onDuplicate = { viewModel.duplicateLayer(index) },
                    onDelete = { viewModel.removeLayer(index) },
                    isFirst = index == 0,
                    isLast = index == project.layers.size - 1
                )
            }

            if (project.layers.isEmpty()) {
                item {
                    EmptyLayersPlaceholder()
                }
            }
        }

        // Message Banner
        AnimatedVisibility(
            visible = message != null,
            enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = VesperAccent.copy(alpha = 0.9f)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.CheckCircle, null, tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(message ?: "", color = Color.White, fontWeight = FontWeight.Medium)
                }
            }
        }
    }

    // Preset Selection Dialog
    if (showPresetMenu) {
        PresetSelectionDialog(
            selectedPreset = project.preset,
            onSelect = {
                viewModel.selectPreset(it)
                showPresetMenu = false
            },
            onDismiss = { showPresetMenu = false }
        )
    }

    // Export Dialog
    if (showExportDialog) {
        ExportDialog(
            code = exportedCode ?: "",
            isSaving = isSaving,
            onSave = { viewModel.saveToFlipper() },
            onDismiss = { viewModel.hideExport() }
        )
    }
}

@Composable
private fun ProjectSettingsBar(
    project: AlchemyProject,
    onNameChange: (String) -> Unit,
    onPresetClick: () -> Unit,
    onModulationChange: (ModulationType) -> Unit
) {
    var showModMenu by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            // Name
            OutlinedTextField(
                value = project.name,
                onValueChange = onNameChange,
                label = { Text("Project Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = VesperOrange,
                    cursorColor = VesperOrange
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Frequency Preset
                OutlinedButton(
                    onClick = onPresetClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            AlchemyLabViewModel.formatFrequency(project.frequency),
                            fontWeight = FontWeight.Bold,
                            color = VesperOrange
                        )
                        Text(
                            project.preset.displayName,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                // Modulation
                Box(modifier = Modifier.weight(1f)) {
                    OutlinedButton(
                        onClick = { showModMenu = true },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                project.modulation.displayName,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text("Modulation", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                    DropdownMenu(
                        expanded = showModMenu,
                        onDismissRequest = { showModMenu = false }
                    ) {
                        ModulationType.entries.forEach { mod ->
                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(mod.displayName)
                                        Text(
                                            mod.description,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                },
                                onClick = {
                                    onModulationChange(mod)
                                    showModMenu = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun WaveformPreviewCard(
    waveform: List<Float>,
    isPlaying: Boolean,
    onPlay: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "WAVEFORM PREVIEW",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                FilledIconButton(
                    onClick = onPlay,
                    enabled = !isPlaying,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = VesperOrange
                    )
                ) {
                    if (isPlaying) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                    } else {
                        Icon(Icons.Default.PlayArrow, "Play Preview")
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Waveform Canvas
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                val width = size.width
                val height = size.height
                val padding = 8f

                if (waveform.isEmpty()) return@Canvas

                val path = Path()
                val step = (width - 2 * padding) / waveform.size

                waveform.forEachIndexed { index, value ->
                    val x = padding + index * step
                    val y = padding + (1f - value) * (height - 2 * padding)

                    if (index == 0) {
                        path.moveTo(x, y)
                    } else {
                        path.lineTo(x, y)
                    }
                }

                // Draw waveform
                drawPath(
                    path = path,
                    color = Color(0xFFFF6B00),
                    style = Stroke(width = 2f, cap = StrokeCap.Round)
                )

                // Draw gradient fill
                val fillPath = Path().apply {
                    addPath(path)
                    lineTo(width - padding, height - padding)
                    lineTo(padding, height - padding)
                    close()
                }
                drawPath(
                    path = fillPath,
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFFF6B00).copy(alpha = 0.3f),
                            Color(0xFFFF6B00).copy(alpha = 0.05f)
                        )
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LayerCard(
    layer: SignalLayer,
    index: Int,
    isSelected: Boolean,
    onSelect: () -> Unit,
    onToggleEnabled: () -> Unit,
    onVolumeChange: (Float) -> Unit,
    onBitDurationChange: (Int) -> Unit,
    onEncodingChange: (BitEncoding) -> Unit,
    onRepeatChange: (Int) -> Unit,
    onBitsChange: (String) -> Unit,
    onMoveUp: () -> Unit,
    onMoveDown: () -> Unit,
    onDuplicate: () -> Unit,
    onDelete: () -> Unit,
    isFirst: Boolean,
    isLast: Boolean
) {
    var expanded by remember { mutableStateOf(false) }
    var showEncodingMenu by remember { mutableStateOf(false) }

    Card(
        onClick = {
            onSelect()
            expanded = !expanded
        },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                Color(layer.color).copy(alpha = 0.15f)
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            }
        ),
        border = if (isSelected) {
            BorderStroke(2.dp, Color(layer.color))
        } else null
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Color indicator
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(CircleShape)
                            .background(Color(layer.color))
                    )

                    // Layer icon and name
                    Text(layer.type.icon)
                    Column {
                        Text(
                            layer.name,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            "${layer.pattern.bits.size} bits @ ${layer.pattern.bitDuration}µs",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Row {
                    // Enable toggle
                    Switch(
                        checked = layer.enabled,
                        onCheckedChange = { onToggleEnabled() },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color(layer.color)
                        ),
                        modifier = Modifier.height(24.dp)
                    )

                    // Expand icon
                    Icon(
                        if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = "Expand",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Expanded Controls
            AnimatedVisibility(visible = expanded) {
                Column(
                    modifier = Modifier.padding(top = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Volume/Amplitude
                    Column {
                        Text(
                            "Amplitude: ${(layer.volume * 100).toInt()}%",
                            style = MaterialTheme.typography.labelSmall
                        )
                        Slider(
                            value = layer.volume,
                            onValueChange = onVolumeChange,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(layer.color),
                                activeTrackColor = Color(layer.color)
                            )
                        )
                    }

                    // Bit Duration
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Bit Duration:", style = MaterialTheme.typography.labelSmall)
                        OutlinedTextField(
                            value = layer.pattern.bitDuration.toString(),
                            onValueChange = { it.toIntOrNull()?.let(onBitDurationChange) },
                            modifier = Modifier.weight(1f),
                            suffix = { Text("µs") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }

                    // Encoding
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Encoding:", style = MaterialTheme.typography.labelSmall)
                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedButton(
                                onClick = { showEncodingMenu = true },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(layer.pattern.encoding.displayName)
                            }
                            DropdownMenu(
                                expanded = showEncodingMenu,
                                onDismissRequest = { showEncodingMenu = false }
                            ) {
                                BitEncoding.entries.forEach { enc ->
                                    DropdownMenuItem(
                                        text = { Text(enc.displayName) },
                                        onClick = {
                                            onEncodingChange(enc)
                                            showEncodingMenu = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    // Repeat Count
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Repeat:", style = MaterialTheme.typography.labelSmall)
                        OutlinedTextField(
                            value = layer.timing.repeatCount.toString(),
                            onValueChange = { it.toIntOrNull()?.let(onRepeatChange) },
                            modifier = Modifier.weight(1f),
                            suffix = { Text("×") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }

                    // Bit Pattern (hex)
                    if (layer.type == LayerType.DATA) {
                        val hexValue = remember(layer.pattern.bits) {
                            layer.pattern.bits.chunked(4).map { nibble ->
                                nibble.foldIndexed(0) { i, acc, bit ->
                                    acc or (if (bit) (1 shl (3 - i)) else 0)
                                }.toString(16).uppercase()
                            }.joinToString("")
                        }

                        OutlinedTextField(
                            value = hexValue,
                            onValueChange = { onBitsChange(it.filter { c -> c.isDigit() || c in 'A'..'F' || c in 'a'..'f' }) },
                            label = { Text("Data (Hex)") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            textStyle = LocalTextStyle.current.copy(fontFamily = FontFamily.Monospace)
                        )
                    }

                    // Action Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(onClick = onMoveUp, enabled = !isFirst) {
                            Icon(Icons.Default.KeyboardArrowUp, "Move Up")
                        }
                        IconButton(onClick = onMoveDown, enabled = !isLast) {
                            Icon(Icons.Default.KeyboardArrowDown, "Move Down")
                        }
                        IconButton(onClick = onDuplicate) {
                            Icon(Icons.Default.ContentCopy, "Duplicate")
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(onClick = onDelete) {
                            Icon(
                                Icons.Default.Delete,
                                "Delete",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PresetSelectionDialog(
    selectedPreset: SignalPreset,
    onSelect: (SignalPreset) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Select Frequency Preset",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(SignalPreset.entries) { preset ->
                        Card(
                            onClick = { onSelect(preset) },
                            colors = CardDefaults.cardColors(
                                containerColor = if (preset == selectedPreset) {
                                    VesperOrange.copy(alpha = 0.2f)
                                } else {
                                    MaterialTheme.colorScheme.surfaceVariant
                                }
                            ),
                            border = if (preset == selectedPreset) {
                                BorderStroke(2.dp, VesperOrange)
                            } else null
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        preset.displayName,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(
                                        AlchemyLabViewModel.formatFrequency(preset.frequency),
                                        style = MaterialTheme.typography.bodySmall,
                                        color = VesperOrange
                                    )
                                }
                                Surface(
                                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Text(
                                        preset.region,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ExportDialog(
    code: String,
    isSaving: Boolean,
    onSave: () -> Unit,
    onDismiss: () -> Unit
) {
    val clipboardManager = LocalClipboardManager.current
    var copied by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Export Signal",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, "Close")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Code Preview
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(12.dp)
                    ) {
                        Text(
                            code,
                            fontFamily = FontFamily.Monospace,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = {
                            clipboardManager.setText(AnnotatedString(code))
                            copied = true
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            if (copied) Icons.Default.Check else Icons.Default.ContentCopy,
                            null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(if (copied) "Copied!" else "Copy")
                    }

                    Button(
                        onClick = onSave,
                        enabled = !isSaving,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = VesperOrange
                        )
                    ) {
                        if (isSaving) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(18.dp),
                                color = Color.White,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Icon(Icons.Default.Save, null)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Save to Flipper")
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptyLayersPlaceholder() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("⚗️", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "No layers yet",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            "Add layers to build your signal",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
        )
    }
}
