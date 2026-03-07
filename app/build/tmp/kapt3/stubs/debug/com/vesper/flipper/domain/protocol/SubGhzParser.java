package com.vesper.flipper.domain.protocol;

import kotlinx.serialization.Serializable;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004J\u0010\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/vesper/flipper/domain/protocol/SubGhzParser;", "", "()V", "protocols", "", "Lcom/vesper/flipper/domain/protocol/SubGhzProtocol;", "analyze", "Lcom/vesper/flipper/domain/protocol/SignalAnalysis;", "signal", "Lcom/vesper/flipper/domain/protocol/ParsedSignal;", "getAllProtocols", "Lcom/vesper/flipper/domain/protocol/ProtocolInfo;", "parse", "fileContent", "", "parseSubFile", "Lcom/vesper/flipper/domain/protocol/SubGhzFileInfo;", "content", "app_debug"})
public final class SubGhzParser {
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<com.vesper.flipper.domain.protocol.SubGhzProtocol> protocols = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.protocol.SubGhzParser INSTANCE = null;
    
    private SubGhzParser() {
        super();
    }
    
    /**
     * Auto-detect and parse a Sub-GHz signal
     */
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.protocol.ParsedSignal parse(@org.jetbrains.annotations.NotNull
    java.lang.String fileContent) {
        return null;
    }
    
    /**
     * Analyze a parsed signal
     */
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.SignalAnalysis analyze(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.protocol.ParsedSignal signal) {
        return null;
    }
    
    /**
     * Parse a raw .sub file
     */
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.SubGhzFileInfo parseSubFile(@org.jetbrains.annotations.NotNull
    java.lang.String content) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.protocol.ProtocolInfo> getAllProtocols() {
        return null;
    }
}