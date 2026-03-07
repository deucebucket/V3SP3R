package com.vesper.flipper.domain.model;

import kotlinx.serialization.Serializable;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003JU\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006\""}, d2 = {"Lcom/vesper/flipper/domain/model/PacketStructure;", "", "preambleLength", "", "syncWord", "", "payloadLength", "checksumType", "totalBits", "fieldMap", "", "Lcom/vesper/flipper/domain/model/FieldInfo;", "(ILjava/lang/String;ILjava/lang/String;ILjava/util/Map;)V", "getChecksumType", "()Ljava/lang/String;", "getFieldMap", "()Ljava/util/Map;", "getPayloadLength", "()I", "getPreambleLength", "getSyncWord", "getTotalBits", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class PacketStructure {
    private final int preambleLength = 0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String syncWord = null;
    private final int payloadLength = 0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String checksumType = null;
    private final int totalBits = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, com.vesper.flipper.domain.model.FieldInfo> fieldMap = null;
    
    public PacketStructure(int preambleLength, @org.jetbrains.annotations.Nullable
    java.lang.String syncWord, int payloadLength, @org.jetbrains.annotations.Nullable
    java.lang.String checksumType, int totalBits, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, com.vesper.flipper.domain.model.FieldInfo> fieldMap) {
        super();
    }
    
    public final int getPreambleLength() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSyncWord() {
        return null;
    }
    
    public final int getPayloadLength() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getChecksumType() {
        return null;
    }
    
    public final int getTotalBits() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, com.vesper.flipper.domain.model.FieldInfo> getFieldMap() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, com.vesper.flipper.domain.model.FieldInfo> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.PacketStructure copy(int preambleLength, @org.jetbrains.annotations.Nullable
    java.lang.String syncWord, int payloadLength, @org.jetbrains.annotations.Nullable
    java.lang.String checksumType, int totalBits, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, com.vesper.flipper.domain.model.FieldInfo> fieldMap) {
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