package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.*;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0011J\b\u00101\u001a\u00020.H\u0002J\u0006\u00102\u001a\u00020.J\u0010\u00103\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\u0011J\u0010\u00104\u001a\u00020.2\b\u00105\u001a\u0004\u0018\u00010\u0013J\u000e\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u0015J\u000e\u00108\u001a\u00020.2\u0006\u00100\u001a\u00020\u0011J\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001c0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0019\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001a\u00a8\u0006;"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/FapHubViewModel;", "Landroidx/lifecycle/ViewModel;", "flipperFileSystem", "Lcom/vesper/flipper/ble/FlipperFileSystem;", "(Lcom/vesper/flipper/ble/FlipperFileSystem;)V", "_error", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_installStatus", "", "Lcom/vesper/flipper/domain/model/InstallStatus;", "_installedApps", "", "_isLoading", "", "_searchQuery", "_selectedApp", "Lcom/vesper/flipper/domain/model/FapApp;", "_selectedCategory", "Lcom/vesper/flipper/domain/model/FapCategory;", "_sortBy", "Lcom/vesper/flipper/ui/viewmodel/SortOption;", "categoryCounts", "Lkotlinx/coroutines/flow/StateFlow;", "", "getCategoryCounts", "()Lkotlinx/coroutines/flow/StateFlow;", "displayedApps", "", "getDisplayedApps", "error", "getError", "installStatus", "getInstallStatus", "installedApps", "getInstalledApps", "isLoading", "searchQuery", "getSearchQuery", "selectedApp", "getSelectedApp", "selectedCategory", "getSelectedCategory", "sortBy", "getSortBy", "clearError", "", "installApp", "app", "loadInstalledApps", "refresh", "selectApp", "selectCategory", "category", "setSortOption", "option", "uninstallApp", "updateSearchQuery", "query", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class FapHubViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperFileSystem flipperFileSystem = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.FapCategory> _selectedCategory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.FapCategory> selectedCategory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ui.viewmodel.SortOption> _sortBy = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.SortOption> sortBy = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Set<java.lang.String>> _installedApps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Set<java.lang.String>> installedApps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, com.vesper.flipper.domain.model.InstallStatus>> _installStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, com.vesper.flipper.domain.model.InstallStatus>> installStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.FapApp> _selectedApp = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.FapApp> selectedApp = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.FapApp>> displayedApps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<com.vesper.flipper.domain.model.FapCategory, java.lang.Integer>> categoryCounts = null;
    
    @javax.inject.Inject
    public FapHubViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperFileSystem flipperFileSystem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.FapCategory> getSelectedCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.SortOption> getSortBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Set<java.lang.String>> getInstalledApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, com.vesper.flipper.domain.model.InstallStatus>> getInstallStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.FapApp> getSelectedApp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.FapApp>> getDisplayedApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<com.vesper.flipper.domain.model.FapCategory, java.lang.Integer>> getCategoryCounts() {
        return null;
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void selectCategory(@org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.FapCategory category) {
    }
    
    public final void setSortOption(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.SortOption option) {
    }
    
    public final void selectApp(@org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.FapApp app) {
    }
    
    public final void clearError() {
    }
    
    /**
     * Load list of installed apps from Flipper
     */
    private final void loadInstalledApps() {
    }
    
    /**
     * Install an app to the Flipper
     */
    public final void installApp(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.FapApp app) {
    }
    
    /**
     * Uninstall an app from the Flipper
     */
    public final void uninstallApp(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.FapApp app) {
    }
    
    /**
     * Refresh the installed apps list
     */
    public final void refresh() {
    }
}