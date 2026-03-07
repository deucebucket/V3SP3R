package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.data.ModelInfo;
import com.vesper.flipper.data.OpenRouterModelCatalog;
import com.vesper.flipper.data.SettingsStore;
import com.vesper.flipper.domain.model.CommandAction;
import com.vesper.flipper.domain.model.Permission;
import com.vesper.flipper.domain.service.PermissionService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020\u0019J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020%J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0019J\u000e\u0010/\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u000eJ\u000e\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0019R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014\u00a8\u00065"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "settingsStore", "Lcom/vesper/flipper/data/SettingsStore;", "openRouterModelCatalog", "Lcom/vesper/flipper/data/OpenRouterModelCatalog;", "permissionService", "Lcom/vesper/flipper/domain/service/PermissionService;", "(Lcom/vesper/flipper/data/SettingsStore;Lcom/vesper/flipper/data/OpenRouterModelCatalog;Lcom/vesper/flipper/domain/service/PermissionService;)V", "_availableModels", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/vesper/flipper/data/ModelInfo;", "_isRefreshingModels", "", "_state", "Lcom/vesper/flipper/ui/viewmodel/SettingsState;", "availableModels", "Lkotlinx/coroutines/flow/StateFlow;", "getAvailableModels", "()Lkotlinx/coroutines/flow/StateFlow;", "isRefreshingModels", "state", "getState", "getModelDisplayName", "", "modelId", "grantProjectPermission", "", "loadSettings", "observePermissions", "refreshAvailableModels", "revokeAllPermissions", "revokePermission", "permissionId", "setAiMaxIterations", "value", "", "setApiKey", "key", "setAuditRetentionDays", "days", "setAutoConnect", "enabled", "setDarkMode", "setDefaultProjectPath", "path", "setHapticFeedback", "setPermissionDuration", "durationMs", "", "setSelectedModel", "model", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.SettingsStore settingsStore = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.OpenRouterModelCatalog openRouterModelCatalog = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.service.PermissionService permissionService = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ui.viewmodel.SettingsState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.SettingsState> state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.data.ModelInfo>> _availableModels = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.data.ModelInfo>> availableModels = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshingModels = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshingModels = null;
    
    @javax.inject.Inject
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.SettingsStore settingsStore, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.OpenRouterModelCatalog openRouterModelCatalog, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.service.PermissionService permissionService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.SettingsState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.data.ModelInfo>> getAvailableModels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshingModels() {
        return null;
    }
    
    private final void loadSettings() {
    }
    
    private final void observePermissions() {
    }
    
    public final void setApiKey(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
    }
    
    public final void setSelectedModel(@org.jetbrains.annotations.NotNull
    java.lang.String model) {
    }
    
    public final void setAiMaxIterations(int value) {
    }
    
    public final void refreshAvailableModels() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getModelDisplayName(@org.jetbrains.annotations.NotNull
    java.lang.String modelId) {
        return null;
    }
    
    public final void setAutoConnect(boolean enabled) {
    }
    
    public final void setDefaultProjectPath(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
    }
    
    public final void setPermissionDuration(long durationMs) {
    }
    
    public final void setHapticFeedback(boolean enabled) {
    }
    
    public final void setDarkMode(boolean enabled) {
    }
    
    public final void setAuditRetentionDays(int days) {
    }
    
    public final void revokePermission(@org.jetbrains.annotations.NotNull
    java.lang.String permissionId) {
    }
    
    public final void revokeAllPermissions() {
    }
    
    public final void grantProjectPermission() {
    }
}