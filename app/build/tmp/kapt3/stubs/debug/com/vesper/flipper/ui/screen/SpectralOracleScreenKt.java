package com.vesper.flipper.ui.screen;

import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.*;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.ui.theme.*;
import com.vesper.flipper.ui.viewmodel.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a$\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\fH\u0003\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0003\u001a.\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0003\u001a\b\u0010\u0018\u001a\u00020\u0001H\u0003\u001a\u0012\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a\u0012\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0003\u001a\u001e\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a.\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00152\u001c\u0010#\u001a\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\f\u00a2\u0006\u0002\b%\u00a2\u0006\u0002\b&H\u0003\u001aP\u0010\'\u001a\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\b\u0010+\u001a\u0004\u0018\u00010*2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00010\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a \u0010.\u001a\u00020\u00012\b\u0010+\u001a\u0004\u0018\u00010*2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u0012\u0010/\u001a\u00020\u00012\b\b\u0002\u00100\u001a\u000201H\u0007\u001a\u0018\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0003\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u000209H\u0003\u001a\u0010\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0002\u00a8\u0006="}, d2 = {"AnalysisResultView", "", "result", "Lcom/vesper/flipper/ui/viewmodel/OracleAnalysisResult;", "onShowRaw", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "AnalysisTypeSelector", "selectedType", "Lcom/vesper/flipper/domain/model/AnalysisType;", "onTypeSelected", "Lkotlin/Function1;", "ExploitItem", "exploit", "Lcom/vesper/flipper/ui/viewmodel/ExploitItem;", "OracleAnalyzeButton", "enabled", "", "isAnalyzing", "progress", "", "onClick", "OracleBackground", "OracleHeader", "OracleIdleState", "OracleLoadingAnimation", "ProtocolInfoChip", "label", "value", "RawResponseDialog", "response", "onDismiss", "ResultSection", "title", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SignalPickerDialog", "signals", "", "Lcom/vesper/flipper/domain/model/SignalCapture;", "selectedSignal", "onSelect", "onRefresh", "SignalSelector", "SpectralOracleScreen", "viewModel", "Lcom/vesper/flipper/ui/viewmodel/SpectralOracleViewModel;", "ThreatLevelCard", "threatLevel", "Lcom/vesper/flipper/domain/model/OracleRiskLevel;", "protocolInfo", "Lcom/vesper/flipper/ui/viewmodel/ProtocolInfo;", "VulnerabilityItem", "vuln", "Lcom/vesper/flipper/ui/viewmodel/VulnItem;", "formatFrequency", "hz", "", "app_debug"})
@kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
public final class SpectralOracleScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void SpectralOracleScreen(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.SpectralOracleViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void OracleBackground(boolean isAnalyzing) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void OracleHeader() {
    }
    
    @androidx.compose.runtime.Composable
    private static final void SignalSelector(com.vesper.flipper.domain.model.SignalCapture selectedSignal, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.layout.ExperimentalLayoutApi.class})
    @androidx.compose.runtime.Composable
    private static final void AnalysisTypeSelector(com.vesper.flipper.domain.model.AnalysisType selectedType, kotlin.jvm.functions.Function1<? super com.vesper.flipper.domain.model.AnalysisType, kotlin.Unit> onTypeSelected) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void OracleAnalyzeButton(boolean enabled, boolean isAnalyzing, java.lang.String progress, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void OracleLoadingAnimation(androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void OracleIdleState(androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void AnalysisResultView(com.vesper.flipper.ui.viewmodel.OracleAnalysisResult result, kotlin.jvm.functions.Function0<kotlin.Unit> onShowRaw, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ThreatLevelCard(com.vesper.flipper.domain.model.OracleRiskLevel threatLevel, com.vesper.flipper.ui.viewmodel.ProtocolInfo protocolInfo) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ProtocolInfoChip(java.lang.String label, java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ResultSection(java.lang.String title, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.ColumnScope, kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void VulnerabilityItem(com.vesper.flipper.ui.viewmodel.VulnItem vuln) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ExploitItem(com.vesper.flipper.ui.viewmodel.ExploitItem exploit) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void SignalPickerDialog(java.util.List<? extends com.vesper.flipper.domain.model.SignalCapture> signals, com.vesper.flipper.domain.model.SignalCapture selectedSignal, kotlin.jvm.functions.Function1<? super com.vesper.flipper.domain.model.SignalCapture, kotlin.Unit> onSelect, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function0<kotlin.Unit> onRefresh) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void RawResponseDialog(java.lang.String response, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    private static final java.lang.String formatFrequency(long hz) {
        return null;
    }
}