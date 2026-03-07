package com.vesper.flipper.ui.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ai.*;
import com.vesper.flipper.domain.model.*;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.*;
import java.io.ByteArrayOutputStream;
import javax.inject.Inject;
import com.vesper.flipper.ai.ToolResult;

/**
 * PayloadLabViewModel - 3-Step AI Payload Generation
 *
 * Orchestrates the optimal workflow:
 * 1. GENERATE - Create initial payload with detailed prompting
 * 2. VALIDATE - Syntax check, security review, optimization
 * 3. EXECUTE  - Save to Flipper, search web, execute commands
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010a\u001a\u00020bJ\u0006\u0010c\u001a\u00020bJ\u0006\u0010d\u001a\u00020bJ\u0006\u0010e\u001a\u00020bJ\u0006\u0010f\u001a\u00020bJ\u0016\u0010g\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010iJ\u000e\u0010j\u001a\u00020b2\u0006\u0010k\u001a\u00020+J\u000e\u0010l\u001a\u00020b2\u0006\u0010m\u001a\u00020\u000eJ\u000e\u0010n\u001a\u00020b2\u0006\u0010k\u001a\u00020+J\u000e\u0010o\u001a\u00020b2\u0006\u0010p\u001a\u00020)J\u0006\u0010q\u001a\u00020bJ\u0006\u0010r\u001a\u00020bJ\u000e\u0010s\u001a\b\u0012\u0004\u0012\u00020+0(H\u0002J\u000e\u0010t\u001a\b\u0012\u0004\u0012\u00020+0(H\u0002J\u0010\u0010u\u001a\u00020b2\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010x\u001a\u00020b2\u0006\u0010y\u001a\u00020zH\u0002J\u000e\u0010{\u001a\u00020b2\u0006\u0010|\u001a\u000208J\u000e\u0010}\u001a\u00020b2\u0006\u0010|\u001a\u00020>J\u000e\u0010~\u001a\u00020b2\u0006\u0010\u007f\u001a\u00020\u000eJ\u0007\u0010\u0080\u0001\u001a\u00020bJ\u0007\u0010\u0081\u0001\u001a\u00020bJ\u0011\u0010\u0082\u0001\u001a\u00020b2\b\u0010h\u001a\u0004\u0018\u00010!J\u0011\u0010\u0083\u0001\u001a\u00020b2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\u0007\u0010\u0086\u0001\u001a\u00020bJ\u001d\u0010\u0087\u0001\u001a\u00020b2\u0007\u0010\u0088\u0001\u001a\u00020\u000e2\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u008a\u0001\u001a\u00020b2\u0007\u0010\u008b\u0001\u001a\u00020\u000eJ\u0010\u0010\u008c\u0001\u001a\u00020b2\u0007\u0010\u008d\u0001\u001a\u00020\u000bJ\u0010\u0010\u008e\u0001\u001a\u00020b2\u0007\u0010\u008f\u0001\u001a\u00020\u0011J\u0010\u0010\u0090\u0001\u001a\u00020b2\u0007\u0010\u0091\u0001\u001a\u00020\u000eJ\u0010\u0010\u0092\u0001\u001a\u00020b2\u0007\u0010\u0093\u0001\u001a\u00020\u000eJ\u0010\u0010\u0094\u0001\u001a\u00020b2\u0007\u0010\u0091\u0001\u001a\u00020\u000eJ\u0010\u0010\u0095\u0001\u001a\u00020b2\u0007\u0010\u0084\u0001\u001a\u00020#J\u0010\u0010\u0096\u0001\u001a\u00020b2\u0007\u0010\u0093\u0001\u001a\u00020\u000eR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0(0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0(0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0.\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R#\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0.\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110.\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00100R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00100R\u0017\u00107\u001a\b\u0012\u0004\u0012\u0002080(\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020>0(\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010:R\u0019\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00100R\u0019\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00100R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00170.\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u00100R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00190.\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00190.\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00100R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00190.\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00100R#\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0.\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u00100R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u00100R\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u0019\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0.\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u00100R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020#0.\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u00100R\u0019\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u00100R\u0019\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u00100R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000e0.\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u00100R\u001d\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0.\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u00100R\u001d\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0(0.\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u00100R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0(0.\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u00100\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/PayloadLabViewModel;", "Landroidx/lifecycle/ViewModel;", "payloadEngine", "Lcom/vesper/flipper/ai/PayloadEngine;", "toolExecutor", "Lcom/vesper/flipper/ai/FlipperToolExecutor;", "context", "Landroid/content/Context;", "(Lcom/vesper/flipper/ai/PayloadEngine;Lcom/vesper/flipper/ai/FlipperToolExecutor;Landroid/content/Context;)V", "_badUsbExecutionMode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/ai/ExecutionMode;", "_badUsbMetadata", "", "", "", "_badUsbPlatform", "Lcom/vesper/flipper/domain/model/BadUsbPlatform;", "_badUsbPrompt", "_error", "_generatedHtml", "_generatedScript", "_generationPhase", "Lcom/vesper/flipper/ui/viewmodel/GenerationPhase;", "_isExecuting", "", "_isGenerating", "_isSaving", "_phaseMessage", "_portalMetadata", "_portalName", "_portalPrompt", "_portalScreenshot", "Landroid/net/Uri;", "_portalType", "Lcom/vesper/flipper/ai/PortalType;", "_rawOutput", "_saveSuccess", "_scriptName", "_searchSuggestions", "", "Lcom/vesper/flipper/ai/SearchSuggestion;", "_suggestedActions", "Lcom/vesper/flipper/ai/SuggestedAction;", "_warnings", "badUsbExecutionMode", "Lkotlinx/coroutines/flow/StateFlow;", "getBadUsbExecutionMode", "()Lkotlinx/coroutines/flow/StateFlow;", "badUsbMetadata", "getBadUsbMetadata", "badUsbPlatform", "getBadUsbPlatform", "badUsbPrompt", "getBadUsbPrompt", "badUsbTemplates", "Lcom/vesper/flipper/domain/model/BadUsbPayload;", "getBadUsbTemplates", "()Ljava/util/List;", "error", "getError", "evilPortalTemplates", "Lcom/vesper/flipper/domain/model/EvilPortalPayload;", "getEvilPortalTemplates", "generatedHtml", "getGeneratedHtml", "generatedScript", "getGeneratedScript", "generationPhase", "getGenerationPhase", "isExecuting", "isGenerating", "isSaving", "phaseMessage", "getPhaseMessage", "portalMetadata", "getPortalMetadata", "portalName", "getPortalName", "portalPrompt", "getPortalPrompt", "portalScreenshot", "getPortalScreenshot", "portalType", "getPortalType", "rawOutput", "getRawOutput", "saveSuccess", "getSaveSuccess", "scriptName", "getScriptName", "searchSuggestions", "getSearchSuggestions", "suggestedActions", "getSuggestedActions", "warnings", "getWarnings", "clearBadUsbGenerated", "", "clearError", "clearPortalGenerated", "clearSuccess", "clearWarnings", "encodeScreenshot", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBadUsbAction", "action", "executeFlipperCommand", "command", "executePortalAction", "executeSearchSuggestion", "suggestion", "generateBadUsbScript", "generateEvilPortal", "getDefaultBadUsbActions", "getDefaultPortalActions", "handleProgress", "progress", "Lcom/vesper/flipper/ai/PayloadProgress;", "handleToolResult", "result", "Lcom/vesper/flipper/ai/ToolResult;", "loadBadUsbTemplate", "template", "loadEvilPortalTemplate", "openWebSearch", "query", "saveBadUsbScript", "saveEvilPortal", "setPortalScreenshot", "startBleSpam", "type", "Lcom/vesper/flipper/ai/BleSpamType;", "stopBleSpam", "transmitIr", "irPath", "signalName", "transmitSubGhz", "subPath", "updateBadUsbExecutionMode", "mode", "updateBadUsbPlatform", "platform", "updateBadUsbPrompt", "prompt", "updatePortalName", "name", "updatePortalPrompt", "updatePortalType", "updateScriptName", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PayloadLabViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ai.PayloadEngine payloadEngine = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ai.FlipperToolExecutor toolExecutor = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _badUsbPrompt = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> badUsbPrompt = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.domain.model.BadUsbPlatform> _badUsbPlatform = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.BadUsbPlatform> badUsbPlatform = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ai.ExecutionMode> _badUsbExecutionMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ai.ExecutionMode> badUsbExecutionMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _generatedScript = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> generatedScript = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _scriptName = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> scriptName = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.lang.Object>> _badUsbMetadata = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.Object>> badUsbMetadata = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<android.net.Uri> _portalScreenshot = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<android.net.Uri> portalScreenshot = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _portalPrompt = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> portalPrompt = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ai.PortalType> _portalType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ai.PortalType> portalType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _generatedHtml = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> generatedHtml = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _portalName = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> portalName = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.lang.Object>> _portalMetadata = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.Object>> portalMetadata = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ui.viewmodel.GenerationPhase> _generationPhase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.GenerationPhase> generationPhase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _phaseMessage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> phaseMessage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _rawOutput = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> rawOutput = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.ai.SuggestedAction>> _suggestedActions = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ai.SuggestedAction>> suggestedActions = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.ai.SearchSuggestion>> _searchSuggestions = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ai.SearchSuggestion>> searchSuggestions = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isGenerating = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isGenerating = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSaving = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSaving = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isExecuting = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isExecuting = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _warnings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> warnings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _saveSuccess = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> saveSuccess = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.domain.model.BadUsbPayload> badUsbTemplates = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.domain.model.EvilPortalPayload> evilPortalTemplates = null;
    
    @javax.inject.Inject
    public PayloadLabViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.PayloadEngine payloadEngine, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.FlipperToolExecutor toolExecutor, @dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getBadUsbPrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.BadUsbPlatform> getBadUsbPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ai.ExecutionMode> getBadUsbExecutionMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getGeneratedScript() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getScriptName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.Object>> getBadUsbMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<android.net.Uri> getPortalScreenshot() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPortalPrompt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ai.PortalType> getPortalType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getGeneratedHtml() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPortalName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.Object>> getPortalMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ui.viewmodel.GenerationPhase> getGenerationPhase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPhaseMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getRawOutput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ai.SuggestedAction>> getSuggestedActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ai.SearchSuggestion>> getSearchSuggestions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isGenerating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSaving() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isExecuting() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getWarnings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSaveSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.BadUsbPayload> getBadUsbTemplates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.EvilPortalPayload> getEvilPortalTemplates() {
        return null;
    }
    
    public final void updateBadUsbPrompt(@org.jetbrains.annotations.NotNull
    java.lang.String prompt) {
    }
    
    public final void updateBadUsbPlatform(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.BadUsbPlatform platform) {
    }
    
    public final void updateBadUsbExecutionMode(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.ExecutionMode mode) {
    }
    
    public final void updateScriptName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void loadBadUsbTemplate(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.BadUsbPayload template) {
    }
    
    /**
     * MAIN ENTRY: Generate BadUSB script with 3-step pipeline
     */
    public final void generateBadUsbScript() {
    }
    
    /**
     * Save BadUSB script to Flipper
     */
    public final void saveBadUsbScript() {
    }
    
    /**
     * Execute a suggested action for BadUSB
     */
    public final void executeBadUsbAction(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.SuggestedAction action) {
    }
    
    private final java.util.List<com.vesper.flipper.ai.SuggestedAction> getDefaultBadUsbActions() {
        return null;
    }
    
    public final void setPortalScreenshot(@org.jetbrains.annotations.Nullable
    android.net.Uri uri) {
    }
    
    public final void updatePortalPrompt(@org.jetbrains.annotations.NotNull
    java.lang.String prompt) {
    }
    
    public final void updatePortalType(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.PortalType type) {
    }
    
    public final void updatePortalName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void loadEvilPortalTemplate(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.EvilPortalPayload template) {
    }
    
    /**
     * MAIN ENTRY: Generate Evil Portal with 3-step pipeline
     */
    public final void generateEvilPortal() {
    }
    
    /**
     * Save Evil Portal to Flipper
     */
    public final void saveEvilPortal() {
    }
    
    /**
     * Execute a suggested action for Evil Portal
     */
    public final void executePortalAction(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.SuggestedAction action) {
    }
    
    private final java.util.List<com.vesper.flipper.ai.SuggestedAction> getDefaultPortalActions() {
        return null;
    }
    
    private final java.lang.Object encodeScreenshot(android.net.Uri uri, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    /**
     * Execute IR transmission
     */
    public final void transmitIr(@org.jetbrains.annotations.NotNull
    java.lang.String irPath, @org.jetbrains.annotations.Nullable
    java.lang.String signalName) {
    }
    
    /**
     * Execute Sub-GHz transmission
     */
    public final void transmitSubGhz(@org.jetbrains.annotations.NotNull
    java.lang.String subPath) {
    }
    
    /**
     * Start BLE spam attack
     */
    public final void startBleSpam(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.BleSpamType type) {
    }
    
    /**
     * Stop BLE spam
     */
    public final void stopBleSpam() {
    }
    
    /**
     * Execute raw Flipper command
     */
    public final void executeFlipperCommand(@org.jetbrains.annotations.NotNull
    java.lang.String command) {
    }
    
    public final void openWebSearch(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void executeSearchSuggestion(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.SearchSuggestion suggestion) {
    }
    
    private final void handleProgress(com.vesper.flipper.ai.PayloadProgress progress) {
    }
    
    private final void handleToolResult(com.vesper.flipper.ai.ToolResult result) {
    }
    
    public final void clearError() {
    }
    
    public final void clearSuccess() {
    }
    
    public final void clearWarnings() {
    }
    
    public final void clearBadUsbGenerated() {
    }
    
    public final void clearPortalGenerated() {
    }
}