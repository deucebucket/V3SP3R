package com.vesper.flipper.ai;

import com.vesper.flipper.data.SettingsStore;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.security.InputValidator;
import com.vesper.flipper.security.RateLimiter;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.*;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * OpenRouter API client for AI model interaction.
 * Handles tool-calling with the execute_command interface.
 * Includes rate limiting, retry logic, and response validation.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 L2\u00020\u0001:\u0003LMNB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u0010\u0018\u001a\u00020\fH\u0002J$\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00152\u0006\u0010\u001c\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\fH\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010,\u001a\u00020\fH\u0002J\u0010\u0010/\u001a\u00020(2\u0006\u0010,\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\fJ\u0012\u0010:\u001a\u0004\u0018\u0001042\u0006\u0010;\u001a\u00020\fH\u0002J\u000e\u0010<\u001a\u00020=2\u0006\u00109\u001a\u00020\fJ\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\fH\u0002J\u0010\u0010@\u001a\u00020\f2\u0006\u00103\u001a\u000204H\u0002J\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0002J\u0012\u0010B\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\fH\u0002J@\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0D2\u0006\u0010,\u001a\u00020\f2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00152\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bG\u0010HJ6\u0010I\u001a\b\u0012\u0004\u0012\u00020\f0D2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00152\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bJ\u0010\u001dJ\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006O"}, d2 = {"Lcom/vesper/flipper/ai/OpenRouterClient;", "", "settingsStore", "Lcom/vesper/flipper/data/SettingsStore;", "(Lcom/vesper/flipper/data/SettingsStore;)V", "client", "Lokhttp3/OkHttpClient;", "json", "Lkotlinx/serialization/json/Json;", "rateLimiter", "Lcom/vesper/flipper/security/RateLimiter;", "systemPrompt", "", "toolUnsupportedModels", "Ljava/util/concurrent/ConcurrentHashMap;", "", "buildToolCallingRequest", "Lokhttp3/Request;", "apiKey", "model", "messages", "", "Lcom/vesper/flipper/ai/OpenRouterMessage;", "buildToolModelCandidates", "selectedModel", "chat", "Lcom/vesper/flipper/ai/ChatCompletionResult;", "Lcom/vesper/flipper/domain/model/ChatMessage;", "sessionId", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "describeJsonType", "element", "Lkotlinx/serialization/json/JsonElement;", "executeWithRetry", "request", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatResult", "result", "Lcom/vesper/flipper/domain/model/CommandResult;", "isDnsResolutionFailure", "", "error", "", "isModelAvailabilityError", "message", "isToolModelTemporarilyBlocked", "isToolResultPairingError", "isToolUseUnsupportedError", "markToolModelUnsupported", "", "missingRequiredArgs", "action", "Lcom/vesper/flipper/domain/model/CommandAction;", "args", "Lcom/vesper/flipper/domain/model/CommandArgs;", "parseCommand", "Lcom/vesper/flipper/domain/model/ExecuteCommand;", "arguments", "parseCommandAction", "value", "parseCommandDetailed", "Lcom/vesper/flipper/ai/OpenRouterClient$ParsedCommand;", "parseResponse", "responseBody", "requiredArgsExample", "sanitizeAndBuildRequestMessages", "sanitizeErrorMessage", "sendMessage", "Lkotlin/Result;", "conversationHistory", "customSystemPrompt", "sendMessage-BWLJW6A", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessagesWithoutTools", "sendMessagesWithoutTools-0E7RQCE", "trimConversationForRequest", "Companion", "ParsedCommand", "RetryConfig", "app_debug"})
public final class OpenRouterClient {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.SettingsStore settingsStore = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.serialization.json.Json json = null;
    @org.jetbrains.annotations.NotNull
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.security.RateLimiter rateLimiter = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> toolUnsupportedModels = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String systemPrompt = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String OPENROUTER_API_URL = "https://openrouter.ai/api/v1/chat/completions";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DNS_RESOLUTION_ERROR_MESSAGE = "Cannot resolve openrouter.ai (DNS/network issue). Verify internet access, disable broken Private DNS/VPN, then retry.";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EXPECTED_TOOL_ARGUMENTS_FORMAT = "{\"action\":\"<action>\",\"args\":{...},\"justification\":\"...\",\"expected_effect\":\"...\"}";
    private static final int MAX_TOOL_MODEL_CANDIDATES = 10;
    private static final int MAX_ERROR_MODEL_LIST = 6;
    private static final int MAX_TOOL_CALLS_PER_RESPONSE = 1;
    private static final long TOOL_UNSUPPORTED_CACHE_MS = 300000L;
    private static final int MAX_CONTEXT_MESSAGES = 24;
    private static final int TOOL_CALL_RESPONSE_MAX_TOKENS = 320;
    private static final int DEFAULT_RESPONSE_MAX_TOKENS = 720;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> SUPPORTED_ACTIONS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> TOOL_USE_FALLBACK_MODELS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.Set<java.lang.String> KNOWN_NON_TOOL_MODELS = null;
    @org.jetbrains.annotations.NotNull
    private static final com.vesper.flipper.ai.OpenRouterTool EXECUTE_COMMAND_TOOL = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ai.OpenRouterClient.Companion Companion = null;
    
    @javax.inject.Inject
    public OpenRouterClient(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.SettingsStore settingsStore) {
        super();
    }
    
    /**
     * Send a chat completion request with tool calling.
     * Includes rate limiting, retry logic with exponential backoff, and response validation.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object chat(@org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages, @org.jetbrains.annotations.NotNull
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ai.ChatCompletionResult> $completion) {
        return null;
    }
    
    private final okhttp3.Request buildToolCallingRequest(java.lang.String apiKey, java.lang.String model, java.util.List<com.vesper.flipper.ai.OpenRouterMessage> messages) {
        return null;
    }
    
    /**
     * Execute HTTP request with exponential backoff retry for transient failures.
     */
    private final java.lang.Object executeWithRetry(okhttp3.Request request, kotlin.coroutines.Continuation<? super com.vesper.flipper.ai.ChatCompletionResult> $completion) {
        return null;
    }
    
    /**
     * Parse and validate the API response.
     */
    private final com.vesper.flipper.ai.ChatCompletionResult parseResponse(java.lang.String responseBody) {
        return null;
    }
    
    private final java.util.List<com.vesper.flipper.ai.OpenRouterMessage> sanitizeAndBuildRequestMessages(java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages) {
        return null;
    }
    
    /**
     * Parse tool call arguments into ExecuteCommand
     */
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ExecuteCommand parseCommand(@org.jetbrains.annotations.NotNull
    java.lang.String arguments) {
        return null;
    }
    
    /**
     * Parse tool call arguments and include a diagnostic error on failure.
     */
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ai.OpenRouterClient.ParsedCommand parseCommandDetailed(@org.jetbrains.annotations.NotNull
    java.lang.String arguments) {
        return null;
    }
    
    private final com.vesper.flipper.domain.model.CommandAction parseCommandAction(java.lang.String value) {
        return null;
    }
    
    private final java.lang.String describeJsonType(kotlinx.serialization.json.JsonElement element) {
        return null;
    }
    
    private final java.lang.String sanitizeErrorMessage(java.lang.String message) {
        return null;
    }
    
    private final java.util.List<java.lang.String> missingRequiredArgs(com.vesper.flipper.domain.model.CommandAction action, com.vesper.flipper.domain.model.CommandArgs args) {
        return null;
    }
    
    private final java.lang.String requiredArgsExample(com.vesper.flipper.domain.model.CommandAction action) {
        return null;
    }
    
    /**
     * Format command result for tool response
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatResult(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.CommandResult result) {
        return null;
    }
    
    private final boolean isDnsResolutionFailure(java.lang.Throwable error) {
        return false;
    }
    
    private final boolean isToolUseUnsupportedError(java.lang.String message) {
        return false;
    }
    
    private final boolean isToolResultPairingError(java.lang.String message) {
        return false;
    }
    
    private final boolean isModelAvailabilityError(java.lang.String message) {
        return false;
    }
    
    private final java.util.List<java.lang.String> buildToolModelCandidates(java.lang.String selectedModel) {
        return null;
    }
    
    private final boolean isToolModelTemporarilyBlocked(java.lang.String model) {
        return false;
    }
    
    private final void markToolModelUnsupported(java.lang.String model) {
    }
    
    private final java.util.List<com.vesper.flipper.domain.model.ChatMessage> trimConversationForRequest(java.util.List<com.vesper.flipper.domain.model.ChatMessage> messages) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/vesper/flipper/ai/OpenRouterClient$Companion;", "", "()V", "DEFAULT_RESPONSE_MAX_TOKENS", "", "DNS_RESOLUTION_ERROR_MESSAGE", "", "EXECUTE_COMMAND_TOOL", "Lcom/vesper/flipper/ai/OpenRouterTool;", "EXPECTED_TOOL_ARGUMENTS_FORMAT", "KNOWN_NON_TOOL_MODELS", "", "MAX_CONTEXT_MESSAGES", "MAX_ERROR_MODEL_LIST", "MAX_TOOL_CALLS_PER_RESPONSE", "MAX_TOOL_MODEL_CANDIDATES", "OPENROUTER_API_URL", "SUPPORTED_ACTIONS", "", "TOOL_CALL_RESPONSE_MAX_TOKENS", "TOOL_UNSUPPORTED_CACHE_MS", "", "TOOL_USE_FALLBACK_MODELS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/vesper/flipper/ai/OpenRouterClient$ParsedCommand;", "", "command", "Lcom/vesper/flipper/domain/model/ExecuteCommand;", "error", "", "(Lcom/vesper/flipper/domain/model/ExecuteCommand;Ljava/lang/String;)V", "getCommand", "()Lcom/vesper/flipper/domain/model/ExecuteCommand;", "getError", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ParsedCommand {
        @org.jetbrains.annotations.Nullable
        private final com.vesper.flipper.domain.model.ExecuteCommand command = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String error = null;
        
        public ParsedCommand(@org.jetbrains.annotations.Nullable
        com.vesper.flipper.domain.model.ExecuteCommand command, @org.jetbrains.annotations.Nullable
        java.lang.String error) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.vesper.flipper.domain.model.ExecuteCommand getCommand() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getError() {
            return null;
        }
        
        public ParsedCommand() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.vesper.flipper.domain.model.ExecuteCommand component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ai.OpenRouterClient.ParsedCommand copy(@org.jetbrains.annotations.Nullable
        com.vesper.flipper.domain.model.ExecuteCommand command, @org.jetbrains.annotations.Nullable
        java.lang.String error) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/ai/OpenRouterClient$RetryConfig;", "", "()V", "BACKOFF_MULTIPLIER", "", "INITIAL_DELAY_MS", "", "MAX_DELAY_MS", "MAX_RETRIES", "", "app_debug"})
    static final class RetryConfig {
        public static final int MAX_RETRIES = 2;
        public static final long INITIAL_DELAY_MS = 700L;
        public static final long MAX_DELAY_MS = 10000L;
        public static final double BACKOFF_MULTIPLIER = 2.0;
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.ai.OpenRouterClient.RetryConfig INSTANCE = null;
        
        private RetryConfig() {
            super();
        }
    }
}