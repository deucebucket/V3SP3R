package com.vesper.flipper.voice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import kotlinx.coroutines.flow.StateFlow;
import java.util.Locale;

/**
 * Helper class for speech-to-text functionality.
 * Wraps Android's SpeechRecognizer API for voice input.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/vesper/flipper/voice/SpeechRecognitionHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_partialResult", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_state", "Lcom/vesper/flipper/voice/SpeechState;", "partialResult", "Lkotlinx/coroutines/flow/StateFlow;", "getPartialResult", "()Lkotlinx/coroutines/flow/StateFlow;", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "state", "getState", "cancel", "", "createListener", "Landroid/speech/RecognitionListener;", "destroy", "isAvailable", "", "startListening", "stopListening", "app_debug"})
public final class SpeechRecognitionHelper {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private android.speech.SpeechRecognizer speechRecognizer;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.voice.SpeechState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.voice.SpeechState> state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _partialResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> partialResult = null;
    
    public SpeechRecognitionHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.voice.SpeechState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPartialResult() {
        return null;
    }
    
    /**
     * Check if speech recognition is available on this device
     */
    public final boolean isAvailable() {
        return false;
    }
    
    /**
     * Start listening for speech input
     */
    public final void startListening() {
    }
    
    /**
     * Stop listening and clean up
     */
    public final void stopListening() {
    }
    
    /**
     * Cancel current recognition without processing
     */
    public final void cancel() {
    }
    
    private final android.speech.RecognitionListener createListener() {
        return null;
    }
    
    /**
     * Clean up resources - call when done
     */
    public final void destroy() {
    }
}