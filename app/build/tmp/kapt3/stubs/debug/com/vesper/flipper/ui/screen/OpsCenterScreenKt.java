package com.vesper.flipper.ui.screen;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.vesper.flipper.ble.CliCapabilityStatus;
import com.vesper.flipper.ble.CommandPipelineAutotuneStatus;
import com.vesper.flipper.ble.ConnectionCheckLevel;
import com.vesper.flipper.ble.ConnectionDiagnosticsReport;
import com.vesper.flipper.ble.ConnectionState;
import com.vesper.flipper.ble.FirmwareCompatibilityProfile;
import com.vesper.flipper.domain.model.FlipperRemoteButton;
import com.vesper.flipper.ui.viewmodel.DeviceViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u00d4\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u0012\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007\u001a^\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003\u001a&\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00072\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003\u001aD\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003\u001a\u0010\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u001eH\u0002\u00a8\u00067"}, d2 = {"MacroRecorderCard", "", "macroName", "", "onMacroNameChange", "Lkotlin/Function1;", "isRecording", "", "longPressMode", "onLongPressModeChange", "onStartRecording", "Lkotlin/Function0;", "onStopRecording", "onClear", "onStartReplay", "onStopReplay", "isReplaying", "steps", "", "Lcom/vesper/flipper/ui/screen/MacroStep;", "replayStatus", "remoteInputStatus", "isSendingRemoteInput", "onPressButton", "Lcom/vesper/flipper/domain/model/FlipperRemoteButton;", "OpsCenterScreen", "viewModel", "Lcom/vesper/flipper/ui/viewmodel/DeviceViewModel;", "PipelineHealthCard", "connectionState", "Lcom/vesper/flipper/ble/ConnectionState;", "connectedName", "cliStatus", "Lcom/vesper/flipper/ble/CliCapabilityStatus;", "diagnostics", "Lcom/vesper/flipper/ble/ConnectionDiagnosticsReport;", "autotuneStatus", "Lcom/vesper/flipper/ble/CommandPipelineAutotuneStatus;", "firmwareCompatibility", "Lcom/vesper/flipper/ble/FirmwareCompatibilityProfile;", "isRunningDiagnostics", "onRunDiagnostics", "onRefreshInfo", "RemoteButton", "label", "enabled", "onClick", "RunbooksCard", "status", "inFlight", "onRunLinkHealth", "onRunInputSmoke", "onRunRecover", "connectionLabel", "state", "app_debug"})
public final class OpsCenterScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void OpsCenterScreen(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.DeviceViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void PipelineHealthCard(com.vesper.flipper.ble.ConnectionState connectionState, java.lang.String connectedName, com.vesper.flipper.ble.CliCapabilityStatus cliStatus, com.vesper.flipper.ble.ConnectionDiagnosticsReport diagnostics, com.vesper.flipper.ble.CommandPipelineAutotuneStatus autotuneStatus, com.vesper.flipper.ble.FirmwareCompatibilityProfile firmwareCompatibility, boolean isRunningDiagnostics, kotlin.jvm.functions.Function0<kotlin.Unit> onRunDiagnostics, kotlin.jvm.functions.Function0<kotlin.Unit> onRefreshInfo) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void RunbooksCard(java.lang.String status, boolean inFlight, kotlin.jvm.functions.Function0<kotlin.Unit> onRunLinkHealth, kotlin.jvm.functions.Function0<kotlin.Unit> onRunInputSmoke, kotlin.jvm.functions.Function0<kotlin.Unit> onRunRecover) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void MacroRecorderCard(java.lang.String macroName, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onMacroNameChange, boolean isRecording, boolean longPressMode, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onLongPressModeChange, kotlin.jvm.functions.Function0<kotlin.Unit> onStartRecording, kotlin.jvm.functions.Function0<kotlin.Unit> onStopRecording, kotlin.jvm.functions.Function0<kotlin.Unit> onClear, kotlin.jvm.functions.Function0<kotlin.Unit> onStartReplay, kotlin.jvm.functions.Function0<kotlin.Unit> onStopReplay, boolean isReplaying, java.util.List<com.vesper.flipper.ui.screen.MacroStep> steps, java.lang.String replayStatus, java.lang.String remoteInputStatus, boolean isSendingRemoteInput, kotlin.jvm.functions.Function1<? super com.vesper.flipper.domain.model.FlipperRemoteButton, kotlin.Unit> onPressButton) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void RemoteButton(java.lang.String label, boolean enabled, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    private static final java.lang.String connectionLabel(com.vesper.flipper.ble.ConnectionState state) {
        return null;
    }
}