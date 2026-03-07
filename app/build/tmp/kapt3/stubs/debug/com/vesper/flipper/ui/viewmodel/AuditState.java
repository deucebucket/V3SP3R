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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0013J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010&\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010(\u001a\u00020\rH\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003Jy\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u000200H\u00d6\u0001J\t\u00101\u001a\u00020\u000fH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015\u00a8\u00062"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/AuditState;", "", "entries", "", "Lcom/vesper/flipper/domain/model/AuditEntry;", "timeline", "Lcom/vesper/flipper/ui/viewmodel/CommandTimelineItem;", "summary", "Lcom/vesper/flipper/domain/model/AuditSummary;", "isLoading", "", "selectedEntry", "filterType", "Lcom/vesper/flipper/ui/viewmodel/AuditFilterType;", "replayingTraceId", "", "pendingReplayApproval", "Lcom/vesper/flipper/domain/model/PendingApproval;", "replayMessage", "(Ljava/util/List;Ljava/util/List;Lcom/vesper/flipper/domain/model/AuditSummary;ZLcom/vesper/flipper/domain/model/AuditEntry;Lcom/vesper/flipper/ui/viewmodel/AuditFilterType;Ljava/lang/String;Lcom/vesper/flipper/domain/model/PendingApproval;Ljava/lang/String;)V", "getEntries", "()Ljava/util/List;", "getFilterType", "()Lcom/vesper/flipper/ui/viewmodel/AuditFilterType;", "()Z", "getPendingReplayApproval", "()Lcom/vesper/flipper/domain/model/PendingApproval;", "getReplayMessage", "()Ljava/lang/String;", "getReplayingTraceId", "getSelectedEntry", "()Lcom/vesper/flipper/domain/model/AuditEntry;", "getSummary", "()Lcom/vesper/flipper/domain/model/AuditSummary;", "getTimeline", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class AuditState {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.domain.model.AuditEntry> entries = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.ui.viewmodel.CommandTimelineItem> timeline = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.AuditSummary summary = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.AuditEntry selectedEntry = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ui.viewmodel.AuditFilterType filterType = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String replayingTraceId = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.PendingApproval pendingReplayApproval = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String replayMessage = null;
    
    public AuditState(@org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.AuditEntry> entries, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ui.viewmodel.CommandTimelineItem> timeline, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.AuditSummary summary, boolean isLoading, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.AuditEntry selectedEntry, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.AuditFilterType filterType, @org.jetbrains.annotations.Nullable
    java.lang.String replayingTraceId, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.PendingApproval pendingReplayApproval, @org.jetbrains.annotations.Nullable
    java.lang.String replayMessage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.AuditEntry> getEntries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ui.viewmodel.CommandTimelineItem> getTimeline() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.AuditSummary getSummary() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.AuditEntry getSelectedEntry() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.AuditFilterType getFilterType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReplayingTraceId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.PendingApproval getPendingReplayApproval() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReplayMessage() {
        return null;
    }
    
    public AuditState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.AuditEntry> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ui.viewmodel.CommandTimelineItem> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.AuditSummary component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.AuditEntry component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.AuditFilterType component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.PendingApproval component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.AuditState copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.AuditEntry> entries, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ui.viewmodel.CommandTimelineItem> timeline, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.AuditSummary summary, boolean isLoading, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.AuditEntry selectedEntry, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.AuditFilterType filterType, @org.jetbrains.annotations.Nullable
    java.lang.String replayingTraceId, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.PendingApproval pendingReplayApproval, @org.jetbrains.annotations.Nullable
    java.lang.String replayMessage) {
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