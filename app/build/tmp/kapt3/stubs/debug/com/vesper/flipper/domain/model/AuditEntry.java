package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import java.util.UUID;

/**
 * Audit log entry for tracking all agent actions.
 * Everything is logged for accountability and replay.
 */
@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNB\u0091\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010\u0019B{\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016\u00a2\u0006\u0002\u0010\u001aJ\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\u0015\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016H\u00c6\u0003J\t\u00107\u001a\u00020\u0007H\u00c6\u0003J\t\u00108\u001a\u00020\tH\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u00103J\u000b\u0010=\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\u0088\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016H\u00c6\u0001\u00a2\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010C\u001a\u00020\u0003H\u00d6\u0001J\t\u0010D\u001a\u00020\u0005H\u00d6\u0001J&\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u00c1\u0001\u00a2\u0006\u0002\bLR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010,R\u001c\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0010\n\u0002\u00104\u0012\u0004\b1\u0010\u001c\u001a\u0004\b2\u00103\u00a8\u0006O"}, d2 = {"Lcom/vesper/flipper/domain/model/AuditEntry;", "", "seen1", "", "id", "", "timestamp", "", "actionType", "Lcom/vesper/flipper/domain/model/AuditActionType;", "command", "Lcom/vesper/flipper/domain/model/ExecuteCommand;", "result", "Lcom/vesper/flipper/domain/model/CommandResult;", "riskLevel", "Lcom/vesper/flipper/domain/model/RiskLevel;", "userApproved", "", "approvalMethod", "Lcom/vesper/flipper/domain/model/ApprovalMethod;", "sessionId", "metadata", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLcom/vesper/flipper/domain/model/AuditActionType;Lcom/vesper/flipper/domain/model/ExecuteCommand;Lcom/vesper/flipper/domain/model/CommandResult;Lcom/vesper/flipper/domain/model/RiskLevel;Ljava/lang/Boolean;Lcom/vesper/flipper/domain/model/ApprovalMethod;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;JLcom/vesper/flipper/domain/model/AuditActionType;Lcom/vesper/flipper/domain/model/ExecuteCommand;Lcom/vesper/flipper/domain/model/CommandResult;Lcom/vesper/flipper/domain/model/RiskLevel;Ljava/lang/Boolean;Lcom/vesper/flipper/domain/model/ApprovalMethod;Ljava/lang/String;Ljava/util/Map;)V", "getActionType$annotations", "()V", "getActionType", "()Lcom/vesper/flipper/domain/model/AuditActionType;", "getApprovalMethod$annotations", "getApprovalMethod", "()Lcom/vesper/flipper/domain/model/ApprovalMethod;", "getCommand", "()Lcom/vesper/flipper/domain/model/ExecuteCommand;", "getId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "getResult", "()Lcom/vesper/flipper/domain/model/CommandResult;", "getRiskLevel$annotations", "getRiskLevel", "()Lcom/vesper/flipper/domain/model/RiskLevel;", "getSessionId$annotations", "getSessionId", "getTimestamp", "()J", "getUserApproved$annotations", "getUserApproved", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLcom/vesper/flipper/domain/model/AuditActionType;Lcom/vesper/flipper/domain/model/ExecuteCommand;Lcom/vesper/flipper/domain/model/CommandResult;Lcom/vesper/flipper/domain/model/RiskLevel;Ljava/lang/Boolean;Lcom/vesper/flipper/domain/model/ApprovalMethod;Ljava/lang/String;Ljava/util/Map;)Lcom/vesper/flipper/domain/model/AuditEntry;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
public final class AuditEntry {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.AuditActionType actionType = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.ExecuteCommand command = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.CommandResult result = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.RiskLevel riskLevel = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Boolean userApproved = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.ApprovalMethod approvalMethod = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String sessionId = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, java.lang.String> metadata = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.AuditEntry.Companion Companion = null;
    
    public AuditEntry(@org.jetbrains.annotations.NotNull
    java.lang.String id, long timestamp, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AuditActionType actionType, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ExecuteCommand command, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.CommandResult result, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.RiskLevel riskLevel, @org.jetbrains.annotations.Nullable
    java.lang.Boolean userApproved, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ApprovalMethod approvalMethod, @org.jetbrains.annotations.NotNull
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.String> metadata) {
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
    public final com.vesper.flipper.domain.model.AuditActionType getActionType() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "action_type")
    @java.lang.Deprecated
    public static void getActionType$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ExecuteCommand getCommand() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.CommandResult getResult() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.RiskLevel getRiskLevel() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "risk_level")
    @java.lang.Deprecated
    public static void getRiskLevel$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getUserApproved() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "user_approved")
    @java.lang.Deprecated
    public static void getUserApproved$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ApprovalMethod getApprovalMethod() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "approval_method")
    @java.lang.Deprecated
    public static void getApprovalMethod$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSessionId() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "session_id")
    @java.lang.Deprecated
    public static void getSessionId$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.String> getMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.String> component10() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.AuditActionType component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ExecuteCommand component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.CommandResult component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.RiskLevel component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ApprovalMethod component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.AuditEntry copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, long timestamp, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AuditActionType actionType, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ExecuteCommand command, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.CommandResult result, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.RiskLevel riskLevel, @org.jetbrains.annotations.Nullable
    java.lang.Boolean userApproved, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ApprovalMethod approvalMethod, @org.jetbrains.annotations.NotNull
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.String> metadata) {
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
    
    @kotlin.jvm.JvmStatic
    public static final void write$Self$app_debug(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AuditEntry self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    /**
     * Audit log entry for tracking all agent actions.
     * Everything is logged for accountability and replay.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/vesper/flipper/domain/model/AuditEntry.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vesper/flipper/domain/model/AuditEntry;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.vesper.flipper.domain.model.AuditEntry> {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.domain.model.AuditEntry.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.vesper.flipper.domain.model.AuditEntry deserialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override
        public void serialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.model.AuditEntry value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    /**
     * Audit log entry for tracking all agent actions.
     * Everything is logged for accountability and replay.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/domain/model/AuditEntry$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vesper/flipper/domain/model/AuditEntry;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.AuditEntry> serializer() {
            return null;
        }
    }
}