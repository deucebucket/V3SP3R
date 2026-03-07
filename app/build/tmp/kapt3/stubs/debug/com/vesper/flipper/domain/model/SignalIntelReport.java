package com.vesper.flipper.domain.model;

import kotlinx.serialization.Serializable;

/**
 * AI-generated signal intelligence report
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0016J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\t\u00100\u001a\u00020\u0012H\u00c6\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bH\u00c6\u0003J\u0083\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u000207H\u00d6\u0001J\t\u00108\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0018\u00a8\u00069"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalIntelReport;", "", "id", "", "timestamp", "", "signalFingerprint", "Lcom/vesper/flipper/domain/model/SignalFingerprint;", "protocolAnalysis", "Lcom/vesper/flipper/domain/model/ProtocolAnalysis;", "vulnerabilities", "", "Lcom/vesper/flipper/domain/model/Vulnerability;", "exploits", "Lcom/vesper/flipper/domain/model/ExploitVector;", "manufacturer", "Lcom/vesper/flipper/domain/model/ManufacturerInfo;", "threatAssessment", "Lcom/vesper/flipper/domain/model/ThreatAssessment;", "recommendations", "Lcom/vesper/flipper/domain/model/Recommendation;", "rawAiResponse", "(Ljava/lang/String;JLcom/vesper/flipper/domain/model/SignalFingerprint;Lcom/vesper/flipper/domain/model/ProtocolAnalysis;Ljava/util/List;Ljava/util/List;Lcom/vesper/flipper/domain/model/ManufacturerInfo;Lcom/vesper/flipper/domain/model/ThreatAssessment;Ljava/util/List;Ljava/lang/String;)V", "getExploits", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getManufacturer", "()Lcom/vesper/flipper/domain/model/ManufacturerInfo;", "getProtocolAnalysis", "()Lcom/vesper/flipper/domain/model/ProtocolAnalysis;", "getRawAiResponse", "getRecommendations", "getSignalFingerprint", "()Lcom/vesper/flipper/domain/model/SignalFingerprint;", "getThreatAssessment", "()Lcom/vesper/flipper/domain/model/ThreatAssessment;", "getTimestamp", "()J", "getVulnerabilities", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class SignalIntelReport {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.SignalFingerprint signalFingerprint = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.ProtocolAnalysis protocolAnalysis = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.domain.model.Vulnerability> vulnerabilities = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.domain.model.ExploitVector> exploits = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.ManufacturerInfo manufacturer = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.ThreatAssessment threatAssessment = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.domain.model.Recommendation> recommendations = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String rawAiResponse = null;
    
    public SignalIntelReport(@org.jetbrains.annotations.NotNull
    java.lang.String id, long timestamp, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.SignalFingerprint signalFingerprint, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ProtocolAnalysis protocolAnalysis, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.Vulnerability> vulnerabilities, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.ExploitVector> exploits, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ManufacturerInfo manufacturer, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ThreatAssessment threatAssessment, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.Recommendation> recommendations, @org.jetbrains.annotations.NotNull
    java.lang.String rawAiResponse) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.SignalFingerprint getSignalFingerprint() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ProtocolAnalysis getProtocolAnalysis() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.Vulnerability> getVulnerabilities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.ExploitVector> getExploits() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ManufacturerInfo getManufacturer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ThreatAssessment getThreatAssessment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.Recommendation> getRecommendations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRawAiResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.SignalFingerprint component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ProtocolAnalysis component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.Vulnerability> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.ExploitVector> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ManufacturerInfo component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ThreatAssessment component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.Recommendation> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.SignalIntelReport copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, long timestamp, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.SignalFingerprint signalFingerprint, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ProtocolAnalysis protocolAnalysis, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.Vulnerability> vulnerabilities, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.ExploitVector> exploits, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ManufacturerInfo manufacturer, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ThreatAssessment threatAssessment, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.Recommendation> recommendations, @org.jetbrains.annotations.NotNull
    java.lang.String rawAiResponse) {
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