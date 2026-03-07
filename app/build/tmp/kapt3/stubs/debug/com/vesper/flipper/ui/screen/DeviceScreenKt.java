package com.vesper.flipper.ui.screen;

import androidx.compose.animation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.vesper.flipper.ble.CliCapabilityLevel;
import com.vesper.flipper.ble.CliCapabilityStatus;
import com.vesper.flipper.ble.CommandPipelineAutotuneStatus;
import com.vesper.flipper.ble.ConnectionCheckLevel;
import com.vesper.flipper.ble.ConnectionDiagnosticsReport;
import com.vesper.flipper.ble.ConnectionState;
import com.vesper.flipper.ble.FirmwareCompatibilityProfile;
import com.vesper.flipper.ble.FirmwareTransportMode;
import com.vesper.flipper.ble.FlipperDevice;
import com.vesper.flipper.domain.model.FlipperRemoteButton;
import com.vesper.flipper.ui.theme.*;
import com.vesper.flipper.ui.viewmodel.DeviceViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003\u001a(\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003\u001a&\u0010\u0014\u001a\u00020\u00012\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016\u00a2\u0006\u0002\b\u0018\u00a2\u0006\u0002\b\u0019H\u0003\u001a\u001a\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0003\u001a&\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003\u001a\u0012\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%H\u0007\u001a.\u0010&\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003\u001a4\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010*2\u0018\u0010/\u001a\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000100H\u0003\u001a:\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\r2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003\u001a\u0010\u00107\u001a\u00020*2\u0006\u00108\u001a\u000209H\u0002\u00a8\u0006:"}, d2 = {"CommandAutomationStatusCard", "", "connectionState", "Lcom/vesper/flipper/ble/ConnectionState;", "cliStatus", "Lcom/vesper/flipper/ble/CliCapabilityStatus;", "diagnostics", "Lcom/vesper/flipper/ble/ConnectionDiagnosticsReport;", "autotuneStatus", "Lcom/vesper/flipper/ble/CommandPipelineAutotuneStatus;", "firmwareCompatibility", "Lcom/vesper/flipper/ble/FirmwareCompatibilityProfile;", "isRunningDiagnostics", "", "onRunDiagnostics", "Lkotlin/Function0;", "ConnectionStatusCard", "connectedDevice", "Lcom/vesper/flipper/ble/FlipperDevice;", "onDisconnect", "DPadRow", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DeviceInfoCard", "deviceInfo", "Lcom/vesper/flipper/domain/model/DeviceInfo;", "storageInfo", "Lcom/vesper/flipper/domain/model/StorageInfo;", "DeviceListItem", "device", "isConnecting", "onClick", "DeviceScreen", "viewModel", "Lcom/vesper/flipper/ui/viewmodel/DeviceViewModel;", "RemoteControlButton", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "", "enabled", "RemoteControlCard", "isSendingRemoteInput", "statusText", "onSendButton", "Lkotlin/Function2;", "Lcom/vesper/flipper/domain/model/FlipperRemoteButton;", "ScanSection", "isScanning", "onStartScan", "onStopScan", "onConnectUsb", "formatBytes", "bytes", "", "app_debug"})
public final class DeviceScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void DeviceScreen(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.DeviceViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ConnectionStatusCard(com.vesper.flipper.ble.ConnectionState connectionState, com.vesper.flipper.ble.FlipperDevice connectedDevice, kotlin.jvm.functions.Function0<kotlin.Unit> onDisconnect) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void DeviceInfoCard(com.vesper.flipper.domain.model.DeviceInfo deviceInfo, com.vesper.flipper.domain.model.StorageInfo storageInfo) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void CommandAutomationStatusCard(com.vesper.flipper.ble.ConnectionState connectionState, com.vesper.flipper.ble.CliCapabilityStatus cliStatus, com.vesper.flipper.ble.ConnectionDiagnosticsReport diagnostics, com.vesper.flipper.ble.CommandPipelineAutotuneStatus autotuneStatus, com.vesper.flipper.ble.FirmwareCompatibilityProfile firmwareCompatibility, boolean isRunningDiagnostics, kotlin.jvm.functions.Function0<kotlin.Unit> onRunDiagnostics) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void RemoteControlCard(boolean isSendingRemoteInput, java.lang.String statusText, kotlin.jvm.functions.Function2<? super com.vesper.flipper.domain.model.FlipperRemoteButton, ? super java.lang.Boolean, kotlin.Unit> onSendButton) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void DPadRow(kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.RowScope, kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void RemoteControlButton(androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String label, boolean enabled, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ScanSection(boolean isScanning, kotlin.jvm.functions.Function0<kotlin.Unit> onStartScan, kotlin.jvm.functions.Function0<kotlin.Unit> onStopScan, kotlin.jvm.functions.Function0<kotlin.Unit> onConnectUsb) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void DeviceListItem(com.vesper.flipper.ble.FlipperDevice device, boolean isConnecting, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    private static final java.lang.String formatBytes(long bytes) {
        return null;
    }
}