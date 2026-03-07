package com.vesper.flipper.domain.model;

import kotlinx.serialization.Serializable;

/**
 * Raw captured signal data for analysis
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rH\u00c6\u0003Jl\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rH\u00c6\u0001\u00a2\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u0006H\u00d6\u0001J\t\u0010)\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006*"}, d2 = {"Lcom/vesper/flipper/domain/model/CapturedSignalData;", "", "frequency", "", "rawTimings", "", "", "modulationType", "", "captureTimestamp", "signalStrength", "sampleRate", "metadata", "", "(JLjava/util/List;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)V", "getCaptureTimestamp", "()J", "getFrequency", "getMetadata", "()Ljava/util/Map;", "getModulationType", "()Ljava/lang/String;", "getRawTimings", "()Ljava/util/List;", "getSampleRate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSignalStrength", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/util/List;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)Lcom/vesper/flipper/domain/model/CapturedSignalData;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class CapturedSignalData {
    private final long frequency = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Integer> rawTimings = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String modulationType = null;
    private final long captureTimestamp = 0L;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer signalStrength = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer sampleRate = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, java.lang.String> metadata = null;
    
    public CapturedSignalData(long frequency, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> rawTimings, @org.jetbrains.annotations.Nullable
    java.lang.String modulationType, long captureTimestamp, @org.jetbrains.annotations.Nullable
    java.lang.Integer signalStrength, @org.jetbrains.annotations.Nullable
    java.lang.Integer sampleRate, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.String> metadata) {
        super();
    }
    
    public final long getFrequency() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> getRawTimings() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getModulationType() {
        return null;
    }
    
    public final long getCaptureTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getSignalStrength() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getSampleRate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.String> getMetadata() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.CapturedSignalData copy(long frequency, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> rawTimings, @org.jetbrains.annotations.Nullable
    java.lang.String modulationType, long captureTimestamp, @org.jetbrains.annotations.Nullable
    java.lang.Integer signalStrength, @org.jetbrains.annotations.Nullable
    java.lang.Integer sampleRate, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.String> metadata) {
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