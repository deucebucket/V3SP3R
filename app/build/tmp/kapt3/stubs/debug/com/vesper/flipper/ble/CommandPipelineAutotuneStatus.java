package com.vesper.flipper.ble;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0013J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0007H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0007H\u00c6\u0003J\t\u00104\u001a\u00020\rH\u00c6\u0003J\t\u00105\u001a\u00020\u0007H\u00c6\u0003J\u008b\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u00c6\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020\u0005H\u00d6\u0001J\t\u0010;\u001a\u00020!H\u00d6\u0001R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(\u00a8\u0006<"}, d2 = {"Lcom/vesper/flipper/ble/CommandPipelineAutotuneStatus;", "", "profile", "Lcom/vesper/flipper/ble/CommandPipelineProfile;", "cliRetryAttempts", "", "cliRetryDelayMs", "", "rpcRetryAttempts", "rpcRetryDelayMs", "fileWriteRetryAttempts", "fileWriteRetryDelayMs", "successRate", "", "averageLatencyMs", "busySignals", "disconnectSignals", "sampleSize", "lastUpdatedMs", "(Lcom/vesper/flipper/ble/CommandPipelineProfile;IJIJIJFJIIIJ)V", "getAverageLatencyMs", "()J", "getBusySignals", "()I", "getCliRetryAttempts", "getCliRetryDelayMs", "getDisconnectSignals", "getFileWriteRetryAttempts", "getFileWriteRetryDelayMs", "getLastUpdatedMs", "getProfile", "()Lcom/vesper/flipper/ble/CommandPipelineProfile;", "profileLabel", "", "getProfileLabel", "()Ljava/lang/String;", "getRpcRetryAttempts", "getRpcRetryDelayMs", "getSampleSize", "getSuccessRate", "()F", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class CommandPipelineAutotuneStatus {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.CommandPipelineProfile profile = null;
    private final int cliRetryAttempts = 0;
    private final long cliRetryDelayMs = 0L;
    private final int rpcRetryAttempts = 0;
    private final long rpcRetryDelayMs = 0L;
    private final int fileWriteRetryAttempts = 0;
    private final long fileWriteRetryDelayMs = 0L;
    private final float successRate = 0.0F;
    private final long averageLatencyMs = 0L;
    private final int busySignals = 0;
    private final int disconnectSignals = 0;
    private final int sampleSize = 0;
    private final long lastUpdatedMs = 0L;
    
    public CommandPipelineAutotuneStatus(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.CommandPipelineProfile profile, int cliRetryAttempts, long cliRetryDelayMs, int rpcRetryAttempts, long rpcRetryDelayMs, int fileWriteRetryAttempts, long fileWriteRetryDelayMs, float successRate, long averageLatencyMs, int busySignals, int disconnectSignals, int sampleSize, long lastUpdatedMs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ble.CommandPipelineProfile getProfile() {
        return null;
    }
    
    public final int getCliRetryAttempts() {
        return 0;
    }
    
    public final long getCliRetryDelayMs() {
        return 0L;
    }
    
    public final int getRpcRetryAttempts() {
        return 0;
    }
    
    public final long getRpcRetryDelayMs() {
        return 0L;
    }
    
    public final int getFileWriteRetryAttempts() {
        return 0;
    }
    
    public final long getFileWriteRetryDelayMs() {
        return 0L;
    }
    
    public final float getSuccessRate() {
        return 0.0F;
    }
    
    public final long getAverageLatencyMs() {
        return 0L;
    }
    
    public final int getBusySignals() {
        return 0;
    }
    
    public final int getDisconnectSignals() {
        return 0;
    }
    
    public final int getSampleSize() {
        return 0;
    }
    
    public final long getLastUpdatedMs() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProfileLabel() {
        return null;
    }
    
    public CommandPipelineAutotuneStatus() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ble.CommandPipelineProfile component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final float component8() {
        return 0.0F;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ble.CommandPipelineAutotuneStatus copy(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.CommandPipelineProfile profile, int cliRetryAttempts, long cliRetryDelayMs, int rpcRetryAttempts, long rpcRetryDelayMs, int fileWriteRetryAttempts, long fileWriteRetryDelayMs, float successRate, long averageLatencyMs, int busySignals, int disconnectSignals, int sampleSize, long lastUpdatedMs) {
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