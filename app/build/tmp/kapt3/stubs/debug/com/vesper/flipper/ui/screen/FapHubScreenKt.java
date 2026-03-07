package com.vesper.flipper.ui.screen;

import androidx.compose.animation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.ui.viewmodel.FapHubViewModel;
import com.vesper.flipper.ui.viewmodel.SortOption;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u001aD\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u001a&\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u001a\u0012\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007\u001a6\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u001a\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003\u001a\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002\u001a\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002\u00a2\u0006\u0002\u0010#\u00a8\u0006$"}, d2 = {"AppDetailSheet", "", "app", "Lcom/vesper/flipper/domain/model/FapApp;", "installStatus", "Lcom/vesper/flipper/domain/model/InstallStatus;", "onInstall", "Lkotlin/Function0;", "onUninstall", "onDismiss", "FapAppCard", "onClick", "FapHubHeader", "appCount", "", "installedCount", "onRefresh", "FapHubScreen", "viewModel", "Lcom/vesper/flipper/ui/viewmodel/FapHubViewModel;", "InstallButton", "isInstalled", "", "status", "StatItem", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "value", "", "formatDownloads", "count", "getCategoryColor", "Landroidx/compose/ui/graphics/Color;", "category", "Lcom/vesper/flipper/domain/model/FapCategory;", "(Lcom/vesper/flipper/domain/model/FapCategory;)J", "app_debug"})
public final class FapHubScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void FapHubScreen(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.FapHubViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void FapHubHeader(int appCount, int installedCount, kotlin.jvm.functions.Function0<kotlin.Unit> onRefresh) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void FapAppCard(com.vesper.flipper.domain.model.FapApp app, com.vesper.flipper.domain.model.InstallStatus installStatus, kotlin.jvm.functions.Function0<kotlin.Unit> onInstall, kotlin.jvm.functions.Function0<kotlin.Unit> onUninstall, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void InstallButton(boolean isInstalled, com.vesper.flipper.domain.model.InstallStatus status, kotlin.jvm.functions.Function0<kotlin.Unit> onInstall, kotlin.jvm.functions.Function0<kotlin.Unit> onUninstall) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    private static final void AppDetailSheet(com.vesper.flipper.domain.model.FapApp app, com.vesper.flipper.domain.model.InstallStatus installStatus, kotlin.jvm.functions.Function0<kotlin.Unit> onInstall, kotlin.jvm.functions.Function0<kotlin.Unit> onUninstall, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void StatItem(androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String value) {
    }
    
    private static final long getCategoryColor(com.vesper.flipper.domain.model.FapCategory category) {
        return 0L;
    }
    
    private static final java.lang.String formatDownloads(int count) {
        return null;
    }
}