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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/AnalysisHistoryItem;", "", "signalName", "", "analysisType", "Lcom/vesper/flipper/domain/model/AnalysisType;", "timestamp", "", "riskLevel", "Lcom/vesper/flipper/domain/model/OracleRiskLevel;", "summary", "(Ljava/lang/String;Lcom/vesper/flipper/domain/model/AnalysisType;JLcom/vesper/flipper/domain/model/OracleRiskLevel;Ljava/lang/String;)V", "getAnalysisType", "()Lcom/vesper/flipper/domain/model/AnalysisType;", "getRiskLevel", "()Lcom/vesper/flipper/domain/model/OracleRiskLevel;", "getSignalName", "()Ljava/lang/String;", "getSummary", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class AnalysisHistoryItem {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String signalName = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.AnalysisType analysisType = null;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.OracleRiskLevel riskLevel = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String summary = null;
    
    public AnalysisHistoryItem(@org.jetbrains.annotations.NotNull
    java.lang.String signalName, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AnalysisType analysisType, long timestamp, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.OracleRiskLevel riskLevel, @org.jetbrains.annotations.NotNull
    java.lang.String summary) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSignalName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.AnalysisType getAnalysisType() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.OracleRiskLevel getRiskLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.AnalysisType component2() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.OracleRiskLevel component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.AnalysisHistoryItem copy(@org.jetbrains.annotations.NotNull
    java.lang.String signalName, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AnalysisType analysisType, long timestamp, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.OracleRiskLevel riskLevel, @org.jetbrains.annotations.NotNull
    java.lang.String summary) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}