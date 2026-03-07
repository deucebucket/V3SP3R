package com.vesper.flipper.ai;

import com.vesper.flipper.data.SettingsStore;
import com.vesper.flipper.data.database.ChatDao;
import com.vesper.flipper.data.database.ChatMessageEntity;
import com.vesper.flipper.domain.executor.CommandExecutor;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.domain.service.AuditService;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.*;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.vesper.flipper.domain.model.ToolResult;

/**
 * Main AI agent orchestrator.
 * Manages conversation flow, tool execution, and state.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002?@B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010\"J\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u001dH\u0082@\u00a2\u0006\u0002\u0010&J\u0016\u0010\'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0082@\u00a2\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020\u000f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0082@\u00a2\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020\u001dH\u0082@\u00a2\u0006\u0002\u0010&J(\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u00152\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0086@\u00a2\u0006\u0002\u00106J\u0012\u00107\u001a\u00020\u001d2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0015J\f\u00109\u001a\u00020\u0015*\u00020:H\u0002J\u000e\u0010;\u001a\u0004\u0018\u00010.*\u00020<H\u0002J\u0014\u0010=\u001a\u00020<*\u00020.2\u0006\u0010>\u001a\u00020\u0015H\u0002R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lcom/vesper/flipper/ai/VesperAgent;", "", "openRouterClient", "Lcom/vesper/flipper/ai/OpenRouterClient;", "commandExecutor", "Lcom/vesper/flipper/domain/executor/CommandExecutor;", "auditService", "Lcom/vesper/flipper/domain/service/AuditService;", "chatDao", "Lcom/vesper/flipper/data/database/ChatDao;", "settingsStore", "Lcom/vesper/flipper/data/SettingsStore;", "(Lcom/vesper/flipper/ai/OpenRouterClient;Lcom/vesper/flipper/domain/executor/CommandExecutor;Lcom/vesper/flipper/domain/service/AuditService;Lcom/vesper/flipper/data/database/ChatDao;Lcom/vesper/flipper/data/SettingsStore;)V", "_conversationState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/domain/model/ConversationState;", "conversationState", "Lkotlinx/coroutines/flow/StateFlow;", "getConversationState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentSessionId", "", "persistenceJson", "Lkotlinx/serialization/json/Json;", "persistenceMutex", "Lkotlinx/coroutines/sync/Mutex;", "persistenceScope", "Lkotlinx/coroutines/CoroutineScope;", "clearConversation", "", "continueAfterApproval", "approvalId", "approved", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentApproval", "Lcom/vesper/flipper/domain/model/PendingApproval;", "observeConversationPersistence", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistConversationSnapshot", "snapshot", "Lcom/vesper/flipper/ai/VesperAgent$PersistedConversationSnapshot;", "(Lcom/vesper/flipper/ai/VesperAgent$PersistedConversationSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAIResponse", "messages", "", "Lcom/vesper/flipper/domain/model/ChatMessage;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restorePersistedConversation", "sendMessage", "userMessage", "imageAttachments", "", "Lcom/vesper/flipper/domain/model/ImageAttachment;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startNewSession", "deviceName", "displayName", "Lcom/vesper/flipper/domain/model/CommandAction;", "toDomainMessageOrNull", "Lcom/vesper/flipper/data/database/ChatMessageEntity;", "toEntity", "sessionId", "Companion", "PersistedConversationSnapshot", "app_debug"})
public final class VesperAgent {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ai.OpenRouterClient openRouterClient = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.executor.CommandExecutor commandExecutor = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.service.AuditService auditService = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.database.ChatDao chatDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.SettingsStore settingsStore = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.ConversationState> _conversationState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.ConversationState> conversationState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope persistenceScope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.sync.Mutex persistenceMutex = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.serialization.json.Json persistenceJson = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String currentSessionId;
    private static final int MAX_PERSISTED_MESSAGES = 220;
    private static final long CONVERSATION_PERSIST_DEBOUNCE_MS = 250L;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ai.VesperAgent.Companion Companion = null;
    
    @javax.inject.Inject
    public VesperAgent(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.OpenRouterClient openRouterClient, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.executor.CommandExecutor commandExecutor, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.service.AuditService auditService, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.database.ChatDao chatDao, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.SettingsStore settingsStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.ConversationState> getConversationState() {
        return null;
    }
    
    /**
     * Start a new conversation session
     */
    public final void startNewSession(@org.jetbrains.annotations.Nullable
    java.lang.String deviceName) {
    }
    
    /**
     * Send a user message and process the response
     * @param userMessage The text content of the message
     * @param imageAttachments Optional list of image attachments for multimodal input
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendMessage(@org.jetbrains.annotations.NotNull
    java.lang.String userMessage, @org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.ImageAttachment> imageAttachments, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.domain.model.ConversationState> $completion) {
        return null;
    }
    
    /**
     * Continue after tool approval/rejection
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object continueAfterApproval(@org.jetbrains.annotations.NotNull
    java.lang.String approvalId, boolean approved, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.domain.model.ConversationState> $completion) {
        return null;
    }
    
    private final java.lang.Object processAIResponse(java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages, kotlin.coroutines.Continuation<? super com.vesper.flipper.domain.model.ConversationState> $completion) {
        return null;
    }
    
    private final java.lang.Object restorePersistedConversation(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.FlowPreview.class})
    private final java.lang.Object observeConversationPersistence(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object persistConversationSnapshot(com.vesper.flipper.ai.VesperAgent.PersistedConversationSnapshot snapshot, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.vesper.flipper.data.database.ChatMessageEntity toEntity(com.vesper.flipper.domain.model.ChatMessage $this$toEntity, java.lang.String sessionId) {
        return null;
    }
    
    private final com.vesper.flipper.domain.model.ChatMessage toDomainMessageOrNull(com.vesper.flipper.data.database.ChatMessageEntity $this$toDomainMessageOrNull) {
        return null;
    }
    
    /**
     * Clear conversation history
     */
    public final void clearConversation() {
    }
    
    /**
     * Get the current pending approval if any
     */
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.PendingApproval getCurrentApproval() {
        return null;
    }
    
    private final java.lang.String displayName(com.vesper.flipper.domain.model.CommandAction $this$displayName) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/vesper/flipper/ai/VesperAgent$Companion;", "", "()V", "CONVERSATION_PERSIST_DEBOUNCE_MS", "", "MAX_PERSISTED_MESSAGES", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/vesper/flipper/ai/VesperAgent$PersistedConversationSnapshot;", "", "sessionId", "", "messages", "", "Lcom/vesper/flipper/domain/model/ChatMessage;", "(Ljava/lang/String;Ljava/util/List;)V", "getMessages", "()Ljava/util/List;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class PersistedConversationSnapshot {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String sessionId = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages = null;
        
        public PersistedConversationSnapshot(@org.jetbrains.annotations.NotNull
        java.lang.String sessionId, @org.jetbrains.annotations.NotNull
        java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSessionId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.vesper.flipper.domain.model.ChatMessage> getMessages() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.vesper.flipper.domain.model.ChatMessage> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ai.VesperAgent.PersistedConversationSnapshot copy(@org.jetbrains.annotations.NotNull
        java.lang.String sessionId, @org.jetbrains.annotations.NotNull
        java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages) {
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
}