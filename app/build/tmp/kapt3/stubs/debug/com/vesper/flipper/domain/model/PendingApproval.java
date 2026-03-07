package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import java.util.UUID;

/**
 * Pending action waiting for user approval
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\fH\u00c6\u0003J\t\u0010!\u001a\u00020\fH\u00c6\u0003JS\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u00c6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\'H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016\u00a8\u0006)"}, d2 = {"Lcom/vesper/flipper/domain/model/PendingApproval;", "", "id", "", "command", "Lcom/vesper/flipper/domain/model/ExecuteCommand;", "riskAssessment", "Lcom/vesper/flipper/domain/model/RiskAssessment;", "diff", "Lcom/vesper/flipper/domain/model/FileDiff;", "traceId", "timestamp", "", "expiresAt", "(Ljava/lang/String;Lcom/vesper/flipper/domain/model/ExecuteCommand;Lcom/vesper/flipper/domain/model/RiskAssessment;Lcom/vesper/flipper/domain/model/FileDiff;Ljava/lang/String;JJ)V", "getCommand", "()Lcom/vesper/flipper/domain/model/ExecuteCommand;", "getDiff", "()Lcom/vesper/flipper/domain/model/FileDiff;", "getExpiresAt", "()J", "getId", "()Ljava/lang/String;", "getRiskAssessment", "()Lcom/vesper/flipper/domain/model/RiskAssessment;", "getTimestamp", "getTraceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class PendingApproval {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.ExecuteCommand command = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.RiskAssessment riskAssessment = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.FileDiff diff = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String traceId = null;
    private final long timestamp = 0L;
    private final long expiresAt = 0L;
    
    public PendingApproval(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ExecuteCommand command, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.RiskAssessment riskAssessment, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.FileDiff diff, @org.jetbrains.annotations.Nullable
    java.lang.String traceId, long timestamp, long expiresAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ExecuteCommand getCommand() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.RiskAssessment getRiskAssessment() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.FileDiff getDiff() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTraceId() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    public final long getExpiresAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ExecuteCommand component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.RiskAssessment component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.FileDiff component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final long component7() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.PendingApproval copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ExecuteCommand command, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.RiskAssessment riskAssessment, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.FileDiff diff, @org.jetbrains.annotations.Nullable
    java.lang.String traceId, long timestamp, long expiresAt) {
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