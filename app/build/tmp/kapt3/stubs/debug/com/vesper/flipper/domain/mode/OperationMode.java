package com.vesper.flipper.domain.mode;

import kotlinx.coroutines.flow.StateFlow;

/**
 * Operation Modes
 *
 * Different operational modes that change app behavior:
 * - STANDARD: Normal operation, all features available
 * - RECON: Passive scanning and intelligence gathering
 * - INTEL: Analysis and research mode
 * - STEALTH: Minimal RF emissions, covert operation
 * - ASSAULT: Active testing mode (requires explicit unlock)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/vesper/flipper/domain/mode/OperationMode;", "", "displayName", "", "icon", "description", "color", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getColor", "()J", "getDescription", "()Ljava/lang/String;", "getDisplayName", "getIcon", "STANDARD", "RECON", "INTEL", "STEALTH", "ASSAULT", "app_debug"})
public enum OperationMode {
    /*public static final*/ STANDARD /* = new STANDARD(null, null, null, 0L) */,
    /*public static final*/ RECON /* = new RECON(null, null, null, 0L) */,
    /*public static final*/ INTEL /* = new INTEL(null, null, null, 0L) */,
    /*public static final*/ STEALTH /* = new STEALTH(null, null, null, 0L) */,
    /*public static final*/ ASSAULT /* = new ASSAULT(null, null, null, 0L) */;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String displayName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String icon = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    private final long color = 0L;
    
    OperationMode(java.lang.String displayName, java.lang.String icon, java.lang.String description, long color) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final long getColor() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.mode.OperationMode> getEntries() {
        return null;
    }
}