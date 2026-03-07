package com.vesper.flipper.data;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.*;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u00103J\u0016\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u00106J\u0016\u00107\u001a\u0002012\u0006\u00108\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u00103J\u0016\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010;J\u0016\u0010<\u001a\u0002012\u0006\u0010:\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010;J\u0016\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u00106J\u0016\u0010?\u001a\u0002012\u0006\u0010:\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010;J\u0018\u0010@\u001a\u0002012\b\u0010A\u001a\u0004\u0018\u00010\tH\u0086@\u00a2\u0006\u0002\u00106J\u001e\u0010B\u001a\u0002012\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u00106R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0019R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019\u00a8\u0006L"}, d2 = {"Lcom/vesper/flipper/data/SettingsStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "AI_MAX_ITERATIONS", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "API_KEY", "", "AUDIT_RETENTION_DAYS", "AUTO_CONNECT", "", "DARK_MODE", "DEFAULT_PROJECT_PATH", "HAPTIC_FEEDBACK", "LAST_CHAT_SESSION_ID", "LAST_DEVICE_ADDRESS", "LAST_DEVICE_NAME", "PERMISSION_DURATION", "", "SELECTED_MODEL", "aiMaxIterations", "Lkotlinx/coroutines/flow/Flow;", "getAiMaxIterations", "()Lkotlinx/coroutines/flow/Flow;", "apiKey", "getApiKey", "auditRetentionDays", "getAuditRetentionDays", "autoConnect", "getAutoConnect", "darkMode", "getDarkMode", "defaultProjectPath", "getDefaultProjectPath", "hapticFeedback", "getHapticFeedback", "lastChatSessionId", "getLastChatSessionId", "lastDeviceAddress", "getLastDeviceAddress", "lastDeviceName", "getLastDeviceName", "permissionDuration", "getPermissionDuration", "selectedModel", "getSelectedModel", "setAiMaxIterations", "", "value", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApiKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAuditRetentionDays", "days", "setAutoConnect", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDarkMode", "setDefaultProjectPath", "path", "setHapticFeedback", "setLastChatSessionId", "sessionId", "setLastDevice", "address", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPermissionDuration", "durationMs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSelectedModel", "model", "Companion", "app_debug"})
public final class SettingsStore {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> API_KEY = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> apiKey = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> SELECTED_MODEL = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> selectedModel = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> LAST_DEVICE_ADDRESS = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> LAST_DEVICE_NAME = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> LAST_CHAT_SESSION_ID = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> lastDeviceAddress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> lastDeviceName = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> lastChatSessionId = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> AUTO_CONNECT = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> autoConnect = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> DEFAULT_PROJECT_PATH = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> defaultProjectPath = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Long> PERMISSION_DURATION = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Long> permissionDuration = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> HAPTIC_FEEDBACK = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> hapticFeedback = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> DARK_MODE = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> darkMode = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> AUDIT_RETENTION_DAYS = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Integer> auditRetentionDays = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> AI_MAX_ITERATIONS = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Integer> aiMaxIterations = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEFAULT_MODEL = "nousresearch/hermes-4-405b";
    public static final int DEFAULT_AI_MAX_ITERATIONS = 10;
    public static final int MIN_AI_MAX_ITERATIONS = 4;
    public static final int MAX_AI_MAX_ITERATIONS = 20;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<com.vesper.flipper.data.ModelInfo> FALLBACK_MODELS = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.data.SettingsStore.Companion Companion = null;
    
    @javax.inject.Inject
    public SettingsStore(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getApiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setApiKey(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getSelectedModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setSelectedModel(@org.jetbrains.annotations.NotNull
    java.lang.String model, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getLastDeviceAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getLastDeviceName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setLastDevice(@org.jetbrains.annotations.NotNull
    java.lang.String address, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getLastChatSessionId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setLastChatSessionId(@org.jetbrains.annotations.Nullable
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAutoConnect() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setAutoConnect(boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getDefaultProjectPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDefaultProjectPath(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Long> getPermissionDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setPermissionDuration(long durationMs, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getHapticFeedback() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setHapticFeedback(boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getDarkMode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDarkMode(boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getAuditRetentionDays() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setAuditRetentionDays(int days, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getAiMaxIterations() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setAiMaxIterations(int value, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/vesper/flipper/data/SettingsStore$Companion;", "", "()V", "DEFAULT_AI_MAX_ITERATIONS", "", "DEFAULT_MODEL", "", "FALLBACK_MODELS", "", "Lcom/vesper/flipper/data/ModelInfo;", "getFALLBACK_MODELS", "()Ljava/util/List;", "MAX_AI_MAX_ITERATIONS", "MIN_AI_MAX_ITERATIONS", "getModelDisplayName", "modelId", "availableModels", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.vesper.flipper.data.ModelInfo> getFALLBACK_MODELS() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getModelDisplayName(@org.jetbrains.annotations.NotNull
        java.lang.String modelId, @org.jetbrains.annotations.NotNull
        java.util.List<com.vesper.flipper.data.ModelInfo> availableModels) {
            return null;
        }
    }
}