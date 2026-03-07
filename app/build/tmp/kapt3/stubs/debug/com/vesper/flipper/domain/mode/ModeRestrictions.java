package com.vesper.flipper.domain.mode;

import kotlinx.coroutines.flow.StateFlow;

/**
 * Mode restrictions - what's blocked in each mode
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003JC\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/vesper/flipper/domain/mode/ModeRestrictions;", "", "mode", "Lcom/vesper/flipper/domain/mode/OperationMode;", "blockedActions", "", "", "warnings", "requiredPermissions", "(Lcom/vesper/flipper/domain/mode/OperationMode;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBlockedActions", "()Ljava/util/List;", "getMode", "()Lcom/vesper/flipper/domain/mode/OperationMode;", "getRequiredPermissions", "getWarnings", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class ModeRestrictions {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.mode.OperationMode mode = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> blockedActions = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> warnings = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> requiredPermissions = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.mode.ModeRestrictions.Companion Companion = null;
    
    public ModeRestrictions(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.mode.OperationMode mode, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> blockedActions, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> warnings, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> requiredPermissions) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.mode.OperationMode getMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getBlockedActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getWarnings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getRequiredPermissions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.mode.OperationMode component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.mode.ModeRestrictions copy(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.mode.OperationMode mode, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> blockedActions, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> warnings, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> requiredPermissions) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/vesper/flipper/domain/mode/ModeRestrictions$Companion;", "", "()V", "forMode", "Lcom/vesper/flipper/domain/mode/ModeRestrictions;", "mode", "Lcom/vesper/flipper/domain/mode/OperationMode;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.mode.ModeRestrictions forMode(@org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.mode.OperationMode mode) {
            return null;
        }
    }
}