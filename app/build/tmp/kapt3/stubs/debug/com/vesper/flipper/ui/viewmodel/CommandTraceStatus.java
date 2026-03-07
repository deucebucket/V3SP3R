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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/CommandTraceStatus;", "", "(Ljava/lang/String;I)V", "RECEIVED", "WAITING_APPROVAL", "EXECUTED", "FAILED", "BLOCKED", "DENIED", "TIMED_OUT", "app_debug"})
public enum CommandTraceStatus {
    /*public static final*/ RECEIVED /* = new RECEIVED() */,
    /*public static final*/ WAITING_APPROVAL /* = new WAITING_APPROVAL() */,
    /*public static final*/ EXECUTED /* = new EXECUTED() */,
    /*public static final*/ FAILED /* = new FAILED() */,
    /*public static final*/ BLOCKED /* = new BLOCKED() */,
    /*public static final*/ DENIED /* = new DENIED() */,
    /*public static final*/ TIMED_OUT /* = new TIMED_OUT() */;
    
    CommandTraceStatus() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ui.viewmodel.CommandTraceStatus> getEntries() {
        return null;
    }
}