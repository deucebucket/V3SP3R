package com.vesper.flipper.domain.mode;

import kotlinx.coroutines.flow.StateFlow;

/**
 * Mode-specific configuration
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\u009f\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005H\u00c6\u0001J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00107\u001a\u000208H\u00d6\u0001J\t\u00109\u001a\u00020:H\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015\u00a8\u0006<"}, d2 = {"Lcom/vesper/flipper/domain/mode/ModeConfig;", "", "mode", "Lcom/vesper/flipper/domain/mode/OperationMode;", "enableBleScanning", "", "enableSubGhzRx", "enableSubGhzTx", "enableNfcRead", "enableNfcWrite", "enableInfrared", "enableDeviceTracking", "enableLogging", "enableNotifications", "bleAdvertising", "wifiEnabled", "autoConnect", "confirmHighRiskOps", "requireHoldToConfirm", "(Lcom/vesper/flipper/domain/mode/OperationMode;ZZZZZZZZZZZZZZ)V", "getAutoConnect", "()Z", "getBleAdvertising", "getConfirmHighRiskOps", "getEnableBleScanning", "getEnableDeviceTracking", "getEnableInfrared", "getEnableLogging", "getEnableNfcRead", "getEnableNfcWrite", "getEnableNotifications", "getEnableSubGhzRx", "getEnableSubGhzTx", "getMode", "()Lcom/vesper/flipper/domain/mode/OperationMode;", "getRequireHoldToConfirm", "getWifiEnabled", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "app_debug"})
public final class ModeConfig {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.mode.OperationMode mode = null;
    private final boolean enableBleScanning = false;
    private final boolean enableSubGhzRx = false;
    private final boolean enableSubGhzTx = false;
    private final boolean enableNfcRead = false;
    private final boolean enableNfcWrite = false;
    private final boolean enableInfrared = false;
    private final boolean enableDeviceTracking = false;
    private final boolean enableLogging = false;
    private final boolean enableNotifications = false;
    private final boolean bleAdvertising = false;
    private final boolean wifiEnabled = false;
    private final boolean autoConnect = false;
    private final boolean confirmHighRiskOps = false;
    private final boolean requireHoldToConfirm = false;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.mode.ModeConfig.Companion Companion = null;
    
    public ModeConfig(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.mode.OperationMode mode, boolean enableBleScanning, boolean enableSubGhzRx, boolean enableSubGhzTx, boolean enableNfcRead, boolean enableNfcWrite, boolean enableInfrared, boolean enableDeviceTracking, boolean enableLogging, boolean enableNotifications, boolean bleAdvertising, boolean wifiEnabled, boolean autoConnect, boolean confirmHighRiskOps, boolean requireHoldToConfirm) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.mode.OperationMode getMode() {
        return null;
    }
    
    public final boolean getEnableBleScanning() {
        return false;
    }
    
    public final boolean getEnableSubGhzRx() {
        return false;
    }
    
    public final boolean getEnableSubGhzTx() {
        return false;
    }
    
    public final boolean getEnableNfcRead() {
        return false;
    }
    
    public final boolean getEnableNfcWrite() {
        return false;
    }
    
    public final boolean getEnableInfrared() {
        return false;
    }
    
    public final boolean getEnableDeviceTracking() {
        return false;
    }
    
    public final boolean getEnableLogging() {
        return false;
    }
    
    public final boolean getEnableNotifications() {
        return false;
    }
    
    public final boolean getBleAdvertising() {
        return false;
    }
    
    public final boolean getWifiEnabled() {
        return false;
    }
    
    public final boolean getAutoConnect() {
        return false;
    }
    
    public final boolean getConfirmHighRiskOps() {
        return false;
    }
    
    public final boolean getRequireHoldToConfirm() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.mode.OperationMode component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.mode.ModeConfig copy(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.mode.OperationMode mode, boolean enableBleScanning, boolean enableSubGhzRx, boolean enableSubGhzTx, boolean enableNfcRead, boolean enableNfcWrite, boolean enableInfrared, boolean enableDeviceTracking, boolean enableLogging, boolean enableNotifications, boolean bleAdvertising, boolean wifiEnabled, boolean autoConnect, boolean confirmHighRiskOps, boolean requireHoldToConfirm) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/vesper/flipper/domain/mode/ModeConfig$Companion;", "", "()V", "forMode", "Lcom/vesper/flipper/domain/mode/ModeConfig;", "mode", "Lcom/vesper/flipper/domain/mode/OperationMode;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.mode.ModeConfig forMode(@org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.mode.OperationMode mode) {
            return null;
        }
    }
}