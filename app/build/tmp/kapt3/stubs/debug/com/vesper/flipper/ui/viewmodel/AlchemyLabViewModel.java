package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.*;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 U2\u00020\u0001:\u0001UB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u000e\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020%J\u0010\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020\rH\u0002J\u000e\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020%J\u000e\u00102\u001a\u00020%2\u0006\u00100\u001a\u00020\u000fJ\u000e\u00103\u001a\u00020%2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00104\u001a\u00020%J\u0006\u00105\u001a\u00020%J\u000e\u00106\u001a\u00020%2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00107\u001a\u00020%J\u0015\u00108\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020%J\u000e\u0010>\u001a\u00020%2\u0006\u00100\u001a\u00020\u000fJ\u000e\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020AJ$\u0010B\u001a\u00020%2\u0006\u00100\u001a\u00020\u000f2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0DH\u0002J\u0016\u0010E\u001a\u00020%2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000fJ\u0016\u0010G\u001a\u00020%2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u0007J\u0016\u0010I\u001a\u00020%2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020KJ\u0016\u0010L\u001a\u00020%2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fJ\u0016\u0010N\u001a\u00020%2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u0013J\u000e\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017\u00a8\u0006V"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/AlchemyLabViewModel;", "Landroidx/lifecycle/ViewModel;", "fileSystem", "Lcom/vesper/flipper/ble/FlipperFileSystem;", "(Lcom/vesper/flipper/ble/FlipperFileSystem;)V", "_exportedCode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isPlaying", "", "_isSaving", "_message", "_project", "Lcom/vesper/flipper/domain/model/AlchemyProject;", "_selectedLayerIndex", "", "_showExportDialog", "_waveformPreview", "", "", "exportedCode", "Lkotlinx/coroutines/flow/StateFlow;", "getExportedCode", "()Lkotlinx/coroutines/flow/StateFlow;", "isPlaying", "isSaving", "message", "getMessage", "project", "getProject", "selectedLayerIndex", "getSelectedLayerIndex", "showExportDialog", "getShowExportDialog", "waveformPreview", "getWaveformPreview", "addGarageDoorTemplate", "", "addJammerTemplate", "addLayer", "type", "Lcom/vesper/flipper/domain/model/LayerType;", "addPrincetonTemplate", "clearMessage", "createDefaultLayer", "Lcom/vesper/flipper/domain/model/SignalLayer;", "createDefaultProject", "duplicateLayer", "index", "hideExport", "moveLayerDown", "moveLayerUp", "newProject", "playPreview", "removeLayer", "saveToFlipper", "selectLayer", "(Ljava/lang/Integer;)V", "selectPreset", "preset", "Lcom/vesper/flipper/domain/model/SignalPreset;", "showExport", "toggleLayerEnabled", "updateFrequency", "frequency", "", "updateLayer", "transform", "Lkotlin/Function1;", "updateLayerBitDuration", "duration", "updateLayerBits", "hexPattern", "updateLayerEncoding", "encoding", "Lcom/vesper/flipper/domain/model/BitEncoding;", "updateLayerRepeatCount", "count", "updateLayerVolume", "volume", "updateModulation", "modulation", "Lcom/vesper/flipper/domain/model/ModulationType;", "updateProjectName", "name", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AlchemyLabViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperFileSystem fileSystem = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.AlchemyProject> _project = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.AlchemyProject> project = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.Float>> _waveformPreview = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.Float>> waveformPreview = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _selectedLayerIndex = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> selectedLayerIndex = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isPlaying = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isPlaying = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSaving = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSaving = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _showExportDialog = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> showExportDialog = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _message = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> message = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _exportedCode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> exportedCode = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ui.viewmodel.AlchemyLabViewModel.Companion Companion = null;
    
    @javax.inject.Inject
    public AlchemyLabViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperFileSystem fileSystem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.AlchemyProject> getProject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.Float>> getWaveformPreview() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSelectedLayerIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isPlaying() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSaving() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getShowExportDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getExportedCode() {
        return null;
    }
    
    public final void updateProjectName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void updateFrequency(long frequency) {
    }
    
    public final void selectPreset(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.SignalPreset preset) {
    }
    
    public final void updateModulation(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ModulationType modulation) {
    }
    
    public final void addLayer(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.LayerType type) {
    }
    
    public final void removeLayer(int index) {
    }
    
    public final void selectLayer(@org.jetbrains.annotations.Nullable
    java.lang.Integer index) {
    }
    
    public final void toggleLayerEnabled(int index) {
    }
    
    public final void updateLayerVolume(int index, float volume) {
    }
    
    public final void updateLayerBitDuration(int index, int duration) {
    }
    
    public final void updateLayerEncoding(int index, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.BitEncoding encoding) {
    }
    
    public final void updateLayerRepeatCount(int index, int count) {
    }
    
    public final void updateLayerBits(int index, @org.jetbrains.annotations.NotNull
    java.lang.String hexPattern) {
    }
    
    public final void moveLayerUp(int index) {
    }
    
    public final void moveLayerDown(int index) {
    }
    
    public final void duplicateLayer(int index) {
    }
    
    private final void updateLayer(int index, kotlin.jvm.functions.Function1<? super com.vesper.flipper.domain.model.SignalLayer, com.vesper.flipper.domain.model.SignalLayer> transform) {
    }
    
    public final void playPreview() {
    }
    
    public final void showExport() {
    }
    
    public final void hideExport() {
    }
    
    public final void saveToFlipper() {
    }
    
    public final void clearMessage() {
    }
    
    public final void newProject() {
    }
    
    public final void addPrincetonTemplate() {
    }
    
    public final void addJammerTemplate() {
    }
    
    public final void addGarageDoorTemplate() {
    }
    
    private final com.vesper.flipper.domain.model.AlchemyProject createDefaultProject() {
        return null;
    }
    
    private final com.vesper.flipper.domain.model.SignalLayer createDefaultLayer(com.vesper.flipper.domain.model.LayerType type) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/AlchemyLabViewModel$Companion;", "", "()V", "formatFrequency", "", "hz", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String formatFrequency(long hz) {
            return null;
        }
    }
}