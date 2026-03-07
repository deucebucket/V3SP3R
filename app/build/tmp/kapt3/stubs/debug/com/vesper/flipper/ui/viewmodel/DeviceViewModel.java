package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ble.BleServiceManager;
import com.vesper.flipper.ble.CliCapabilityLevel;
import com.vesper.flipper.ble.CliCapabilityStatus;
import com.vesper.flipper.ble.CommandPipelineAutotuneStatus;
import com.vesper.flipper.ble.ConnectionCheckLevel;
import com.vesper.flipper.ble.ConnectionCheckResult;
import com.vesper.flipper.ble.ConnectionDiagnosticsReport;
import com.vesper.flipper.ble.ConnectionState;
import com.vesper.flipper.ble.FirmwareCompatibilityProfile;
import com.vesper.flipper.ble.FlipperDevice;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.data.SettingsStore;
import com.vesper.flipper.domain.model.DeviceInfo;
import com.vesper.flipper.domain.model.FlipperRemoteButton;
import com.vesper.flipper.domain.model.StorageInfo;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010=\u001a\u00020>H\u0002J\u000e\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u000fJ\u0006\u0010A\u001a\u00020>J\u0006\u0010B\u001a\u00020>J\b\u0010C\u001a\u00020>H\u0002J\u0006\u0010D\u001a\u00020>J\u0006\u0010E\u001a\u00020>J\u0018\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020\u0019J.\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001d0K2\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bL\u0010MJ,\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001d0K2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0019H\u0082@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bO\u0010MJ\u0006\u0010P\u001a\u00020>J\u0006\u0010Q\u001a\u00020>R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00170\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0!\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0!\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010#R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110!\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130!\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150!\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00170!\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u0002010!\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00190!\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00190!\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00190!\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u000e\u00106\u001a\u000207X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0!\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0!\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010#\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006R"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/DeviceViewModel;", "Landroidx/lifecycle/ViewModel;", "settingsStore", "Lcom/vesper/flipper/data/SettingsStore;", "fileSystem", "Lcom/vesper/flipper/ble/FlipperFileSystem;", "bleServiceManager", "Lcom/vesper/flipper/ble/BleServiceManager;", "(Lcom/vesper/flipper/data/SettingsStore;Lcom/vesper/flipper/ble/FlipperFileSystem;Lcom/vesper/flipper/ble/BleServiceManager;)V", "_autotuneStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/ble/CommandPipelineAutotuneStatus;", "_cliCapabilityStatus", "Lcom/vesper/flipper/ble/CliCapabilityStatus;", "_connectedDevice", "Lcom/vesper/flipper/ble/FlipperDevice;", "_connectionDiagnostics", "Lcom/vesper/flipper/ble/ConnectionDiagnosticsReport;", "_connectionState", "Lcom/vesper/flipper/ble/ConnectionState;", "_deviceInfo", "Lcom/vesper/flipper/domain/model/DeviceInfo;", "_discoveredDevices", "", "_isRefreshing", "", "_isRunningDiagnostics", "_isSendingRemoteInput", "_remoteInputStatus", "", "_storageInfo", "Lcom/vesper/flipper/domain/model/StorageInfo;", "autotuneStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getAutotuneStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "cliCapabilityStatus", "getCliCapabilityStatus", "connectedDevice", "getConnectedDevice", "connectionDiagnostics", "getConnectionDiagnostics", "connectionState", "getConnectionState", "deviceInfo", "getDeviceInfo", "discoveredDevices", "getDiscoveredDevices", "firmwareCompatibility", "Lcom/vesper/flipper/ble/FirmwareCompatibilityProfile;", "getFirmwareCompatibility", "isRefreshing", "isRunningDiagnostics", "isSendingRemoteInput", "refreshMutex", "Lkotlinx/coroutines/sync/Mutex;", "remoteInputMutex", "remoteInputStatus", "getRemoteInputStatus", "storageInfo", "getStorageInfo", "clearConnectionTransientState", "", "connectToDevice", "device", "connectUsb", "disconnect", "observeServiceState", "refreshDeviceInfo", "runConnectionDiagnostics", "sendRemoteButton", "button", "Lcom/vesper/flipper/domain/model/FlipperRemoteButton;", "longPress", "sendRemoteButtonAwait", "Lkotlin/Result;", "sendRemoteButtonAwait-0E7RQCE", "(Lcom/vesper/flipper/domain/model/FlipperRemoteButton;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRemoteButtonLocked", "sendRemoteButtonLocked-0E7RQCE", "startScan", "stopScan", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class DeviceViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.SettingsStore settingsStore = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperFileSystem fileSystem = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.BleServiceManager bleServiceManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.ConnectionState> _connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.ConnectionState> connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.ble.FlipperDevice>> _discoveredDevices = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ble.FlipperDevice>> discoveredDevices = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.FlipperDevice> _connectedDevice = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FlipperDevice> connectedDevice = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.DeviceInfo> _deviceInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.DeviceInfo> deviceInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.StorageInfo> _storageInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.StorageInfo> storageInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.CliCapabilityStatus> _cliCapabilityStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CliCapabilityStatus> cliCapabilityStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.ConnectionDiagnosticsReport> _connectionDiagnostics = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.ConnectionDiagnosticsReport> connectionDiagnostics = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRunningDiagnostics = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRunningDiagnostics = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.CommandPipelineAutotuneStatus> _autotuneStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CommandPipelineAutotuneStatus> autotuneStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FirmwareCompatibilityProfile> firmwareCompatibility = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSendingRemoteInput = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSendingRemoteInput = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _remoteInputStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> remoteInputStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.sync.Mutex refreshMutex = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.sync.Mutex remoteInputMutex = null;
    
    @javax.inject.Inject
    public DeviceViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.SettingsStore settingsStore, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperFileSystem fileSystem, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.BleServiceManager bleServiceManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.ConnectionState> getConnectionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ble.FlipperDevice>> getDiscoveredDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FlipperDevice> getConnectedDevice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.DeviceInfo> getDeviceInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.StorageInfo> getStorageInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CliCapabilityStatus> getCliCapabilityStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.ConnectionDiagnosticsReport> getConnectionDiagnostics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRunningDiagnostics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CommandPipelineAutotuneStatus> getAutotuneStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FirmwareCompatibilityProfile> getFirmwareCompatibility() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSendingRemoteInput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getRemoteInputStatus() {
        return null;
    }
    
    private final void observeServiceState() {
    }
    
    private final void clearConnectionTransientState() {
    }
    
    public final void startScan() {
    }
    
    public final void stopScan() {
    }
    
    public final void connectToDevice(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperDevice device) {
    }
    
    public final void connectUsb() {
    }
    
    public final void disconnect() {
    }
    
    public final void refreshDeviceInfo() {
    }
    
    public final void runConnectionDiagnostics() {
    }
    
    public final void sendRemoteButton(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.FlipperRemoteButton button, boolean longPress) {
    }
}