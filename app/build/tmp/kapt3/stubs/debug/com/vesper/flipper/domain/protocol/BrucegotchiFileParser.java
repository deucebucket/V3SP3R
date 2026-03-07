package com.vesper.flipper.domain.protocol;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/**
 * Flipper Zero Brucegotchi file format parser
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/domain/protocol/BrucegotchiFileParser;", "", "()V", "parseHandshakeInfo", "Lcom/vesper/flipper/domain/protocol/HandshakeInfo;", "filename", "", "parseSessionStats", "Lcom/vesper/flipper/domain/protocol/SessionStats;", "content", "app_debug"})
public final class BrucegotchiFileParser {
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.protocol.BrucegotchiFileParser INSTANCE = null;
    
    private BrucegotchiFileParser() {
        super();
    }
    
    /**
     * Parse a .pcap handshake file and extract info
     */
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.protocol.HandshakeInfo parseHandshakeInfo(@org.jetbrains.annotations.NotNull
    java.lang.String filename) {
        return null;
    }
    
    /**
     * Parse session stats from log file
     */
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.SessionStats parseSessionStats(@org.jetbrains.annotations.NotNull
    java.lang.String content) {
        return null;
    }
}