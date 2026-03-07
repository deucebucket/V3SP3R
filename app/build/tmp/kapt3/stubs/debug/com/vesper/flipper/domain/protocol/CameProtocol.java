package com.vesper.flipper.domain.protocol;

import kotlinx.serialization.Serializable;

/**
 * Came protocol - European gate/garage remotes
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/domain/protocol/CameProtocol;", "Lcom/vesper/flipper/domain/protocol/SubGhzProtocol;", "()V", "analyze", "Lcom/vesper/flipper/domain/protocol/SignalAnalysis;", "signal", "Lcom/vesper/flipper/domain/protocol/ParsedSignal;", "parse", "rawData", "", "app_debug"})
public final class CameProtocol extends com.vesper.flipper.domain.protocol.SubGhzProtocol {
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.protocol.CameProtocol INSTANCE = null;
    
    private CameProtocol() {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public com.vesper.flipper.domain.protocol.ParsedSignal parse(@org.jetbrains.annotations.NotNull
    java.lang.String rawData) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.vesper.flipper.domain.protocol.SignalAnalysis analyze(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.protocol.ParsedSignal signal) {
        return null;
    }
}