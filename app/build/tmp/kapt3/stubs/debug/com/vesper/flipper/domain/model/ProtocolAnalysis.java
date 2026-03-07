package com.vesper.flipper.domain.model;

import kotlinx.serialization.Serializable;

/**
 * Protocol analysis results
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0010H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\t\u0010&\u001a\u00020\fH\u00c6\u0003J\t\u0010\'\u001a\u00020\fH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Jy\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015\u00a8\u0006/"}, d2 = {"Lcom/vesper/flipper/domain/model/ProtocolAnalysis;", "", "protocolName", "", "protocolFamily", "version", "encoding", "packetStructure", "Lcom/vesper/flipper/domain/model/PacketStructure;", "knownImplementations", "", "isRollingCode", "", "isEncrypted", "encryptionType", "confidence", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/domain/model/PacketStructure;Ljava/util/List;ZZLjava/lang/String;F)V", "getConfidence", "()F", "getEncoding", "()Ljava/lang/String;", "getEncryptionType", "()Z", "getKnownImplementations", "()Ljava/util/List;", "getPacketStructure", "()Lcom/vesper/flipper/domain/model/PacketStructure;", "getProtocolFamily", "getProtocolName", "getVersion", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class ProtocolAnalysis {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String protocolName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String protocolFamily = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String version = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String encoding = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.PacketStructure packetStructure = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> knownImplementations = null;
    private final boolean isRollingCode = false;
    private final boolean isEncrypted = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String encryptionType = null;
    private final float confidence = 0.0F;
    
    public ProtocolAnalysis(@org.jetbrains.annotations.NotNull
    java.lang.String protocolName, @org.jetbrains.annotations.NotNull
    java.lang.String protocolFamily, @org.jetbrains.annotations.Nullable
    java.lang.String version, @org.jetbrains.annotations.NotNull
    java.lang.String encoding, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.PacketStructure packetStructure, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> knownImplementations, boolean isRollingCode, boolean isEncrypted, @org.jetbrains.annotations.Nullable
    java.lang.String encryptionType, float confidence) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProtocolName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProtocolFamily() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getVersion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEncoding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.PacketStructure getPacketStructure() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getKnownImplementations() {
        return null;
    }
    
    public final boolean isRollingCode() {
        return false;
    }
    
    public final boolean isEncrypted() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEncryptionType() {
        return null;
    }
    
    public final float getConfidence() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final float component10() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.PacketStructure component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ProtocolAnalysis copy(@org.jetbrains.annotations.NotNull
    java.lang.String protocolName, @org.jetbrains.annotations.NotNull
    java.lang.String protocolFamily, @org.jetbrains.annotations.Nullable
    java.lang.String version, @org.jetbrains.annotations.NotNull
    java.lang.String encoding, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.PacketStructure packetStructure, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> knownImplementations, boolean isRollingCode, boolean isEncrypted, @org.jetbrains.annotations.Nullable
    java.lang.String encryptionType, float confidence) {
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