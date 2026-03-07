package com.vesper.flipper.web;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.vesper.flipper.ble.FlipperFileSystem;
import kotlinx.coroutines.*;
import kotlinx.coroutines.flow.StateFlow;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * WebUI File Manager
 *
 * Embedded HTTP server for browser-based Flipper file management.
 * Access via http://phone-ip:8888
 *
 * Features:
 * - Browse Flipper file system
 * - Upload/download files
 * - Create/delete directories
 * - View/edit text files
 * - Mobile-responsive UI
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0082@\u00a2\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\'H\u0082@\u00a2\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0082@\u00a2\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\'H\u0082@\u00a2\u0006\u0002\u0010(J\u001e\u0010.\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\'H\u0082@\u00a2\u0006\u0002\u0010(J\u001e\u0010/\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\'H\u0082@\u00a2\u0006\u0002\u0010(J:\u00100\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000e2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e022\u0006\u00103\u001a\u0002042\u0006\u0010&\u001a\u00020\'H\u0082@\u00a2\u0006\u0002\u00105J \u00106\u001a\u00020\u00072\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0018\u0010=\u001a\u0002082\u0006\u00103\u001a\u0002042\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010\u000e2\u0006\u00103\u001a\u000204H\u0002J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u000eH\u0002J\u0018\u0010B\u001a\u00020!2\u0006\u0010&\u001a\u00020\'2\u0006\u0010C\u001a\u00020\u000eH\u0002J\u0018\u0010D\u001a\u00020!2\u0006\u0010&\u001a\u00020\'2\u0006\u0010E\u001a\u00020\u000eH\u0002J\u0010\u0010F\u001a\u00020!2\u0006\u0010&\u001a\u00020\'H\u0002J\u0010\u0010G\u001a\u00020!2\u0006\u0010&\u001a\u00020\'H\u0002J\u0010\u0010H\u001a\u00020!2\u0006\u0010&\u001a\u00020\'H\u0002J\u001e\u0010I\u001a\b\u0012\u0004\u0012\u0002080J2\u0006\u00107\u001a\u0002082\u0006\u0010K\u001a\u000208H\u0002J\u0006\u0010:\u001a\u00020!J\u0006\u0010L\u001a\u00020!J\u0010\u0010M\u001a\u0002082\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010N\u001a\u0002082\u0006\u00107\u001a\u000208H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012\u00a8\u0006O"}, d2 = {"Lcom/vesper/flipper/web/WebFileServer;", "", "context", "Landroid/content/Context;", "flipperFileSystem", "Lcom/vesper/flipper/ble/FlipperFileSystem;", "port", "", "(Landroid/content/Context;Lcom/vesper/flipper/ble/FlipperFileSystem;I)V", "_connectionCount", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_isRunning", "", "_serverUrl", "", "connectionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getConnectionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "isRunning", "scope", "Lkotlinx/coroutines/CoroutineScope;", "serverJob", "Lkotlinx/coroutines/Job;", "serverSocket", "Ljava/net/ServerSocket;", "serverUrl", "getServerUrl", "extractQueryParam", "path", "param", "getLocalIpAddress", "handleConnection", "", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDeleteApi", "writer", "Ljava/io/PrintWriter;", "(Ljava/lang/String;Ljava/io/PrintWriter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDownloadApi", "outputStream", "Ljava/io/OutputStream;", "(Ljava/lang/String;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleListApi", "handleMkdirApi", "handleReadApi", "handleUploadApi", "headers", "", "inputStream", "Ljava/io/InputStream;", "(Ljava/lang/String;Ljava/util/Map;Ljava/io/InputStream;Ljava/io/PrintWriter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "indexOfBytes", "data", "", "pattern", "start", "jsonEscape", "value", "readFully", "length", "readHttpLine", "sanitizeFilename", "name", "sendHtmlResponse", "html", "sendJsonResponse", "json", "serve404", "serveCss", "serveIndexPage", "splitByteArray", "", "delimiter", "stop", "trimLeadingCrlf", "trimTrailingCrlf", "app_debug"})
public final class WebFileServer {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperFileSystem flipperFileSystem = null;
    private final int port = 0;
    @org.jetbrains.annotations.Nullable
    private java.net.ServerSocket serverSocket;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job serverJob;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRunning = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRunning = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _serverUrl = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> serverUrl = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _connectionCount = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> connectionCount = null;
    
    public WebFileServer(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperFileSystem flipperFileSystem, int port) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRunning() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getServerUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getConnectionCount() {
        return null;
    }
    
    public final void start() {
    }
    
    public final void stop() {
    }
    
    private final java.lang.String getLocalIpAddress() {
        return null;
    }
    
    private final java.lang.Object handleConnection(java.net.Socket socket, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void serveIndexPage(java.io.PrintWriter writer) {
    }
    
    private final void serveCss(java.io.PrintWriter writer) {
    }
    
    private final java.lang.Object handleListApi(java.lang.String path, java.io.PrintWriter writer, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object handleReadApi(java.lang.String path, java.io.PrintWriter writer, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object handleDownloadApi(java.lang.String path, java.io.OutputStream outputStream, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object handleDeleteApi(java.lang.String path, java.io.PrintWriter writer, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object handleMkdirApi(java.lang.String path, java.io.PrintWriter writer, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object handleUploadApi(java.lang.String path, java.util.Map<java.lang.String, java.lang.String> headers, java.io.InputStream inputStream, java.io.PrintWriter writer, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.String readHttpLine(java.io.InputStream inputStream) {
        return null;
    }
    
    private final byte[] readFully(java.io.InputStream inputStream, int length) {
        return null;
    }
    
    private final java.util.List<byte[]> splitByteArray(byte[] data, byte[] delimiter) {
        return null;
    }
    
    private final int indexOfBytes(byte[] data, byte[] pattern, int start) {
        return 0;
    }
    
    private final byte[] trimLeadingCrlf(byte[] data) {
        return null;
    }
    
    private final byte[] trimTrailingCrlf(byte[] data) {
        return null;
    }
    
    private final java.lang.String sanitizeFilename(java.lang.String name) {
        return null;
    }
    
    private final java.lang.String jsonEscape(java.lang.String value) {
        return null;
    }
    
    private final void serve404(java.io.PrintWriter writer) {
    }
    
    private final void sendHtmlResponse(java.io.PrintWriter writer, java.lang.String html) {
    }
    
    private final void sendJsonResponse(java.io.PrintWriter writer, java.lang.String json) {
    }
    
    private final java.lang.String extractQueryParam(java.lang.String path, java.lang.String param) {
        return null;
    }
}