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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0014J$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0014H\u0002J\u001e\u0010%\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u0006\u0010\'\u001a\u00020\u0014J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020#J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\fJ\u000e\u0010/\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 J\u001c\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010#H\u0002J \u00104\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020#2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u00066"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/AuditViewModel;", "Landroidx/lifecycle/ViewModel;", "auditService", "Lcom/vesper/flipper/domain/service/AuditService;", "commandExecutor", "Lcom/vesper/flipper/domain/executor/CommandExecutor;", "(Lcom/vesper/flipper/domain/service/AuditService;Lcom/vesper/flipper/domain/executor/CommandExecutor;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/ui/viewmodel/AuditState;", "allEntries", "", "Lcom/vesper/flipper/domain/model/AuditEntry;", "replayInFlight", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "approveReplay", "", "buildTimeline", "Lcom/vesper/flipper/ui/viewmodel/CommandTimelineItem;", "entries", "clearAuditLog", "clearOldEntries", "days", "", "clearReplayMessage", "clearSelection", "filterEntries", "filterType", "Lcom/vesper/flipper/ui/viewmodel/AuditFilterType;", "loadSummary", "sessionId", "", "observeAuditLog", "refreshState", "preserveReplay", "rejectReplay", "replayTrace", "traceId", "runReplayApproval", "approvalId", "approved", "selectEntry", "entry", "setFilter", "summarizeResult", "data", "Lcom/vesper/flipper/domain/model/CommandResultData;", "error", "toTimelineItem", "traceEntries", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AuditViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.service.AuditService auditService = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.executor.CommandExecutor commandExecutor = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ui.viewmodel.AuditState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.AuditState> state = null;
    private boolean replayInFlight = false;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.vesper.flipper.domain.model.AuditEntry> allEntries;
    
    @javax.inject.Inject
    public AuditViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.service.AuditService auditService, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.executor.CommandExecutor commandExecutor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.AuditState> getState() {
        return null;
    }
    
    private final void observeAuditLog() {
    }
    
    private final void refreshState(java.util.List<com.vesper.flipper.domain.model.AuditEntry> entries, boolean preserveReplay) {
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.AuditFilterType filterType) {
    }
    
    private final java.util.List<com.vesper.flipper.domain.model.AuditEntry> filterEntries(java.util.List<com.vesper.flipper.domain.model.AuditEntry> entries, com.vesper.flipper.ui.viewmodel.AuditFilterType filterType) {
        return null;
    }
    
    private final java.util.List<com.vesper.flipper.ui.viewmodel.CommandTimelineItem> buildTimeline(java.util.List<com.vesper.flipper.domain.model.AuditEntry> entries) {
        return null;
    }
    
    private final com.vesper.flipper.ui.viewmodel.CommandTimelineItem toTimelineItem(java.lang.String traceId, java.util.List<com.vesper.flipper.domain.model.AuditEntry> traceEntries) {
        return null;
    }
    
    private final java.lang.String summarizeResult(com.vesper.flipper.domain.model.CommandResultData data, java.lang.String error) {
        return null;
    }
    
    public final void replayTrace(@org.jetbrains.annotations.NotNull
    java.lang.String traceId) {
    }
    
    public final void approveReplay() {
    }
    
    public final void rejectReplay() {
    }
    
    private final void runReplayApproval(java.lang.String approvalId, boolean approved) {
    }
    
    public final void clearReplayMessage() {
    }
    
    public final void selectEntry(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AuditEntry entry) {
    }
    
    public final void clearSelection() {
    }
    
    public final void loadSummary(@org.jetbrains.annotations.NotNull
    java.lang.String sessionId) {
    }
    
    public final void clearAuditLog() {
    }
    
    public final void clearOldEntries(int days) {
    }
}