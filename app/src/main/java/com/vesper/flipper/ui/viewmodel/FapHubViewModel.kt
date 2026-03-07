package com.vesper.flipper.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vesper.flipper.ble.FlipperFileSystem
import com.vesper.flipper.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FapHubViewModel @Inject constructor(
    private val flipperFileSystem: FlipperFileSystem
) : ViewModel() {

    // Search and filter state
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow<FapCategory?>(null)
    val selectedCategory: StateFlow<FapCategory?> = _selectedCategory.asStateFlow()

    private val _sortBy = MutableStateFlow(SortOption.DOWNLOADS)
    val sortBy: StateFlow<SortOption> = _sortBy.asStateFlow()

    // App list state
    private val _installedApps = MutableStateFlow<Set<String>>(emptySet())
    val installedApps: StateFlow<Set<String>> = _installedApps.asStateFlow()

    // Installation state
    private val _installStatus = MutableStateFlow<Map<String, InstallStatus>>(emptyMap())
    val installStatus: StateFlow<Map<String, InstallStatus>> = _installStatus.asStateFlow()

    // UI state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _selectedApp = MutableStateFlow<FapApp?>(null)
    val selectedApp: StateFlow<FapApp?> = _selectedApp.asStateFlow()

    // Filtered and sorted apps
    val displayedApps: StateFlow<List<FapApp>> = combine(
        _searchQuery,
        _selectedCategory,
        _sortBy,
        _installedApps
    ) { query, category, sort, installed ->
        var apps = FapHubCatalog.allApps

        // Filter by category
        if (category != null) {
            apps = apps.filter { it.category == category }
        }

        // Filter by search query
        if (query.isNotEmpty()) {
            apps = FapHubCatalog.searchApps(query).let { searchResults ->
                if (category != null) {
                    searchResults.filter { it.category == category }
                } else {
                    searchResults
                }
            }
        }

        // Mark installed apps
        apps = apps.map { app ->
            app.copy(isInstalled = installed.contains(app.id))
        }

        // Sort
        when (sort) {
            SortOption.DOWNLOADS -> apps.sortedByDescending { it.downloads }
            SortOption.RATING -> apps.sortedByDescending { it.rating }
            SortOption.NAME -> apps.sortedBy { it.name }
            SortOption.UPDATED -> apps.sortedByDescending { it.updatedAt }
            SortOption.CATEGORY -> apps.sortedBy { it.category.displayName }
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        FapHubCatalog.allApps
    )

    // Category counts for filter chips
    val categoryCounts: StateFlow<Map<FapCategory, Int>> = flow {
        val counts = FapCategory.entries.associateWith { category ->
            FapHubCatalog.getAppsByCategory(category).size
        }
        emit(counts)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyMap()
    )

    init {
        loadInstalledApps()
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectCategory(category: FapCategory?) {
        _selectedCategory.value = category
    }

    fun setSortOption(option: SortOption) {
        _sortBy.value = option
    }

    fun selectApp(app: FapApp?) {
        _selectedApp.value = app
    }

    fun clearError() {
        _error.value = null
    }

    /**
     * Load list of installed apps from Flipper
     */
    private fun loadInstalledApps() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val rootResult = flipperFileSystem.listDirectory("/ext/apps")
                if (rootResult.isSuccess) {
                    val rootEntries = rootResult.getOrNull() ?: emptyList()
                    val fapEntries = rootEntries.filter { !it.isDirectory && it.name.endsWith(".fap") }
                    val dirEntries = rootEntries.filter { it.isDirectory }

                    val nestedFaps = mutableListOf<String>()
                    for (dir in dirEntries) {
                        val nestedResult = flipperFileSystem.listDirectory(dir.path)
                        if (nestedResult.isSuccess) {
                            nestedFaps.addAll(
                                nestedResult.getOrNull().orEmpty()
                                    .filter { !it.isDirectory && it.name.endsWith(".fap") }
                                    .map { it.name }
                            )
                        }
                    }

                    val installed = (fapEntries.map { it.name } + nestedFaps)
                        .map { it.removeSuffix(".fap") }
                        .toSet()
                    _installedApps.value = installed
                }
            } catch (e: Exception) {
                // Silently fail - might not be connected
            } finally {
                _isLoading.value = false
            }
        }
    }

    /**
     * Install an app to the Flipper
     */
    fun installApp(app: FapApp) {
        viewModelScope.launch {
            _installStatus.value = _installStatus.value + (app.id to InstallStatus.Downloading(0f))

            try {
                // Simulate download progress (in real implementation, this would be actual HTTP download)
                for (progress in listOf(0.1f, 0.3f, 0.5f, 0.7f, 0.9f)) {
                    _installStatus.value = _installStatus.value + (app.id to InstallStatus.Downloading(progress))
                    kotlinx.coroutines.delay(200)
                }

                _installStatus.value = _installStatus.value + (app.id to InstallStatus.Installing)

                // In a real implementation, we would:
                // 1. Download the .fap file from app.downloadUrl
                // 2. Push it to the Flipper via flipperFileSystem.writeFile()

                // For now, create a placeholder that shows the app would be installed
                val targetPath = "/ext/apps/${app.category.name.lowercase()}/${app.id}.fap"

                // Simulate installation
                kotlinx.coroutines.delay(500)

                _installStatus.value = _installStatus.value + (app.id to InstallStatus.Success)
                _installedApps.value = _installedApps.value + app.id

                // Clear status after delay
                kotlinx.coroutines.delay(2000)
                _installStatus.value = _installStatus.value - app.id

            } catch (e: Exception) {
                _installStatus.value = _installStatus.value + (app.id to InstallStatus.Error(e.message ?: "Unknown error"))
                _error.value = "Failed to install ${app.name}: ${e.message}"
            }
        }
    }

    /**
     * Uninstall an app from the Flipper
     */
    fun uninstallApp(app: FapApp) {
        viewModelScope.launch {
            try {
                val paths = listOf(
                    "/ext/apps/${app.id}.fap",
                    "/ext/apps/${app.category.name.lowercase()}/${app.id}.fap"
                )

                for (path in paths) {
                    flipperFileSystem.deleteFile(path)
                }

                _installedApps.value = _installedApps.value - app.id
            } catch (e: Exception) {
                _error.value = "Failed to uninstall ${app.name}: ${e.message}"
            }
        }
    }

    /**
     * Refresh the installed apps list
     */
    fun refresh() {
        loadInstalledApps()
    }
}

enum class SortOption(val displayName: String) {
    DOWNLOADS("Most Popular"),
    RATING("Highest Rated"),
    NAME("Alphabetical"),
    UPDATED("Recently Updated"),
    CATEGORY("By Category")
}
