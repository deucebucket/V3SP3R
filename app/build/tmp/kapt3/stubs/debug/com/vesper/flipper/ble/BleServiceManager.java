package com.vesper.flipper.ble;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * BLE Service Manager
 *
 * Provides proper Hilt-injectable access to FlipperBleService.
 * Handles service binding lifecycle and provides the service instance
 * to ViewModels and other components that need BLE access.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\'\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010(\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010*J\u001a\u0010+\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010(\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010*J\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020-H\u0002J\u000e\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\tJ\u0006\u00101\u001a\u00020-J\u0006\u00102\u001a\u00020-J\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015J\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u0015J\b\u00106\u001a\u0004\u0018\u00010\u0011J\b\u00107\u001a\u00020-H\u0002J\u0018\u00108\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010:J$\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010>\u001a\u00020=H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b?\u0010@J\u0006\u0010A\u001a\u00020-J\u0006\u0010B\u001a\u00020-J\u0006\u0010C\u001a\u00020-R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0010\u0010 \u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006E"}, d2 = {"Lcom/vesper/flipper/ble/BleServiceManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_cliCapabilityStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/ble/CliCapabilityStatus;", "_connectedDevice", "Lcom/vesper/flipper/ble/FlipperDevice;", "_connectionState", "Lcom/vesper/flipper/ble/ConnectionState;", "_discoveredDevices", "", "_isServiceBound", "", "_service", "Lcom/vesper/flipper/ble/FlipperBleService;", "cliCapabilityJob", "Lkotlinx/coroutines/Job;", "cliCapabilityStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getCliCapabilityStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "connectedDevice", "getConnectedDevice", "connectedDeviceJob", "connectionState", "getConnectionState", "connectionStateJob", "discoveredDevices", "getDiscoveredDevices", "discoveredDevicesJob", "isBinding", "isServiceBound", "managerScope", "Lkotlinx/coroutines/CoroutineScope;", "serviceConnection", "Landroid/content/ServiceConnection;", "awaitConnectedService", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitService", "bindService", "", "cancelServiceCollectors", "connect", "device", "connectUsb", "disconnect", "getConnectedDeviceFlow", "getConnectionStateFlow", "getDiscoveredDevicesFlow", "getService", "observeServiceState", "probeCliCapability", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRawData", "Lkotlin/Result;", "", "data", "sendRawData-gIAlu-s", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startScanning", "stopScanning", "unbindService", "Companion", "app_debug"})
public final class BleServiceManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private com.vesper.flipper.ble.FlipperBleService _service;
    private boolean isBinding = false;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isServiceBound = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isServiceBound = null;
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
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.CliCapabilityStatus> _cliCapabilityStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CliCapabilityStatus> cliCapabilityStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope managerScope = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job connectionStateJob;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job discoveredDevicesJob;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job connectedDeviceJob;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job cliCapabilityJob;
    @org.jetbrains.annotations.NotNull
    private final android.content.ServiceConnection serviceConnection = null;
    private static final long DEFAULT_BIND_TIMEOUT_MS = 4000L;
    private static final long DEFAULT_CONNECT_TIMEOUT_MS = 8000L;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ble.BleServiceManager.Companion Companion = null;
    
    @javax.inject.Inject
    public BleServiceManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isServiceBound() {
        return null;
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
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CliCapabilityStatus> getCliCapabilityStatus() {
        return null;
    }
    
    /**
     * Start and bind to the BLE service
     */
    public final void bindService() {
    }
    
    /**
     * Unbind from the service
     */
    public final void unbindService() {
    }
    
    /**
     * Get the service instance (may be null if not bound)
     */
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.ble.FlipperBleService getService() {
        return null;
    }
    
    /**
     * Start scanning for Flipper devices
     */
    public final void startScanning() {
    }
    
    /**
     * Stop scanning
     */
    public final void stopScanning() {
    }
    
    /**
     * Connect to a specific device
     */
    public final void connect(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperDevice device) {
    }
    
    public final void connectUsb() {
    }
    
    /**
     * Disconnect from current device
     */
    public final void disconnect() {
    }
    
    /**
     * Get current connection state from service
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.ConnectionState> getConnectionStateFlow() {
        return null;
    }
    
    /**
     * Get discovered devices from service
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ble.FlipperDevice>> getDiscoveredDevicesFlow() {
        return null;
    }
    
    /**
     * Get connected device from service
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FlipperDevice> getConnectedDeviceFlow() {
        return null;
    }
    
    private final void observeServiceState() {
    }
    
    private final void cancelServiceCollectors() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object awaitService(long timeoutMs, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.FlipperBleService> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object awaitConnectedService(long timeoutMs, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.FlipperBleService> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object probeCliCapability(boolean force, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.CliCapabilityStatus> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/ble/BleServiceManager$Companion;", "", "()V", "DEFAULT_BIND_TIMEOUT_MS", "", "DEFAULT_CONNECT_TIMEOUT_MS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}