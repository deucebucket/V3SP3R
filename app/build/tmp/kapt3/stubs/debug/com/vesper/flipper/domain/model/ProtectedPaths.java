package com.vesper.flipper.domain.model;

/**
 * Protected path patterns that require elevated permissions
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/vesper/flipper/domain/model/ProtectedPaths;", "", "()V", "FIRMWARE_PATHS", "", "", "getFIRMWARE_PATHS", "()Ljava/util/List;", "SENSITIVE_EXTENSIONS", "getSENSITIVE_EXTENSIONS", "SYSTEM_PATHS", "getSYSTEM_PATHS", "isFirmwarePath", "", "path", "isProtected", "isSystemPath", "app_debug"})
public final class ProtectedPaths {
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> SYSTEM_PATHS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> FIRMWARE_PATHS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> SENSITIVE_EXTENSIONS = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.ProtectedPaths INSTANCE = null;
    
    private ProtectedPaths() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getSYSTEM_PATHS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getFIRMWARE_PATHS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getSENSITIVE_EXTENSIONS() {
        return null;
    }
    
    public final boolean isProtected(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return false;
    }
    
    public final boolean isSystemPath(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return false;
    }
    
    public final boolean isFirmwarePath(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return false;
    }
}