package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import java.util.UUID;

/**
 * Summary statistics for audit display
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b0\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\u001b\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b0\nH\u00c6\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000eH\u00c6\u0003J\t\u0010\'\u001a\u00020\u0011H\u00c6\u0003Jw\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b0\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020.H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016\u00a8\u0006/"}, d2 = {"Lcom/vesper/flipper/domain/model/AuditSummary;", "", "totalCommands", "", "successfulCommands", "failedCommands", "blockedCommands", "approvalRate", "", "mostCommonActions", "", "Lkotlin/Pair;", "Lcom/vesper/flipper/domain/model/CommandAction;", "riskBreakdown", "", "Lcom/vesper/flipper/domain/model/RiskLevel;", "sessionDuration", "", "(IIIIFLjava/util/List;Ljava/util/Map;J)V", "getApprovalRate", "()F", "getBlockedCommands", "()I", "getFailedCommands", "getMostCommonActions", "()Ljava/util/List;", "getRiskBreakdown", "()Ljava/util/Map;", "getSessionDuration", "()J", "getSuccessfulCommands", "getTotalCommands", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class AuditSummary {
    private final int totalCommands = 0;
    private final int successfulCommands = 0;
    private final int failedCommands = 0;
    private final int blockedCommands = 0;
    private final float approvalRate = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<kotlin.Pair<com.vesper.flipper.domain.model.CommandAction, java.lang.Integer>> mostCommonActions = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<com.vesper.flipper.domain.model.RiskLevel, java.lang.Integer> riskBreakdown = null;
    private final long sessionDuration = 0L;
    
    public AuditSummary(int totalCommands, int successfulCommands, int failedCommands, int blockedCommands, float approvalRate, @org.jetbrains.annotations.NotNull
    java.util.List<? extends kotlin.Pair<? extends com.vesper.flipper.domain.model.CommandAction, java.lang.Integer>> mostCommonActions, @org.jetbrains.annotations.NotNull
    java.util.Map<com.vesper.flipper.domain.model.RiskLevel, java.lang.Integer> riskBreakdown, long sessionDuration) {
        super();
    }
    
    public final int getTotalCommands() {
        return 0;
    }
    
    public final int getSuccessfulCommands() {
        return 0;
    }
    
    public final int getFailedCommands() {
        return 0;
    }
    
    public final int getBlockedCommands() {
        return 0;
    }
    
    public final float getApprovalRate() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlin.Pair<com.vesper.flipper.domain.model.CommandAction, java.lang.Integer>> getMostCommonActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<com.vesper.flipper.domain.model.RiskLevel, java.lang.Integer> getRiskBreakdown() {
        return null;
    }
    
    public final long getSessionDuration() {
        return 0L;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlin.Pair<com.vesper.flipper.domain.model.CommandAction, java.lang.Integer>> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<com.vesper.flipper.domain.model.RiskLevel, java.lang.Integer> component7() {
        return null;
    }
    
    public final long component8() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.AuditSummary copy(int totalCommands, int successfulCommands, int failedCommands, int blockedCommands, float approvalRate, @org.jetbrains.annotations.NotNull
    java.util.List<? extends kotlin.Pair<? extends com.vesper.flipper.domain.model.CommandAction, java.lang.Integer>> mostCommonActions, @org.jetbrains.annotations.NotNull
    java.util.Map<com.vesper.flipper.domain.model.RiskLevel, java.lang.Integer> riskBreakdown, long sessionDuration) {
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