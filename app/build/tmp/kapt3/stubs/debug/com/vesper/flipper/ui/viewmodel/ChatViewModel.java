package com.vesper.flipper.ui.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ai.VesperAgent;
import com.vesper.flipper.ble.ConnectionState;
import com.vesper.flipper.ble.FlipperBleService;
import com.vesper.flipper.ble.FlipperDevice;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.voice.SpeechRecognitionHelper;
import com.vesper.flipper.voice.SpeechState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.*;
import java.io.ByteArrayOutputStream;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'J\u0012\u0010(\u001a\u00020%2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\tJ\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020%J\u0006\u0010-\u001a\u00020%J\u0006\u0010.\u001a\u00020\u000bJ\b\u0010/\u001a\u00020%H\u0014J\u0018\u00100\u001a\u0004\u0018\u00010\u000e2\u0006\u0010&\u001a\u00020\'H\u0082@\u00a2\u0006\u0002\u00101J\u0012\u00102\u001a\u00020%2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\tJ\u000e\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\tJ\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000209H\u0002J\u0006\u0010:\u001a\u00020%J\u0012\u0010;\u001a\u00020%2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\tJ\u0006\u0010=\u001a\u00020%J\u0006\u0010>\u001a\u00020%J\u000e\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015\u00a8\u0006B"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "vesperAgent", "Lcom/vesper/flipper/ai/VesperAgent;", "context", "Landroid/content/Context;", "(Lcom/vesper/flipper/ai/VesperAgent;Landroid/content/Context;)V", "_inputText", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isProcessingImage", "", "_pendingImages", "", "Lcom/vesper/flipper/domain/model/ImageAttachment;", "_voiceError", "approvalDecisionInFlight", "conversationState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/vesper/flipper/domain/model/ConversationState;", "getConversationState", "()Lkotlinx/coroutines/flow/StateFlow;", "inputText", "getInputText", "isProcessingImage", "pendingImages", "getPendingImages", "speechRecognitionHelper", "Lcom/vesper/flipper/voice/SpeechRecognitionHelper;", "voiceError", "getVoiceError", "voicePartialResult", "getVoicePartialResult", "voiceState", "Lcom/vesper/flipper/voice/SpeechState;", "getVoiceState", "addImage", "", "uri", "Landroid/net/Uri;", "approveAction", "approvalId", "cancelVoiceInput", "clearConversation", "clearPendingImages", "clearVoiceError", "isVoiceInputAvailable", "onCleared", "processImageUri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rejectAction", "removeImage", "imageId", "scaleBitmap", "Landroid/graphics/Bitmap;", "bitmap", "maxSize", "", "sendMessage", "startNewSession", "deviceName", "startVoiceInput", "stopVoiceInput", "updateInput", "text", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ChatViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ai.VesperAgent vesperAgent = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.ConversationState> conversationState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _inputText = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> inputText = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.domain.model.ImageAttachment>> _pendingImages = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.ImageAttachment>> pendingImages = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isProcessingImage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isProcessingImage = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.voice.SpeechRecognitionHelper speechRecognitionHelper = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.voice.SpeechState> voiceState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> voicePartialResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _voiceError = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> voiceError = null;
    private boolean approvalDecisionInFlight = false;
    private static final int MAX_IMAGE_SIZE = 1024;
    private static final int JPEG_QUALITY = 85;
    private static final int MAX_IMAGE_FILE_SIZE = 10485760;
    private static final int MAX_PENDING_IMAGES = 4;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ui.viewmodel.ChatViewModel.Companion Companion = null;
    
    @javax.inject.Inject
    public ChatViewModel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.VesperAgent vesperAgent, @dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.domain.model.ConversationState> getConversationState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getInputText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.ImageAttachment>> getPendingImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isProcessingImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.voice.SpeechState> getVoiceState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getVoicePartialResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getVoiceError() {
        return null;
    }
    
    /**
     * Check if voice input is available on this device
     */
    public final boolean isVoiceInputAvailable() {
        return false;
    }
    
    /**
     * Start voice input
     */
    public final void startVoiceInput() {
    }
    
    /**
     * Stop voice input
     */
    public final void stopVoiceInput() {
    }
    
    /**
     * Cancel voice input without using the result
     */
    public final void cancelVoiceInput() {
    }
    
    /**
     * Clear voice error
     */
    public final void clearVoiceError() {
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
    
    public final void updateInput(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    /**
     * Add an image from URI (gallery or camera)
     * Enforces maximum pending image limit to prevent memory issues.
     */
    public final void addImage(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    /**
     * Remove a pending image
     */
    public final void removeImage(@org.jetbrains.annotations.NotNull
    java.lang.String imageId) {
    }
    
    /**
     * Clear all pending images
     */
    public final void clearPendingImages() {
    }
    
    /**
     * Process an image URI to create an ImageAttachment.
     * Includes proper memory management with bitmap recycling.
     */
    private final java.lang.Object processImageUri(android.net.Uri uri, kotlin.coroutines.Continuation<? super com.vesper.flipper.domain.model.ImageAttachment> $completion) {
        return null;
    }
    
    private final android.graphics.Bitmap scaleBitmap(android.graphics.Bitmap bitmap, int maxSize) {
        return null;
    }
    
    public final void sendMessage() {
    }
    
    public final void approveAction(@org.jetbrains.annotations.Nullable
    java.lang.String approvalId) {
    }
    
    public final void rejectAction(@org.jetbrains.annotations.Nullable
    java.lang.String approvalId) {
    }
    
    public final void clearConversation() {
    }
    
    public final void startNewSession(@org.jetbrains.annotations.Nullable
    java.lang.String deviceName) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/ChatViewModel$Companion;", "", "()V", "JPEG_QUALITY", "", "MAX_IMAGE_FILE_SIZE", "MAX_IMAGE_SIZE", "MAX_PENDING_IMAGES", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}