package com.vesper.flipper.ble;

import com.flipperdevices.protobuf.Flipper;
import com.flipperdevices.protobuf.app.Application;
import com.flipperdevices.protobuf.desktop.Desktop;
import com.flipperdevices.protobuf.screen.Gui;
import com.google.protobuf.ByteString;
import com.vesper.flipper.domain.model.*;
import kotlinx.coroutines.*;
import kotlinx.coroutines.flow.*;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.flipperdevices.protobuf.storage.Storage;
import com.flipperdevices.protobuf.system.System;

/**
 * Protocol response types
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/vesper/flipper/ble/ProtocolResponse;", "", "()V", "BinaryContent", "DeviceInformation", "DirectoryList", "Error", "FileContent", "Success", "Lcom/vesper/flipper/ble/ProtocolResponse$BinaryContent;", "Lcom/vesper/flipper/ble/ProtocolResponse$DeviceInformation;", "Lcom/vesper/flipper/ble/ProtocolResponse$DirectoryList;", "Lcom/vesper/flipper/ble/ProtocolResponse$Error;", "Lcom/vesper/flipper/ble/ProtocolResponse$FileContent;", "Lcom/vesper/flipper/ble/ProtocolResponse$Success;", "app_debug"})
public abstract class ProtocolResponse {
    
    private ProtocolResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/vesper/flipper/ble/ProtocolResponse$BinaryContent;", "Lcom/vesper/flipper/ble/ProtocolResponse;", "data", "", "([B)V", "getData", "()[B", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class BinaryContent extends com.vesper.flipper.ble.ProtocolResponse {
        @org.jetbrains.annotations.NotNull
        private final byte[] data = null;
        
        public BinaryContent(@org.jetbrains.annotations.NotNull
        byte[] data) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final byte[] getData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final byte[] component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.ProtocolResponse.BinaryContent copy(@org.jetbrains.annotations.NotNull
        byte[] data) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/vesper/flipper/ble/ProtocolResponse$DeviceInformation;", "Lcom/vesper/flipper/ble/ProtocolResponse;", "deviceInfo", "Lcom/vesper/flipper/domain/model/DeviceInfo;", "storageInfo", "Lcom/vesper/flipper/domain/model/StorageInfo;", "(Lcom/vesper/flipper/domain/model/DeviceInfo;Lcom/vesper/flipper/domain/model/StorageInfo;)V", "getDeviceInfo", "()Lcom/vesper/flipper/domain/model/DeviceInfo;", "getStorageInfo", "()Lcom/vesper/flipper/domain/model/StorageInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class DeviceInformation extends com.vesper.flipper.ble.ProtocolResponse {
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.model.DeviceInfo deviceInfo = null;
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.model.StorageInfo storageInfo = null;
        
        public DeviceInformation(@org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.model.DeviceInfo deviceInfo, @org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.model.StorageInfo storageInfo) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.DeviceInfo getDeviceInfo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.StorageInfo getStorageInfo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.DeviceInfo component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.StorageInfo component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.ProtocolResponse.DeviceInformation copy(@org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.model.DeviceInfo deviceInfo, @org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.model.StorageInfo storageInfo) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/vesper/flipper/ble/ProtocolResponse$DirectoryList;", "Lcom/vesper/flipper/ble/ProtocolResponse;", "entries", "", "Lcom/vesper/flipper/domain/model/FileEntry;", "(Ljava/util/List;)V", "getEntries", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class DirectoryList extends com.vesper.flipper.ble.ProtocolResponse {
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.vesper.flipper.domain.model.FileEntry> entries = null;
        
        public DirectoryList(@org.jetbrains.annotations.NotNull
        java.util.List<com.vesper.flipper.domain.model.FileEntry> entries) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.vesper.flipper.domain.model.FileEntry> getEntries() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.vesper.flipper.domain.model.FileEntry> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.ProtocolResponse.DirectoryList copy(@org.jetbrains.annotations.NotNull
        java.util.List<com.vesper.flipper.domain.model.FileEntry> entries) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/vesper/flipper/ble/ProtocolResponse$Error;", "Lcom/vesper/flipper/ble/ProtocolResponse;", "message", "", "code", "", "(Ljava/lang/String;I)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
    public static final class Error extends com.vesper.flipper.ble.ProtocolResponse {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String message = null;
        private final int code = 0;
        
        public Error(@org.jetbrains.annotations.NotNull
        java.lang.String message, int code) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessage() {
            return null;
        }
        
        public final int getCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.ProtocolResponse.Error copy(@org.jetbrains.annotations.NotNull
        java.lang.String message, int code) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/vesper/flipper/ble/ProtocolResponse$FileContent;", "Lcom/vesper/flipper/ble/ProtocolResponse;", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class FileContent extends com.vesper.flipper.ble.ProtocolResponse {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String content = null;
        
        public FileContent(@org.jetbrains.annotations.NotNull
        java.lang.String content) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getContent() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.ProtocolResponse.FileContent copy(@org.jetbrains.annotations.NotNull
        java.lang.String content) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/vesper/flipper/ble/ProtocolResponse$Success;", "Lcom/vesper/flipper/ble/ProtocolResponse;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Success extends com.vesper.flipper.ble.ProtocolResponse {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String message = null;
        
        public Success(@org.jetbrains.annotations.NotNull
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.ProtocolResponse.Success copy(@org.jetbrains.annotations.NotNull
        java.lang.String message) {
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
}