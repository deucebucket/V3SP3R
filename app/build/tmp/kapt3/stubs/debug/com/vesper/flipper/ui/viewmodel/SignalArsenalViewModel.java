package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.*;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\u0006\u00101\u001a\u00020/J\u000e\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\u000eJ\b\u00104\u001a\u00020/H\u0002J(\u00105\u001a\u0004\u0018\u00010\u000e2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0010H\u0082@\u00a2\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020/2\u0006\u00108\u001a\u00020\u0010H\u0002J\u0010\u0010;\u001a\u00020/2\u0006\u00103\u001a\u00020\u000eH\u0002J\u0006\u0010<\u001a\u00020/J\u000e\u0010=\u001a\u00020/2\u0006\u00103\u001a\u00020\u000eJ\u000e\u0010>\u001a\u00020/2\u0006\u00103\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020/2\u0006\u00108\u001a\u00020\u0010J\u000e\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u00120\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001bR#\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u00120\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001b\u00a8\u0006C"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/SignalArsenalViewModel;", "Landroidx/lifecycle/ViewModel;", "fileSystem", "Lcom/vesper/flipper/ble/FlipperFileSystem;", "(Lcom/vesper/flipper/ble/FlipperFileSystem;)V", "_error", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isLoading", "", "_isReplaying", "_replaySuccess", "_searchQuery", "_selectedSignal", "Lcom/vesper/flipper/domain/model/SignalCapture;", "_selectedType", "Lcom/vesper/flipper/domain/model/SignalType;", "_signalCounts", "", "", "_signals", "", "_waveformData", "Lcom/vesper/flipper/domain/model/WaveformData;", "error", "Lkotlinx/coroutines/flow/StateFlow;", "getError", "()Lkotlinx/coroutines/flow/StateFlow;", "filteredSignals", "getFilteredSignals", "isLoading", "isReplaying", "replaySuccess", "getReplaySuccess", "searchQuery", "getSearchQuery", "selectedSignal", "getSelectedSignal", "selectedType", "getSelectedType", "signalCounts", "getSignalCounts", "signals", "getSignals", "waveformData", "getWaveformData", "clearError", "", "clearReplaySuccess", "clearSelection", "deleteSignal", "signal", "loadSignalCounts", "loadSignalFile", "path", "name", "type", "(Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/domain/model/SignalType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSignals", "loadWaveform", "refresh", "replaySignal", "selectSignal", "selectType", "updateSearchQuery", "query", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SignalArsenalViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperFileSystem fileSystem = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.SignalType> _selectedType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.SignalType> selectedType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.domain.model.SignalCapture>> _signals = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.SignalCapture>> signals = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.SignalCapture> _selectedSignal = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.SignalCapture> selectedSignal = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.WaveformData> _waveformData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.WaveformData> waveformData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isReplaying = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isReplaying = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _replaySuccess = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> replaySuccess = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.SignalCapture>> filteredSignals = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<com.vesper.flipper.domain.model.SignalType, java.lang.Integer>> _signalCounts = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<com.vesper.flipper.domain.model.SignalType, java.lang.Integer>> signalCounts = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ui.viewmodel.SignalArsenalViewModel.Companion Companion = null;
    
    @javax.inject.Inject
    public SignalArsenalViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperFileSystem fileSystem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.SignalType> getSelectedType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.SignalCapture>> getSignals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.SignalCapture> getSelectedSignal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.WaveformData> getWaveformData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isReplaying() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getReplaySuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.SignalCapture>> getFilteredSignals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<com.vesper.flipper.domain.model.SignalType, java.lang.Integer>> getSignalCounts() {
        return null;
    }
    
    public final void selectType(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.SignalType type) {
    }
    
    public final void selectSignal(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.SignalCapture signal) {
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void clearSelection() {
    }
    
    public final void refresh() {
    }
    
    private final void loadSignalCounts() {
    }
    
    private final void loadSignals(com.vesper.flipper.domain.model.SignalType type) {
    }
    
    private final java.lang.Object loadSignalFile(java.lang.String path, java.lang.String name, com.vesper.flipper.domain.model.SignalType type, kotlin.coroutines.Continuation<? super com.vesper.flipper.domain.model.SignalCapture> $completion) {
        return null;
    }
    
    private final void loadWaveform(com.vesper.flipper.domain.model.SignalCapture signal) {
    }
    
    public final void replaySignal(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.SignalCapture signal) {
    }
    
    public final void deleteSignal(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.SignalCapture signal) {
    }
    
    public final void clearError() {
    }
    
    public final void clearReplaySuccess() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/SignalArsenalViewModel$Companion;", "", "()V", "formatFrequency", "", "hz", "", "getSignalIcon", "type", "Lcom/vesper/flipper/domain/model/SignalType;", "getSignalSubtitle", "signal", "Lcom/vesper/flipper/domain/model/SignalCapture;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String formatFrequency(long hz) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSignalSubtitle(@org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.model.SignalCapture signal) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSignalIcon(@org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.model.SignalType type) {
            return null;
        }
    }
}