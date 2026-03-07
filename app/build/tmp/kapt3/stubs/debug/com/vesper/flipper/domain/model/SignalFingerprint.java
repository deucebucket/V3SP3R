package com.vesper.flipper.domain.model;

import kotlinx.serialization.Serializable;

/**
 * Unique fingerprint of the signal
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u000bH\u00c6\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006%"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalFingerprint;", "", "hash", "", "frequency", "", "bandwidth", "modulationDetected", "bitRate", "signaturePattern", "confidence", "", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V", "getBandwidth", "()Ljava/lang/String;", "getBitRate", "getConfidence", "()F", "getFrequency", "()J", "getHash", "getModulationDetected", "getSignaturePattern", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class SignalFingerprint {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String hash = null;
    private final long frequency = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String bandwidth = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String modulationDetected = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String bitRate = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String signaturePattern = null;
    private final float confidence = 0.0F;
    
    public SignalFingerprint(@org.jetbrains.annotations.NotNull
    java.lang.String hash, long frequency, @org.jetbrains.annotations.NotNull
    java.lang.String bandwidth, @org.jetbrains.annotations.NotNull
    java.lang.String modulationDetected, @org.jetbrains.annotations.Nullable
    java.lang.String bitRate, @org.jetbrains.annotations.NotNull
    java.lang.String signaturePattern, float confidence) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHash() {
        return null;
    }
    
    public final long getFrequency() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBandwidth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getModulationDetected() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBitRate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSignaturePattern() {
        return null;
    }
    
    public final float getConfidence() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    public final float component7() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.SignalFingerprint copy(@org.jetbrains.annotations.NotNull
    java.lang.String hash, long frequency, @org.jetbrains.annotations.NotNull
    java.lang.String bandwidth, @org.jetbrains.annotations.NotNull
    java.lang.String modulationDetected, @org.jetbrains.annotations.Nullable
    java.lang.String bitRate, @org.jetbrains.annotations.NotNull
    java.lang.String signaturePattern, float confidence) {
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