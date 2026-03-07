package com.vesper.flipper.domain.protocol;

import kotlinx.serialization.Serializable;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/vesper/flipper/domain/protocol/SecurityLevel;", "", "displayName", "", "color", "", "(Ljava/lang/String;ILjava/lang/String;J)V", "getColor", "()J", "getDisplayName", "()Ljava/lang/String;", "NONE", "LOW", "MEDIUM", "HIGH", "VERY_HIGH", "app_debug"})
public enum SecurityLevel {
    /*public static final*/ NONE /* = new NONE(null, 0L) */,
    /*public static final*/ LOW /* = new LOW(null, 0L) */,
    /*public static final*/ MEDIUM /* = new MEDIUM(null, 0L) */,
    /*public static final*/ HIGH /* = new HIGH(null, 0L) */,
    /*public static final*/ VERY_HIGH /* = new VERY_HIGH(null, 0L) */;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String displayName = null;
    private final long color = 0L;
    
    SecurityLevel(java.lang.String displayName, long color) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    public final long getColor() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.protocol.SecurityLevel> getEntries() {
        return null;
    }
}