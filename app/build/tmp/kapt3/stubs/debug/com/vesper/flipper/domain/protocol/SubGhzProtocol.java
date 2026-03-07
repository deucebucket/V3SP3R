package com.vesper.flipper.domain.protocol;

import kotlinx.serialization.Serializable;

/**
 * Sub-GHz Protocol Parsers
 *
 * Parses and analyzes various Sub-GHz RF protocols:
 * - Garage door remotes (Chamberlain, LiftMaster, Linear)
 * - Car key fobs (rolling codes, static codes)
 * - TPMS sensors (tire pressure monitoring)
 * - Weather stations
 * - Doorbells
 * - Security sensors
 * - Generic OOK/FSK signals
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0003H&R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0007\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/vesper/flipper/domain/protocol/SubGhzProtocol;", "", "name", "", "frequency", "", "modulation", "Lcom/vesper/flipper/domain/protocol/Modulation;", "(Ljava/lang/String;JLcom/vesper/flipper/domain/protocol/Modulation;)V", "getFrequency", "()J", "getModulation", "()Lcom/vesper/flipper/domain/protocol/Modulation;", "getName", "()Ljava/lang/String;", "analyze", "Lcom/vesper/flipper/domain/protocol/SignalAnalysis;", "signal", "Lcom/vesper/flipper/domain/protocol/ParsedSignal;", "parse", "rawData", "Lcom/vesper/flipper/domain/protocol/CameProtocol;", "Lcom/vesper/flipper/domain/protocol/HoneywellProtocol;", "Lcom/vesper/flipper/domain/protocol/KeeLoqProtocol;", "Lcom/vesper/flipper/domain/protocol/NiceFloProtocol;", "Lcom/vesper/flipper/domain/protocol/PrincetonProtocol;", "Lcom/vesper/flipper/domain/protocol/TpmsProtocol;", "Lcom/vesper/flipper/domain/protocol/WeatherStationProtocol;", "app_debug"})
public abstract class SubGhzProtocol {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    private final long frequency = 0L;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.protocol.Modulation modulation = null;
    
    private SubGhzProtocol(java.lang.String name, long frequency, com.vesper.flipper.domain.protocol.Modulation modulation) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final long getFrequency() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.Modulation getModulation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public abstract com.vesper.flipper.domain.protocol.ParsedSignal parse(@org.jetbrains.annotations.NotNull
    java.lang.String rawData);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.vesper.flipper.domain.protocol.SignalAnalysis analyze(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.protocol.ParsedSignal signal);
}