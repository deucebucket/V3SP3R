package com.vesper.flipper.ble;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J-\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\u0013\u0010&\u001a\u00020\u00142\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u0010H\u00d6\u0001J\t\u0010)\u001a\u00020\u001dH\u00d6\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0011\u0010\u001c\u001a\u00020\u001d8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0012\u00a8\u0006+"}, d2 = {"Lcom/vesper/flipper/ble/ConnectionDiagnosticsReport;", "", "startedAtMs", "", "completedAtMs", "checks", "", "Lcom/vesper/flipper/ble/ConnectionCheckResult;", "(JJLjava/util/List;)V", "getChecks", "()Ljava/util/List;", "getCompletedAtMs", "()J", "durationMs", "getDurationMs", "failedCount", "", "getFailedCount", "()I", "hasFailures", "", "getHasFailures", "()Z", "hasWarnings", "getHasWarnings", "passedCount", "getPassedCount", "getStartedAtMs", "summary", "", "getSummary", "()Ljava/lang/String;", "warningCount", "getWarningCount", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class ConnectionDiagnosticsReport {
    private final long startedAtMs = 0L;
    private final long completedAtMs = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.ble.ConnectionCheckResult> checks = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ble.ConnectionDiagnosticsReport.Companion Companion = null;
    
    public ConnectionDiagnosticsReport(long startedAtMs, long completedAtMs, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ble.ConnectionCheckResult> checks) {
        super();
    }
    
    public final long getStartedAtMs() {
        return 0L;
    }
    
    public final long getCompletedAtMs() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ble.ConnectionCheckResult> getChecks() {
        return null;
    }
    
    public final long getDurationMs() {
        return 0L;
    }
    
    public final int getPassedCount() {
        return 0;
    }
    
    public final int getWarningCount() {
        return 0;
    }
    
    public final int getFailedCount() {
        return 0;
    }
    
    public final boolean getHasFailures() {
        return false;
    }
    
    public final boolean getHasWarnings() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSummary() {
        return null;
    }
    
    public ConnectionDiagnosticsReport() {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ble.ConnectionCheckResult> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ble.ConnectionDiagnosticsReport copy(long startedAtMs, long completedAtMs, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ble.ConnectionCheckResult> checks) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/vesper/flipper/ble/ConnectionDiagnosticsReport$Companion;", "", "()V", "idle", "Lcom/vesper/flipper/ble/ConnectionDiagnosticsReport;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.ConnectionDiagnosticsReport idle() {
            return null;
        }
    }
}