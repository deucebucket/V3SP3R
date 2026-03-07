package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.FileEntry;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/FileBrowserViewModel;", "Landroidx/lifecycle/ViewModel;", "fileSystem", "Lcom/vesper/flipper/ble/FlipperFileSystem;", "(Lcom/vesper/flipper/ble/FlipperFileSystem;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/ui/viewmodel/FileBrowserState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearSelection", "", "loadDirectory", "path", "", "navigateBack", "", "navigateToPath", "navigateUp", "onEntryClick", "entry", "Lcom/vesper/flipper/domain/model/FileEntry;", "refresh", "selectFile", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class FileBrowserViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperFileSystem fileSystem = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ui.viewmodel.FileBrowserState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.FileBrowserState> state = null;
    
    @javax.inject.Inject
    public FileBrowserViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperFileSystem fileSystem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.FileBrowserState> getState() {
        return null;
    }
    
    public final void loadDirectory(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
    }
    
    public final boolean navigateUp() {
        return false;
    }
    
    public final boolean navigateBack() {
        return false;
    }
    
    public final void onEntryClick(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.FileEntry entry) {
    }
    
    private final void selectFile(com.vesper.flipper.domain.model.FileEntry entry) {
    }
    
    public final void clearSelection() {
    }
    
    public final void refresh() {
    }
    
    public final void navigateToPath(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
    }
}