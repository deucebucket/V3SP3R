package com.vesper.flipper.ble;

import com.flipperdevices.protobuf.screen.Gui;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.security.SecurityUtils;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * High-level file system operations for Flipper Zero.
 * Wraps the protocol layer with type-safe operations.
 * Includes security validation for all paths.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 w2\u00020\u0001:\u0002vwB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J,\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010!\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J.\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020\'H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b(\u0010)J$\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010!\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b+\u0010#J$\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\u0006\u0010-\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b.\u0010#J\u0016\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020\u001cH\u0082@\u00a2\u0006\u0002\u0010#J\u0016\u00101\u001a\u00020\'2\u0006\u0010!\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010#J\u001c\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b4\u00105J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b8\u00105J\u0010\u00109\u001a\u00020\'2\u0006\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010;\u001a\u00020\'2\u0006\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010<\u001a\u00020\'2\u0006\u0010:\u001a\u00020\u001cH\u0002J*\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>0\u00192\u0006\u0010!\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b@\u0010#J,\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bB\u0010\u001fJ\u0017\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020\u001cH\u0002\u00a2\u0006\u0002\u0010FJ\u0017\u0010G\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020\u001cH\u0002\u00a2\u0006\u0002\u0010FJ\u0010\u0010H\u001a\u0002032\u0006\u0010E\u001a\u00020\u001cH\u0002J\u001e\u0010I\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010E\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u001cH\u0002J\u0010\u0010K\u001a\u0002072\u0006\u0010E\u001a\u00020\u001cH\u0002J#\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\u0006\u0010M\u001a\u000200H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bN\u0010OJ$\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\u0006\u0010!\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bQ\u0010#J$\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00192\u0006\u0010!\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bT\u0010#J\"\u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u00172\u0006\u0010W\u001a\u00020\'2\b\u0010X\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010Y\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001cH\u0002J,\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010[\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\\\u0010\u001fJ\u0016\u0010]\u001a\u0002002\u0006\u0010-\u001a\u00020\u001cH\u0082@\u00a2\u0006\u0002\u0010#J.\u0010^\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\u0006\u0010_\u001a\u00020`2\b\b\u0002\u0010a\u001a\u00020\'H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bb\u0010cJ\u0018\u0010d\u001a\u00020\'2\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0002J\u0010\u0010e\u001a\u00020\'2\u0006\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010f\u001a\u00020\'2\u0006\u0010-\u001a\u00020\u001cH\u0002J\u0010\u0010g\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0002J,\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bi\u0010\u001fJ,\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020SH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bk\u0010lJ\u001e\u0010m\u001a\u0002002\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020SH\u0082@\u00a2\u0006\u0002\u0010lJ\f\u0010n\u001a\u00020\u001c*\u00020\u001cH\u0002J\f\u0010o\u001a\u00020p*\u00020`H\u0002J0\u0010q\u001a\u000200*\u0002002\u001c\u0010r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002000t\u0012\u0006\u0012\u0004\u0018\u00010\u00010sH\u0082@\u00a2\u0006\u0002\u0010uR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006x"}, d2 = {"Lcom/vesper/flipper/ble/FlipperFileSystem;", "", "protocol", "Lcom/vesper/flipper/ble/FlipperProtocol;", "securityUtils", "Lcom/vesper/flipper/security/SecurityUtils;", "(Lcom/vesper/flipper/ble/FlipperProtocol;Lcom/vesper/flipper/security/SecurityUtils;)V", "_autotuneStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/ble/CommandPipelineAutotuneStatus;", "autotuneLock", "autotuneStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getAutotuneStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "autotuneWindow", "Lkotlin/collections/ArrayDeque;", "Lcom/vesper/flipper/ble/FlipperFileSystem$AutotuneSample;", "firmwareCompatibility", "Lcom/vesper/flipper/ble/FirmwareCompatibilityProfile;", "getFirmwareCompatibility", "computeAutotuneStatusLocked", "nowMs", "", "copy", "Lkotlin/Result;", "", "sourcePath", "", "destPath", "copy-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDirectory", "path", "createDirectory-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultAutotuneStatus", "delete", "recursive", "", "delete-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFile", "deleteFile-gIAlu-s", "executeCli", "command", "executeCli-gIAlu-s", "executeRpcAppCommandWithRetry", "Lcom/vesper/flipper/ble/ProtocolResponse;", "exists", "getDeviceInfo", "Lcom/vesper/flipper/domain/model/DeviceInfo;", "getDeviceInfo-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStorageInfo", "Lcom/vesper/flipper/domain/model/StorageInfo;", "getStorageInfo-IoAF18A", "isDisconnectLikeFailure", "message", "isPipelineBusy", "isTransientWriteFailure", "listDirectory", "", "Lcom/vesper/flipper/domain/model/FileEntry;", "listDirectory-gIAlu-s", "move", "move-0E7RQCE", "parseCliBatteryPercent", "", "content", "(Ljava/lang/String;)Ljava/lang/Integer;", "parseCliBatteryPercentFromVoltage", "parseCliDeviceInfo", "parseCliDirectoryListing", "basePath", "parseCliStorageInfo", "protocolResponseToStringResult", "response", "protocolResponseToStringResult-IoAF18A", "(Lcom/vesper/flipper/ble/ProtocolResponse;)Ljava/lang/Object;", "readFile", "readFile-gIAlu-s", "readFileBytes", "", "readFileBytes-gIAlu-s", "recordOperationSample", "latencyMs", "success", "errorMessage", "recordRetrySignal", "rename", "newName", "rename-0E7RQCE", "sendCliCommandWithRetry", "sendRemoteButton", "button", "Lcom/vesper/flipper/domain/model/FlipperRemoteButton;", "longPress", "sendRemoteButton-0E7RQCE", "(Lcom/vesper/flipper/domain/model/FlipperRemoteButton;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldRetryViaRpcBridge", "shouldUseCliFallback", "shouldUseRpcAppBridge", "validateCliCommand", "writeFile", "writeFile-0E7RQCE", "writeFileBytes", "writeFileBytes-0E7RQCE", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFileWithRetry", "normalizePath", "toGuiInputKey", "Lcom/flipperdevices/protobuf/screen/Gui$InputKey;", "withCliFallback", "fallback", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lcom/vesper/flipper/ble/ProtocolResponse;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AutotuneSample", "Companion", "app_debug"})
public final class FlipperFileSystem {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperProtocol protocol = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.security.SecurityUtils securityUtils = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.CommandPipelineAutotuneStatus> _autotuneStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CommandPipelineAutotuneStatus> autotuneStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.collections.ArrayDeque<com.vesper.flipper.ble.FlipperFileSystem.AutotuneSample> autotuneWindow = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object autotuneLock = null;
    private static final int MAX_CLI_COMMAND_LENGTH = 512;
    private static final long CLI_STATUS_RETRY_MS = 5000L;
    private static final int AUTOTUNE_WINDOW_SIZE = 36;
    private static final int BATTERY_MIN_MV = 3300;
    private static final int BATTERY_MAX_MV = 4200;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ble.FlipperFileSystem.Companion Companion = null;
    
    @javax.inject.Inject
    public FlipperFileSystem(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperProtocol protocol, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.security.SecurityUtils securityUtils) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FirmwareCompatibilityProfile> getFirmwareCompatibility() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CommandPipelineAutotuneStatus> getAutotuneStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object exists(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.String normalizePath(java.lang.String $this$normalizePath) {
        return null;
    }
    
    private final java.lang.String validateCliCommand(java.lang.String command) {
        return null;
    }
    
    private final boolean shouldUseRpcAppBridge(java.lang.String command) {
        return false;
    }
    
    private final boolean shouldRetryViaRpcBridge(java.lang.String message, java.lang.String command) {
        return false;
    }
    
    private final boolean isPipelineBusy(java.lang.String message) {
        return false;
    }
    
    private final java.lang.Object executeRpcAppCommandWithRetry(java.lang.String command, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendCliCommandWithRetry(java.lang.String command, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object writeFileWithRetry(java.lang.String path, byte[] content, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final boolean isTransientWriteFailure(java.lang.String message) {
        return false;
    }
    
    private final void recordRetrySignal(java.lang.String message) {
    }
    
    private final void recordOperationSample(long latencyMs, boolean success, java.lang.String errorMessage) {
    }
    
    private final com.vesper.flipper.ble.CommandPipelineAutotuneStatus computeAutotuneStatusLocked(long nowMs) {
        return null;
    }
    
    private final com.vesper.flipper.ble.CommandPipelineAutotuneStatus defaultAutotuneStatus(long nowMs) {
        return null;
    }
    
    private final boolean isDisconnectLikeFailure(java.lang.String message) {
        return false;
    }
    
    private final com.flipperdevices.protobuf.screen.Gui.InputKey toGuiInputKey(com.vesper.flipper.domain.model.FlipperRemoteButton $this$toGuiInputKey) {
        return null;
    }
    
    private final java.lang.Object withCliFallback(com.vesper.flipper.ble.ProtocolResponse $this$withCliFallback, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse>, ? extends java.lang.Object> fallback, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final boolean shouldUseCliFallback(java.lang.String message) {
        return false;
    }
    
    private final java.util.List<com.vesper.flipper.domain.model.FileEntry> parseCliDirectoryListing(java.lang.String content, java.lang.String basePath) {
        return null;
    }
    
    private final com.vesper.flipper.domain.model.DeviceInfo parseCliDeviceInfo(java.lang.String content) {
        return null;
    }
    
    private final java.lang.Integer parseCliBatteryPercent(java.lang.String content) {
        return null;
    }
    
    private final java.lang.Integer parseCliBatteryPercentFromVoltage(java.lang.String content) {
        return null;
    }
    
    private final com.vesper.flipper.domain.model.StorageInfo parseCliStorageInfo(java.lang.String content) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/vesper/flipper/ble/FlipperFileSystem$AutotuneSample;", "", "timestampMs", "", "latencyMs", "success", "", "busySignal", "disconnectSignal", "(JJZZZ)V", "getBusySignal", "()Z", "getDisconnectSignal", "getLatencyMs", "()J", "getSuccess", "getTimestampMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
    static final class AutotuneSample {
        private final long timestampMs = 0L;
        private final long latencyMs = 0L;
        private final boolean success = false;
        private final boolean busySignal = false;
        private final boolean disconnectSignal = false;
        
        public AutotuneSample(long timestampMs, long latencyMs, boolean success, boolean busySignal, boolean disconnectSignal) {
            super();
        }
        
        public final long getTimestampMs() {
            return 0L;
        }
        
        public final long getLatencyMs() {
            return 0L;
        }
        
        public final boolean getSuccess() {
            return false;
        }
        
        public final boolean getBusySignal() {
            return false;
        }
        
        public final boolean getDisconnectSignal() {
            return false;
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final long component2() {
            return 0L;
        }
        
        public final boolean component3() {
            return false;
        }
        
        public final boolean component4() {
            return false;
        }
        
        public final boolean component5() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.FlipperFileSystem.AutotuneSample copy(long timestampMs, long latencyMs, boolean success, boolean busySignal, boolean disconnectSignal) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/ble/FlipperFileSystem$Companion;", "", "()V", "AUTOTUNE_WINDOW_SIZE", "", "BATTERY_MAX_MV", "BATTERY_MIN_MV", "CLI_STATUS_RETRY_MS", "", "MAX_CLI_COMMAND_LENGTH", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}