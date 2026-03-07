package com.vesper.flipper.ui.screen;

import androidx.compose.animation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.vesper.flipper.domain.model.FileEntry;
import com.vesper.flipper.ui.theme.*;
import com.vesper.flipper.ui.viewmodel.FileBrowserViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a&\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0003\u001a0\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003\u001a\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"FileBrowserScreen", "", "viewModel", "Lcom/vesper/flipper/ui/viewmodel/FileBrowserViewModel;", "FileEntryItem", "entry", "Lcom/vesper/flipper/domain/model/FileEntry;", "onClick", "Lkotlin/Function0;", "isSelected", "", "FilePreviewSheet", "file", "content", "", "isLoading", "onDismiss", "formatFileSize", "bytes", "", "getFileIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getFileIconColor", "Landroidx/compose/ui/graphics/Color;", "(Lcom/vesper/flipper/domain/model/FileEntry;)J", "app_debug"})
public final class FileBrowserScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void FileBrowserScreen(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.FileBrowserViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void FileEntryItem(com.vesper.flipper.domain.model.FileEntry entry, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, boolean isSelected) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    private static final void FilePreviewSheet(com.vesper.flipper.domain.model.FileEntry file, java.lang.String content, boolean isLoading, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    private static final androidx.compose.ui.graphics.vector.ImageVector getFileIcon(com.vesper.flipper.domain.model.FileEntry entry) {
        return null;
    }
    
    private static final long getFileIconColor(com.vesper.flipper.domain.model.FileEntry entry) {
        return 0L;
    }
    
    private static final java.lang.String formatFileSize(long bytes) {
        return null;
    }
}