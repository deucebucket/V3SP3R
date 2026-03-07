package com.vesper.flipper.ui.screen;

import androidx.compose.animation.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.*;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.*;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.ui.theme.*;
import com.vesper.flipper.ui.viewmodel.AlchemyLabViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0003\u001a4\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003\u001a\u00e8\u0001\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0003\u001a2\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003\u001aF\u0010&\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00010\u0016H\u0003\u001a6\u0010-\u001a\u00020\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170/2\u0006\u00100\u001a\u00020\t2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u00102\u001a\u000203H\u0003\u00a8\u00064"}, d2 = {"AlchemyLabScreen", "", "viewModel", "Lcom/vesper/flipper/ui/viewmodel/AlchemyLabViewModel;", "EmptyLayersPlaceholder", "ExportDialog", "code", "", "isSaving", "", "onSave", "Lkotlin/Function0;", "onDismiss", "LayerCard", "layer", "Lcom/vesper/flipper/domain/model/SignalLayer;", "index", "", "isSelected", "onSelect", "onToggleEnabled", "onVolumeChange", "Lkotlin/Function1;", "", "onBitDurationChange", "onEncodingChange", "Lcom/vesper/flipper/domain/model/BitEncoding;", "onRepeatChange", "onBitsChange", "onMoveUp", "onMoveDown", "onDuplicate", "onDelete", "isFirst", "isLast", "PresetSelectionDialog", "selectedPreset", "Lcom/vesper/flipper/domain/model/SignalPreset;", "ProjectSettingsBar", "project", "Lcom/vesper/flipper/domain/model/AlchemyProject;", "onNameChange", "onPresetClick", "onModulationChange", "Lcom/vesper/flipper/domain/model/ModulationType;", "WaveformPreviewCard", "waveform", "", "isPlaying", "onPlay", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
@kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
public final class AlchemyLabScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void AlchemyLabScreen(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.AlchemyLabViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ProjectSettingsBar(com.vesper.flipper.domain.model.AlchemyProject project, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNameChange, kotlin.jvm.functions.Function0<kotlin.Unit> onPresetClick, kotlin.jvm.functions.Function1<? super com.vesper.flipper.domain.model.ModulationType, kotlin.Unit> onModulationChange) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void WaveformPreviewCard(java.util.List<java.lang.Float> waveform, boolean isPlaying, kotlin.jvm.functions.Function0<kotlin.Unit> onPlay, androidx.compose.ui.Modifier modifier) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    private static final void LayerCard(com.vesper.flipper.domain.model.SignalLayer layer, int index, boolean isSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onSelect, kotlin.jvm.functions.Function0<kotlin.Unit> onToggleEnabled, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onVolumeChange, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onBitDurationChange, kotlin.jvm.functions.Function1<? super com.vesper.flipper.domain.model.BitEncoding, kotlin.Unit> onEncodingChange, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onRepeatChange, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onBitsChange, kotlin.jvm.functions.Function0<kotlin.Unit> onMoveUp, kotlin.jvm.functions.Function0<kotlin.Unit> onMoveDown, kotlin.jvm.functions.Function0<kotlin.Unit> onDuplicate, kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, boolean isFirst, boolean isLast) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void PresetSelectionDialog(com.vesper.flipper.domain.model.SignalPreset selectedPreset, kotlin.jvm.functions.Function1<? super com.vesper.flipper.domain.model.SignalPreset, kotlin.Unit> onSelect, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ExportDialog(java.lang.String code, boolean isSaving, kotlin.jvm.functions.Function0<kotlin.Unit> onSave, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void EmptyLayersPlaceholder() {
    }
}