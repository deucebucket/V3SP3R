package com.vesper.flipper.domain.model;

import android.net.Uri;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import java.util.UUID;

/**
 * Conversation state for the chat
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0002\u0010\u000eJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\fH\u00c6\u0003JQ\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\fH\u00d6\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u00a8\u0006%"}, d2 = {"Lcom/vesper/flipper/domain/model/ConversationState;", "", "messages", "", "Lcom/vesper/flipper/domain/model/ChatMessage;", "isLoading", "", "pendingApproval", "Lcom/vesper/flipper/domain/model/PendingApproval;", "progress", "Lcom/vesper/flipper/domain/model/AgentProgress;", "error", "", "sessionId", "(Ljava/util/List;ZLcom/vesper/flipper/domain/model/PendingApproval;Lcom/vesper/flipper/domain/model/AgentProgress;Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "()Z", "getMessages", "()Ljava/util/List;", "getPendingApproval", "()Lcom/vesper/flipper/domain/model/PendingApproval;", "getProgress", "()Lcom/vesper/flipper/domain/model/AgentProgress;", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class ConversationState {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.PendingApproval pendingApproval = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.AgentProgress progress = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String sessionId = null;
    
    public ConversationState(@org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages, boolean isLoading, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.PendingApproval pendingApproval, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.AgentProgress progress, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.NotNull
    java.lang.String sessionId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.ChatMessage> getMessages() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.PendingApproval getPendingApproval() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.AgentProgress getProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSessionId() {
        return null;
    }
    
    public ConversationState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.ChatMessage> component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.PendingApproval component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.AgentProgress component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ConversationState copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages, boolean isLoading, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.PendingApproval pendingApproval, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.AgentProgress progress, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.NotNull
    java.lang.String sessionId) {
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