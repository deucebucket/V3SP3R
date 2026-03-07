package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.data.SettingsStore;
import com.vesper.flipper.domain.model.*;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\fH\u0002J\u0010\u00103\u001a\u0002042\u0006\u00102\u001a\u00020\fH\u0002J\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0002J)\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\f2\u0012\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0:\"\u00020\fH\u0002\u00a2\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020\f2\u0006\u00102\u001a\u00020\fH\u0002J)\u0010=\u001a\u00020\f2\u0006\u00108\u001a\u00020\f2\u0012\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0:\"\u00020\fH\u0002\u00a2\u0006\u0002\u0010;J\u0006\u0010>\u001a\u00020-J \u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\fH\u0082@\u00a2\u0006\u0002\u0010CJ\u0018\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020GH\u0002J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\t2\u0006\u00106\u001a\u00020\fH\u0002J\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u00106\u001a\u00020\fH\u0002J\u001c\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0L2\u0006\u00102\u001a\u00020\fH\u0002J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\t2\u0006\u00106\u001a\u00020\fH\u0002J\u0016\u0010O\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020GH\u0082@\u00a2\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010\u0012J\u000e\u0010S\u001a\u00020-2\u0006\u0010T\u001a\u00020\u0010J\u0010\u0010U\u001a\u00020V2\u0006\u0010R\u001a\u00020\u0012H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001aR\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006W"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/SpectralOracleViewModel;", "Landroidx/lifecycle/ViewModel;", "fileSystem", "Lcom/vesper/flipper/ble/FlipperFileSystem;", "settingsStore", "Lcom/vesper/flipper/data/SettingsStore;", "(Lcom/vesper/flipper/ble/FlipperFileSystem;Lcom/vesper/flipper/data/SettingsStore;)V", "_analysisHistory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/vesper/flipper/ui/viewmodel/AnalysisHistoryItem;", "_analysisProgress", "", "_analysisResult", "Lcom/vesper/flipper/ui/viewmodel/OracleAnalysisResult;", "_analysisType", "Lcom/vesper/flipper/domain/model/AnalysisType;", "_availableSignals", "Lcom/vesper/flipper/domain/model/SignalCapture;", "_error", "_isAnalyzing", "", "_selectedSignal", "analysisHistory", "Lkotlinx/coroutines/flow/StateFlow;", "getAnalysisHistory", "()Lkotlinx/coroutines/flow/StateFlow;", "analysisProgress", "getAnalysisProgress", "analysisResult", "getAnalysisResult", "analysisType", "getAnalysisType", "availableSignals", "getAvailableSignals", "client", "Lokhttp3/OkHttpClient;", "error", "getError", "isAnalyzing", "json", "Lkotlinx/serialization/json/Json;", "selectedSignal", "getSelectedSignal", "analyzeSignal", "", "clearError", "clearResult", "determineThreatLevel", "Lcom/vesper/flipper/domain/model/OracleRiskLevel;", "response", "extractConfidence", "", "extractProtocolName", "section", "extractSection", "text", "keywords", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "extractSummary", "extractValue", "loadAvailableSignals", "loadSubGhzSignal", "Lcom/vesper/flipper/domain/model/SignalCapture$SubGhz;", "path", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAIResponse", "responseBody", "request", "Lcom/vesper/flipper/domain/model/SignalIntelRequest;", "parseExploits", "Lcom/vesper/flipper/ui/viewmodel/ExploitItem;", "parseRecommendations", "parseResponseSections", "", "parseVulnerabilities", "Lcom/vesper/flipper/ui/viewmodel/VulnItem;", "performAIAnalysis", "(Lcom/vesper/flipper/domain/model/SignalIntelRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectSignal", "signal", "setAnalysisType", "type", "signalToCapturedData", "Lcom/vesper/flipper/domain/model/CapturedSignalData;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SpectralOracleViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperFileSystem fileSystem = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.SettingsStore settingsStore = null;
    @org.jetbrains.annotations.NotNull
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.serialization.json.Json json = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.domain.model.SignalCapture>> _availableSignals = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.SignalCapture>> availableSignals = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.SignalCapture> _selectedSignal = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.SignalCapture> selectedSignal = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.AnalysisType> _analysisType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.AnalysisType> analysisType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isAnalyzing = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isAnalyzing = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _analysisProgress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> analysisProgress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ui.viewmodel.OracleAnalysisResult> _analysisResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.OracleAnalysisResult> analysisResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.ui.viewmodel.AnalysisHistoryItem>> _analysisHistory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ui.viewmodel.AnalysisHistoryItem>> analysisHistory = null;
    
    @javax.inject.Inject
    public SpectralOracleViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperFileSystem fileSystem, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.SettingsStore settingsStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.SignalCapture>> getAvailableSignals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.SignalCapture> getSelectedSignal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.AnalysisType> getAnalysisType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isAnalyzing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getAnalysisProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.OracleAnalysisResult> getAnalysisResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ui.viewmodel.AnalysisHistoryItem>> getAnalysisHistory() {
        return null;
    }
    
    public final void loadAvailableSignals() {
    }
    
    private final java.lang.Object loadSubGhzSignal(java.lang.String path, java.lang.String name, kotlin.coroutines.Continuation<? super com.vesper.flipper.domain.model.SignalCapture.SubGhz> $completion) {
        return null;
    }
    
    public final void selectSignal(@org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.SignalCapture signal) {
    }
    
    public final void setAnalysisType(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AnalysisType type) {
    }
    
    public final void analyzeSignal() {
    }
    
    private final com.vesper.flipper.domain.model.CapturedSignalData signalToCapturedData(com.vesper.flipper.domain.model.SignalCapture signal) {
        return null;
    }
    
    private final java.lang.Object performAIAnalysis(com.vesper.flipper.domain.model.SignalIntelRequest request, kotlin.coroutines.Continuation<? super com.vesper.flipper.ui.viewmodel.OracleAnalysisResult> $completion) {
        return null;
    }
    
    private final com.vesper.flipper.ui.viewmodel.OracleAnalysisResult parseAIResponse(java.lang.String responseBody, com.vesper.flipper.domain.model.SignalIntelRequest request) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.String> parseResponseSections(java.lang.String response) {
        return null;
    }
    
    private final java.lang.String extractSummary(java.lang.String response) {
        return null;
    }
    
    private final java.lang.String extractProtocolName(java.lang.String section) {
        return null;
    }
    
    private final java.lang.String extractValue(java.lang.String text, java.lang.String... keywords) {
        return null;
    }
    
    private final float extractConfidence(java.lang.String response) {
        return 0.0F;
    }
    
    private final java.util.List<com.vesper.flipper.ui.viewmodel.VulnItem> parseVulnerabilities(java.lang.String section) {
        return null;
    }
    
    private final java.util.List<com.vesper.flipper.ui.viewmodel.ExploitItem> parseExploits(java.lang.String section) {
        return null;
    }
    
    private final com.vesper.flipper.domain.model.OracleRiskLevel determineThreatLevel(java.lang.String response) {
        return null;
    }
    
    private final java.lang.String extractSection(java.lang.String text, java.lang.String... keywords) {
        return null;
    }
    
    private final java.util.List<java.lang.String> parseRecommendations(java.lang.String section) {
        return null;
    }
    
    public final void clearError() {
    }
    
    public final void clearResult() {
    }
}