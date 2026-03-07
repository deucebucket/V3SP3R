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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/AuditFilterType;", "", "(Ljava/lang/String;I)V", "ALL", "COMMANDS", "APPROVALS", "ERRORS", "app_debug"})
public enum AuditFilterType {
    /*public static final*/ ALL /* = new ALL() */,
    /*public static final*/ COMMANDS /* = new COMMANDS() */,
    /*public static final*/ APPROVALS /* = new APPROVALS() */,
    /*public static final*/ ERRORS /* = new ERRORS() */;
    
    AuditFilterType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ui.viewmodel.AuditFilterType> getEntries() {
        return null;
    }
}