package com.vesper.flipper.ui.components;

import androidx.compose.foundation.layout.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.vesper.flipper.domain.model.FileDiff;
import com.vesper.flipper.domain.service.DiffLine;
import com.vesper.flipper.domain.service.DiffLineType;
import com.vesper.flipper.domain.service.DiffService;
import com.vesper.flipper.ui.theme.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0003\u001a\u001a\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\"\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u001a\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0013"}, d2 = {"DiffLineRow", "", "line", "Lcom/vesper/flipper/domain/service/DiffLine;", "DiffStatsHeader", "diff", "Lcom/vesper/flipper/domain/model/FileDiff;", "DiffViewer", "modifier", "Landroidx/compose/ui/Modifier;", "StatBadge", "text", "", "color", "Landroidx/compose/ui/graphics/Color;", "StatBadge-4WTKRHQ", "(Ljava/lang/String;J)V", "UnifiedDiffViewer", "unifiedDiff", "app_debug"})
public final class DiffViewerKt {
    
    @androidx.compose.runtime.Composable
    public static final void DiffViewer(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.FileDiff diff, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void UnifiedDiffViewer(@org.jetbrains.annotations.NotNull
    java.lang.String unifiedDiff, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void DiffStatsHeader(com.vesper.flipper.domain.model.FileDiff diff) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void DiffLineRow(com.vesper.flipper.domain.service.DiffLine line) {
    }
}