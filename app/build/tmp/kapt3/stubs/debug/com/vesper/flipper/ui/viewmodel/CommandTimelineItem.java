package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.domain.executor.CommandExecutor;
import com.vesper.flipper.domain.model.AuditEntry;
import com.vesper.flipper.domain.model.AuditSummary;
import com.vesper.flipper.domain.model.CommandResultData;
import com.vesper.flipper.domain.model.ExecuteCommand;
import com.vesper.flipper.domain.model.PendingApproval;
import com.vesper.flipper.domain.service.AuditService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Jl\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020.H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015\u00a8\u00060"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/CommandTimelineItem;", "", "traceId", "", "sessionId", "command", "Lcom/vesper/flipper/domain/model/ExecuteCommand;", "status", "Lcom/vesper/flipper/ui/viewmodel/CommandTraceStatus;", "startedAt", "", "finishedAt", "durationMs", "summary", "error", "(Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/domain/model/ExecuteCommand;Lcom/vesper/flipper/ui/viewmodel/CommandTraceStatus;JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;)V", "getCommand", "()Lcom/vesper/flipper/domain/model/ExecuteCommand;", "getDurationMs", "()J", "getError", "()Ljava/lang/String;", "getFinishedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSessionId", "getStartedAt", "getStatus", "()Lcom/vesper/flipper/ui/viewmodel/CommandTraceStatus;", "getSummary", "getTraceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/domain/model/ExecuteCommand;Lcom/vesper/flipper/ui/viewmodel/CommandTraceStatus;JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;)Lcom/vesper/flipper/ui/viewmodel/CommandTimelineItem;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class CommandTimelineItem {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String traceId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String sessionId = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.ExecuteCommand command = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ui.viewmodel.CommandTraceStatus status = null;
    private final long startedAt = 0L;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long finishedAt = null;
    private final long durationMs = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String summary = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    
    public CommandTimelineItem(@org.jetbrains.annotations.NotNull
    java.lang.String traceId, @org.jetbrains.annotations.NotNull
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ExecuteCommand command, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.CommandTraceStatus status, long startedAt, @org.jetbrains.annotations.Nullable
    java.lang.Long finishedAt, long durationMs, @org.jetbrains.annotations.NotNull
    java.lang.String summary, @org.jetbrains.annotations.Nullable
    java.lang.String error) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTraceId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSessionId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ExecuteCommand getCommand() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.CommandTraceStatus getStatus() {
        return null;
    }
    
    public final long getStartedAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getFinishedAt() {
        return null;
    }
    
    public final long getDurationMs() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ExecuteCommand component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.CommandTraceStatus component4() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component6() {
        return null;
    }
    
    public final long component7() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.CommandTimelineItem copy(@org.jetbrains.annotations.NotNull
    java.lang.String traceId, @org.jetbrains.annotations.NotNull
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ExecuteCommand command, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.CommandTraceStatus status, long startedAt, @org.jetbrains.annotations.Nullable
    java.lang.Long finishedAt, long durationMs, @org.jetbrains.annotations.NotNull
    java.lang.String summary, @org.jetbrains.annotations.Nullable
    java.lang.String error) {
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