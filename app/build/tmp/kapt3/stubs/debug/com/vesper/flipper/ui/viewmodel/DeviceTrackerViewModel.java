package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.data.db.*;
import com.vesper.flipper.data.repository.DeviceRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007J\u0010\u00109\u001a\u0002062\b\b\u0002\u0010:\u001a\u00020\u0017J\u000e\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020\u000bJ\u000e\u0010=\u001a\u0002062\u0006\u0010>\u001a\u00020\'J\u0010\u0010?\u001a\u0002062\b\u0010@\u001a\u0004\u0018\u00010\tJ\u0010\u0010A\u001a\u0002062\b\u0010<\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010B\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010\rJ\u0016\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010G\u001a\u0002062\u0006\u0010H\u001a\u00020\u0011J\u0016\u0010I\u001a\u0002062\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u0002062\u0006\u0010<\u001a\u00020\u000bJ\u000e\u0010M\u001a\u0002062\u0006\u0010<\u001a\u00020\u000bJ\u0006\u0010N\u001a\u000206J\u000e\u0010O\u001a\u0002062\u0006\u0010P\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00140\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0\u00140\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00140\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019R#\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0017030\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0019\u00a8\u0006Q"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/DeviceTrackerViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/vesper/flipper/data/repository/DeviceRepository;", "(Lcom/vesper/flipper/data/repository/DeviceRepository;)V", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_selectedCategory", "Lcom/vesper/flipper/data/db/DeviceCategory;", "_selectedDevice", "Lcom/vesper/flipper/data/db/TrackedDevice;", "_selectedType", "Lcom/vesper/flipper/data/db/DeviceType;", "_showHidden", "", "_sortBy", "Lcom/vesper/flipper/ui/viewmodel/DeviceSortOption;", "baseDevices", "Lkotlinx/coroutines/flow/Flow;", "", "deviceCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "getDeviceCount", "()Lkotlinx/coroutines/flow/StateFlow;", "devices", "getDevices", "last24Hours", "", "recentCount", "getRecentCount", "searchQuery", "getSearchQuery", "selectedCategory", "getSelectedCategory", "selectedDevice", "getSelectedDevice", "selectedDeviceNotes", "Lcom/vesper/flipper/data/db/DeviceNote;", "getSelectedDeviceNotes", "selectedDeviceSightings", "Lcom/vesper/flipper/data/db/DeviceSighting;", "getSelectedDeviceSightings", "selectedType", "getSelectedType", "showHidden", "getShowHidden", "sortBy", "getSortBy", "typeCounts", "", "getTypeCounts", "addNote", "", "deviceId", "content", "cleanupOldSightings", "days", "deleteDevice", "device", "deleteNote", "note", "selectCategory", "category", "selectDevice", "selectType", "type", "setDeviceAlias", "id", "alias", "setSortOption", "option", "setThreatLevel", "threat", "Lcom/vesper/flipper/data/db/ThreatLevel;", "toggleFavorite", "toggleHidden", "toggleShowHidden", "updateSearchQuery", "query", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class DeviceTrackerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.repository.DeviceRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.data.db.DeviceType> _selectedType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.data.db.DeviceType> selectedType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.data.db.DeviceCategory> _selectedCategory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.data.db.DeviceCategory> selectedCategory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _showHidden = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> showHidden = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ui.viewmodel.DeviceSortOption> _sortBy = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.DeviceSortOption> sortBy = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.data.db.TrackedDevice> _selectedDevice = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.data.db.TrackedDevice> selectedDevice = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> deviceCount = null;
    private final long last24Hours = 0L;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> recentCount = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> baseDevices = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> devices = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<com.vesper.flipper.data.db.DeviceType, java.lang.Integer>> typeCounts = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.data.db.DeviceSighting>> selectedDeviceSightings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.data.db.DeviceNote>> selectedDeviceNotes = null;
    
    @javax.inject.Inject
    public DeviceTrackerViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.repository.DeviceRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.data.db.DeviceType> getSelectedType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.data.db.DeviceCategory> getSelectedCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getShowHidden() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.DeviceSortOption> getSortBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.data.db.TrackedDevice> getSelectedDevice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getDeviceCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getRecentCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<com.vesper.flipper.data.db.DeviceType, java.lang.Integer>> getTypeCounts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.data.db.DeviceSighting>> getSelectedDeviceSightings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.data.db.DeviceNote>> getSelectedDeviceNotes() {
        return null;
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void selectType(@org.jetbrains.annotations.Nullable
    com.vesper.flipper.data.db.DeviceType type) {
    }
    
    public final void selectCategory(@org.jetbrains.annotations.Nullable
    com.vesper.flipper.data.db.DeviceCategory category) {
    }
    
    public final void toggleShowHidden() {
    }
    
    public final void setSortOption(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.DeviceSortOption option) {
    }
    
    public final void selectDevice(@org.jetbrains.annotations.Nullable
    com.vesper.flipper.data.db.TrackedDevice device) {
    }
    
    public final void setDeviceAlias(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String alias) {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device) {
    }
    
    public final void toggleHidden(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device) {
    }
    
    public final void setThreatLevel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.ThreatLevel threat) {
    }
    
    public final void deleteDevice(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device) {
    }
    
    public final void addNote(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull
    java.lang.String content) {
    }
    
    public final void deleteNote(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceNote note) {
    }
    
    public final void cleanupOldSightings(int days) {
    }
}