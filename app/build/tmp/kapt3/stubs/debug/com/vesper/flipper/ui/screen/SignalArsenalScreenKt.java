package com.vesper.flipper.ui.screen;

import androidx.compose.animation.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.*;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.ui.theme.*;
import com.vesper.flipper.ui.viewmodel.SignalArsenalViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0003\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0003\u001a\u0012\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001aJ\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0006H\u0003\u001aH\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0003\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0003\u001a8\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!0 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010#H\u0003\u001a\u001a\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0003\u00a8\u0006%"}, d2 = {"DetailRow", "", "label", "", "value", "mono", "", "EmptySignalsPlaceholder", "type", "Lcom/vesper/flipper/domain/model/SignalType;", "SignalArsenalScreen", "viewModel", "Lcom/vesper/flipper/ui/viewmodel/SignalArsenalViewModel;", "SignalCard", "signal", "Lcom/vesper/flipper/domain/model/SignalCapture;", "isSelected", "onClick", "Lkotlin/Function0;", "onReplay", "onDelete", "isReplaying", "SignalDetailPanel", "waveformData", "Lcom/vesper/flipper/domain/model/WaveformData;", "onClose", "modifier", "Landroidx/compose/ui/Modifier;", "SignalDetails", "SignalTypeTabs", "selectedType", "signalCounts", "", "", "onTypeSelected", "Lkotlin/Function1;", "WaveformView", "app_debug"})
@kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
public final class SignalArsenalScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void SignalArsenalScreen(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.SignalArsenalViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void SignalTypeTabs(com.vesper.flipper.domain.model.SignalType selectedType, java.util.Map<com.vesper.flipper.domain.model.SignalType, java.lang.Integer> signalCounts, kotlin.jvm.functions.Function1<? super com.vesper.flipper.domain.model.SignalType, kotlin.Unit> onTypeSelected) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable
    private static final void SignalCard(com.vesper.flipper.domain.model.SignalCapture signal, boolean isSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, kotlin.jvm.functions.Function0<kotlin.Unit> onReplay, kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, boolean isReplaying) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void SignalDetailPanel(com.vesper.flipper.domain.model.SignalCapture signal, com.vesper.flipper.domain.model.WaveformData waveformData, boolean isReplaying, kotlin.jvm.functions.Function0<kotlin.Unit> onReplay, kotlin.jvm.functions.Function0<kotlin.Unit> onClose, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void SignalDetails(com.vesper.flipper.domain.model.SignalCapture signal) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void DetailRow(java.lang.String label, java.lang.String value, boolean mono) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void WaveformView(com.vesper.flipper.domain.model.WaveformData waveformData, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void EmptySignalsPlaceholder(com.vesper.flipper.domain.model.SignalType type) {
    }
}