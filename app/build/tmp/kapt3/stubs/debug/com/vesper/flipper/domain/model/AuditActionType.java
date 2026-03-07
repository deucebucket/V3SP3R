package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import java.util.UUID;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0087\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/vesper/flipper/domain/model/AuditActionType;", "", "(Ljava/lang/String;I)V", "COMMAND_RECEIVED", "COMMAND_EXECUTED", "COMMAND_FAILED", "COMMAND_BLOCKED", "APPROVAL_REQUESTED", "APPROVAL_GRANTED", "APPROVAL_DENIED", "APPROVAL_TIMEOUT", "PERMISSION_GRANTED", "PERMISSION_REVOKED", "PERMISSION_EXPIRED", "DEVICE_CONNECTED", "DEVICE_DISCONNECTED", "SESSION_STARTED", "SESSION_ENDED", "AI_REQUEST", "AI_RESPONSE", "ERROR", "Companion", "app_debug"})
public enum AuditActionType {
    @kotlinx.serialization.SerialName(value = "command_received")
    /*public static final*/ COMMAND_RECEIVED /* = new COMMAND_RECEIVED() */,
    @kotlinx.serialization.SerialName(value = "command_executed")
    /*public static final*/ COMMAND_EXECUTED /* = new COMMAND_EXECUTED() */,
    @kotlinx.serialization.SerialName(value = "command_failed")
    /*public static final*/ COMMAND_FAILED /* = new COMMAND_FAILED() */,
    @kotlinx.serialization.SerialName(value = "command_blocked")
    /*public static final*/ COMMAND_BLOCKED /* = new COMMAND_BLOCKED() */,
    @kotlinx.serialization.SerialName(value = "approval_requested")
    /*public static final*/ APPROVAL_REQUESTED /* = new APPROVAL_REQUESTED() */,
    @kotlinx.serialization.SerialName(value = "approval_granted")
    /*public static final*/ APPROVAL_GRANTED /* = new APPROVAL_GRANTED() */,
    @kotlinx.serialization.SerialName(value = "approval_denied")
    /*public static final*/ APPROVAL_DENIED /* = new APPROVAL_DENIED() */,
    @kotlinx.serialization.SerialName(value = "approval_timeout")
    /*public static final*/ APPROVAL_TIMEOUT /* = new APPROVAL_TIMEOUT() */,
    @kotlinx.serialization.SerialName(value = "permission_granted")
    /*public static final*/ PERMISSION_GRANTED /* = new PERMISSION_GRANTED() */,
    @kotlinx.serialization.SerialName(value = "permission_revoked")
    /*public static final*/ PERMISSION_REVOKED /* = new PERMISSION_REVOKED() */,
    @kotlinx.serialization.SerialName(value = "permission_expired")
    /*public static final*/ PERMISSION_EXPIRED /* = new PERMISSION_EXPIRED() */,
    @kotlinx.serialization.SerialName(value = "device_connected")
    /*public static final*/ DEVICE_CONNECTED /* = new DEVICE_CONNECTED() */,
    @kotlinx.serialization.SerialName(value = "device_disconnected")
    /*public static final*/ DEVICE_DISCONNECTED /* = new DEVICE_DISCONNECTED() */,
    @kotlinx.serialization.SerialName(value = "session_started")
    /*public static final*/ SESSION_STARTED /* = new SESSION_STARTED() */,
    @kotlinx.serialization.SerialName(value = "session_ended")
    /*public static final*/ SESSION_ENDED /* = new SESSION_ENDED() */,
    @kotlinx.serialization.SerialName(value = "ai_request")
    /*public static final*/ AI_REQUEST /* = new AI_REQUEST() */,
    @kotlinx.serialization.SerialName(value = "ai_response")
    /*public static final*/ AI_RESPONSE /* = new AI_RESPONSE() */,
    @kotlinx.serialization.SerialName(value = "error")
    /*public static final*/ ERROR /* = new ERROR() */;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.AuditActionType.Companion Companion = null;
    
    AuditActionType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.model.AuditActionType> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/domain/model/AuditActionType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vesper/flipper/domain/model/AuditActionType;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.AuditActionType> serializer() {
            return null;
        }
    }
}