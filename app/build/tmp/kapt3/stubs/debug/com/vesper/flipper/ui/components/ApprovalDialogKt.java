package com.vesper.flipper.ui.components;

import androidx.compose.animation.core.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.window.DialogProperties;
import com.vesper.flipper.domain.model.PendingApproval;
import com.vesper.flipper.domain.model.RiskLevel;
import com.vesper.flipper.ui.theme.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007\u001a&\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"DOUBLE_TAP_ARM_TIMEOUT_MS", "", "ApprovalDialog", "", "approval", "Lcom/vesper/flipper/domain/model/PendingApproval;", "onApprove", "Lkotlin/Function0;", "onReject", "DoubleTapConfirmButton", "isArmed", "", "enabled", "onTap", "app_debug"})
public final class ApprovalDialogKt {
    private static final long DOUBLE_TAP_ARM_TIMEOUT_MS = 1800L;
    
    @androidx.compose.runtime.Composable
    public static final void ApprovalDialog(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.PendingApproval approval, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onApprove, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onReject) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void DoubleTapConfirmButton(boolean isArmed, boolean enabled, kotlin.jvm.functions.Function0<kotlin.Unit> onTap) {
    }
}