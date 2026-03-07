package com.vesper.flipper.domain.mode;

import kotlinx.coroutines.flow.StateFlow;

/**
 * Operation Mode Manager
 * Singleton that manages the current operation mode
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u001cJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u001f\u001a\u00020\t\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006%"}, d2 = {"Lcom/vesper/flipper/domain/mode/OperationModeManager;", "", "()V", "_assaultModeUnlocked", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_currentConfig", "Lcom/vesper/flipper/domain/mode/ModeConfig;", "_currentMode", "Lcom/vesper/flipper/domain/mode/OperationMode;", "_modeHistory", "", "Lcom/vesper/flipper/domain/mode/OperationModeManager$ModeChange;", "assaultModeUnlocked", "Lkotlinx/coroutines/flow/StateFlow;", "getAssaultModeUnlocked", "()Lkotlinx/coroutines/flow/StateFlow;", "currentConfig", "getCurrentConfig", "currentMode", "getCurrentMode", "getBlockedReason", "", "action", "getModeHistory", "", "isActionAllowed", "lockAssaultMode", "", "setMode", "Lkotlin/Result;", "mode", "setMode-IoAF18A", "(Lcom/vesper/flipper/domain/mode/OperationMode;)Ljava/lang/Object;", "unlockAssaultMode", "confirmation", "ModeChange", "app_debug"})
public final class OperationModeManager {
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.mode.OperationMode> _currentMode = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.mode.OperationMode> currentMode = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.mode.ModeConfig> _currentConfig = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.mode.ModeConfig> currentConfig = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _assaultModeUnlocked = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> assaultModeUnlocked = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<com.vesper.flipper.domain.mode.OperationModeManager.ModeChange> _modeHistory = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.mode.OperationModeManager INSTANCE = null;
    
    private OperationModeManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.mode.OperationMode> getCurrentMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.mode.ModeConfig> getCurrentConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getAssaultModeUnlocked() {
        return null;
    }
    
    public final boolean unlockAssaultMode(@org.jetbrains.annotations.NotNull
    java.lang.String confirmation) {
        return false;
    }
    
    public final void lockAssaultMode() {
    }
    
    public final boolean isActionAllowed(@org.jetbrains.annotations.NotNull
    java.lang.String action) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBlockedReason(@org.jetbrains.annotations.NotNull
    java.lang.String action) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.mode.OperationModeManager.ModeChange> getModeHistory() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/vesper/flipper/domain/mode/OperationModeManager$ModeChange;", "", "from", "Lcom/vesper/flipper/domain/mode/OperationMode;", "to", "timestamp", "", "(Lcom/vesper/flipper/domain/mode/OperationMode;Lcom/vesper/flipper/domain/mode/OperationMode;J)V", "getFrom", "()Lcom/vesper/flipper/domain/mode/OperationMode;", "getTimestamp", "()J", "getTo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ModeChange {
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.mode.OperationMode from = null;
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.mode.OperationMode to = null;
        private final long timestamp = 0L;
        
        public ModeChange(@org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.mode.OperationMode from, @org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.mode.OperationMode to, long timestamp) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.mode.OperationMode getFrom() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.mode.OperationMode getTo() {
            return null;
        }
        
        public final long getTimestamp() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.mode.OperationMode component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.mode.OperationMode component2() {
            return null;
        }
        
        public final long component3() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.mode.OperationModeManager.ModeChange copy(@org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.mode.OperationMode from, @org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.mode.OperationMode to, long timestamp) {
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
}