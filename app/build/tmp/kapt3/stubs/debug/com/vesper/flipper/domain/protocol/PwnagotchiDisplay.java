package com.vesper.flipper.domain.protocol;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/**
 * Display data for Pwnagotchi-style UI
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\\\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0001\u00a2\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\u000bH\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006+"}, d2 = {"Lcom/vesper/flipper/domain/protocol/PwnagotchiDisplay;", "", "name", "", "face", "mood", "Lcom/vesper/flipper/domain/protocol/PwnagotchiMood;", "message", "stats", "Lcom/vesper/flipper/domain/protocol/PwnagotchiStats;", "channel", "", "peers", "", "Lcom/vesper/flipper/domain/protocol/PwnagotchiPeer;", "(Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/domain/protocol/PwnagotchiMood;Ljava/lang/String;Lcom/vesper/flipper/domain/protocol/PwnagotchiStats;Ljava/lang/Integer;Ljava/util/List;)V", "getChannel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFace", "()Ljava/lang/String;", "getMessage", "getMood", "()Lcom/vesper/flipper/domain/protocol/PwnagotchiMood;", "getName", "getPeers", "()Ljava/util/List;", "getStats", "()Lcom/vesper/flipper/domain/protocol/PwnagotchiStats;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/domain/protocol/PwnagotchiMood;Ljava/lang/String;Lcom/vesper/flipper/domain/protocol/PwnagotchiStats;Ljava/lang/Integer;Ljava/util/List;)Lcom/vesper/flipper/domain/protocol/PwnagotchiDisplay;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class PwnagotchiDisplay {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String face = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.protocol.PwnagotchiMood mood = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String message = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.protocol.PwnagotchiStats stats = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer channel = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.domain.protocol.PwnagotchiPeer> peers = null;
    
    public PwnagotchiDisplay(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String face, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.protocol.PwnagotchiMood mood, @org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.protocol.PwnagotchiStats stats, @org.jetbrains.annotations.Nullable
    java.lang.Integer channel, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.protocol.PwnagotchiPeer> peers) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFace() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.PwnagotchiMood getMood() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.PwnagotchiStats getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.protocol.PwnagotchiPeer> getPeers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.PwnagotchiMood component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.PwnagotchiStats component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.protocol.PwnagotchiPeer> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.PwnagotchiDisplay copy(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String face, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.protocol.PwnagotchiMood mood, @org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.protocol.PwnagotchiStats stats, @org.jetbrains.annotations.Nullable
    java.lang.Integer channel, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.protocol.PwnagotchiPeer> peers) {
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