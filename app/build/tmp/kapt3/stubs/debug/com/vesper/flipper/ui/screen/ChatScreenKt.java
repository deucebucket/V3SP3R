package com.vesper.flipper.ui.screen;

import android.Manifest;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import coil.request.ImageRequest;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.ui.theme.*;
import com.vesper.flipper.ui.viewmodel.ChatViewModel;
import com.vesper.flipper.voice.SpeechState;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u00a6\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0012H\u0003\u001a\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0003\u001at\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0007\u001a\b\u0010%\u001a\u00020\u0003H\u0003\u001a\u001e\u0010&\u001a\u00020\u00032\u0006\u0010\'\u001a\u00020\u000f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0003\u001a\u0012\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010+H\u0003\u001a\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0005H\u0003\u001a\u0010\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H\u0003\u001a\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0003\u001a&\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00052\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0003\u001a\u0010\u00108\u001a\u0002092\u0006\u00102\u001a\u000203H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"toolResultJson", "Lkotlinx/serialization/json/Json;", "ChatInputBar", "", "value", "", "onValueChange", "Lkotlin/Function1;", "onSend", "Lkotlin/Function0;", "onAttachImage", "onVoiceInput", "onStopVoice", "pendingImages", "", "Lcom/vesper/flipper/domain/model/ImageAttachment;", "onRemoveImage", "isLoading", "", "isProcessingImage", "voiceState", "Lcom/vesper/flipper/voice/SpeechState;", "voicePartialResult", "enabled", "ChatMessageItem", "message", "Lcom/vesper/flipper/domain/model/ChatMessage;", "ChatScreen", "viewModel", "Lcom/vesper/flipper/ui/viewmodel/ChatViewModel;", "onNavigateToDevice", "onNavigateToSettings", "onNavigateToOracle", "onNavigateToArsenal", "onNavigateToFiles", "onNavigateToPayloadLab", "onNavigateToAudit", "EmptyChat", "ImagePreviewChip", "image", "onRemove", "LoadingIndicator", "progress", "Lcom/vesper/flipper/domain/model/AgentProgress;", "SuggestionChip", "text", "ToolCallDisplay", "toolCall", "Lcom/vesper/flipper/domain/model/ToolCall;", "ToolResultDisplay", "toolResult", "Lcom/vesper/flipper/domain/model/ToolResult;", "VoiceInputIndicator", "isListening", "partialResult", "onStop", "parseToolResult", "Lcom/vesper/flipper/ui/screen/ParsedToolResult;", "app_debug"})
public final class ChatScreenKt {
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.serialization.json.Json toolResultJson = null;
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void ChatScreen(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.ChatViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToDevice, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSettings, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToOracle, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToArsenal, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToFiles, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToPayloadLab, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAudit) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void EmptyChat() {
    }
    
    @androidx.compose.runtime.Composable
    private static final void SuggestionChip(java.lang.String text) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ChatMessageItem(com.vesper.flipper.domain.model.ChatMessage message) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ToolCallDisplay(com.vesper.flipper.domain.model.ToolCall toolCall) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void LoadingIndicator(com.vesper.flipper.domain.model.AgentProgress progress) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ToolResultDisplay(com.vesper.flipper.domain.model.ToolResult toolResult) {
    }
    
    private static final com.vesper.flipper.ui.screen.ParsedToolResult parseToolResult(com.vesper.flipper.domain.model.ToolResult toolResult) {
        return null;
    }
    
    @androidx.compose.runtime.Composable
    private static final void ChatInputBar(java.lang.String value, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, kotlin.jvm.functions.Function0<kotlin.Unit> onSend, kotlin.jvm.functions.Function0<kotlin.Unit> onAttachImage, kotlin.jvm.functions.Function0<kotlin.Unit> onVoiceInput, kotlin.jvm.functions.Function0<kotlin.Unit> onStopVoice, java.util.List<com.vesper.flipper.domain.model.ImageAttachment> pendingImages, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onRemoveImage, boolean isLoading, boolean isProcessingImage, com.vesper.flipper.voice.SpeechState voiceState, java.lang.String voicePartialResult, boolean enabled) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void VoiceInputIndicator(boolean isListening, java.lang.String partialResult, kotlin.jvm.functions.Function0<kotlin.Unit> onStop) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void ImagePreviewChip(com.vesper.flipper.domain.model.ImageAttachment image, kotlin.jvm.functions.Function0<kotlin.Unit> onRemove) {
    }
}