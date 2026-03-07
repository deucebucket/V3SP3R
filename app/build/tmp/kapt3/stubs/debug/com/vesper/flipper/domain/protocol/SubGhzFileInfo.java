package com.vesper.flipper.domain.protocol;

import kotlinx.serialization.Serializable;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fH\u00c6\u0003Jb\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006)"}, d2 = {"Lcom/vesper/flipper/domain/protocol/SubGhzFileInfo;", "", "filetype", "", "version", "", "frequency", "", "preset", "protocol", "rawData", "parsedSignal", "Lcom/vesper/flipper/domain/protocol/ParsedSignal;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/domain/protocol/ParsedSignal;)V", "getFiletype", "()Ljava/lang/String;", "getFrequency", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getParsedSignal", "()Lcom/vesper/flipper/domain/protocol/ParsedSignal;", "getPreset", "getProtocol", "getRawData", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/domain/protocol/ParsedSignal;)Lcom/vesper/flipper/domain/protocol/SubGhzFileInfo;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class SubGhzFileInfo {
    @org.jetbrains.annotations.Nullable
    private final java.lang.String filetype = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer version = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long frequency = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String preset = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String protocol = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String rawData = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.protocol.ParsedSignal parsedSignal = null;
    
    public SubGhzFileInfo(@org.jetbrains.annotations.Nullable
    java.lang.String filetype, @org.jetbrains.annotations.Nullable
    java.lang.Integer version, @org.jetbrains.annotations.Nullable
    java.lang.Long frequency, @org.jetbrains.annotations.Nullable
    java.lang.String preset, @org.jetbrains.annotations.Nullable
    java.lang.String protocol, @org.jetbrains.annotations.Nullable
    java.lang.String rawData, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.protocol.ParsedSignal parsedSignal) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFiletype() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getVersion() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getFrequency() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPreset() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getProtocol() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRawData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.protocol.ParsedSignal getParsedSignal() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.protocol.ParsedSignal component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.protocol.SubGhzFileInfo copy(@org.jetbrains.annotations.Nullable
    java.lang.String filetype, @org.jetbrains.annotations.Nullable
    java.lang.Integer version, @org.jetbrains.annotations.Nullable
    java.lang.Long frequency, @org.jetbrains.annotations.Nullable
    java.lang.String preset, @org.jetbrains.annotations.Nullable
    java.lang.String protocol, @org.jetbrains.annotations.Nullable
    java.lang.String rawData, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.protocol.ParsedSignal parsedSignal) {
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