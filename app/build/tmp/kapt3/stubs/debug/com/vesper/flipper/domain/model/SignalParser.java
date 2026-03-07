package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/**
 * Parser for Flipper signal files
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J \u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002J \u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J \u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n\u00a8\u0006\u0019"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalParser;", "", "()V", "parseIButton", "Lcom/vesper/flipper/domain/model/SignalCapture$IButton;", "content", "", "path", "name", "parseInfrared", "", "Lcom/vesper/flipper/domain/model/SignalCapture$Infrared;", "parseNfc", "Lcom/vesper/flipper/domain/model/SignalCapture$Nfc;", "parseProperties", "", "lines", "parseRfid", "Lcom/vesper/flipper/domain/model/SignalCapture$Rfid;", "parseSubGhz", "Lcom/vesper/flipper/domain/model/SignalCapture$SubGhz;", "rawToWaveform", "Lcom/vesper/flipper/domain/model/WaveformData;", "rawData", "", "app_debug"})
public final class SignalParser {
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.SignalParser INSTANCE = null;
    
    private SignalParser() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.SignalCapture.SubGhz parseSubGhz(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.SignalCapture.Infrared> parseInfrared(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.SignalCapture.Nfc parseNfc(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.SignalCapture.Rfid parseRfid(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.SignalCapture.IButton parseIButton(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.String> parseProperties(java.util.List<java.lang.String> lines) {
        return null;
    }
    
    /**
     * Convert raw timing data to waveform samples
     */
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.WaveformData rawToWaveform(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> rawData) {
        return null;
    }
}