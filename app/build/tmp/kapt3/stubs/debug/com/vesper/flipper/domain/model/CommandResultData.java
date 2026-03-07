package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?Bk\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0014B_\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0015J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u0010+\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bH\u00c6\u0003Jh\u0010/\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\u0003H\u00d6\u0001J\t\u00105\u001a\u00020\bH\u00d6\u0001J&\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u00c1\u0001\u00a2\u0006\u0002\b=R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\'\u00a8\u0006@"}, d2 = {"Lcom/vesper/flipper/domain/model/CommandResultData;", "", "seen1", "", "entries", "", "Lcom/vesper/flipper/domain/model/FileEntry;", "content", "", "bytesWritten", "", "deviceInfo", "Lcom/vesper/flipper/domain/model/DeviceInfo;", "storageInfo", "Lcom/vesper/flipper/domain/model/StorageInfo;", "diff", "Lcom/vesper/flipper/domain/model/FileDiff;", "message", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/Long;Lcom/vesper/flipper/domain/model/DeviceInfo;Lcom/vesper/flipper/domain/model/StorageInfo;Lcom/vesper/flipper/domain/model/FileDiff;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Lcom/vesper/flipper/domain/model/DeviceInfo;Lcom/vesper/flipper/domain/model/StorageInfo;Lcom/vesper/flipper/domain/model/FileDiff;Ljava/lang/String;)V", "getBytesWritten$annotations", "()V", "getBytesWritten", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContent", "()Ljava/lang/String;", "getDeviceInfo$annotations", "getDeviceInfo", "()Lcom/vesper/flipper/domain/model/DeviceInfo;", "getDiff", "()Lcom/vesper/flipper/domain/model/FileDiff;", "getEntries", "()Ljava/util/List;", "getMessage", "getStorageInfo$annotations", "getStorageInfo", "()Lcom/vesper/flipper/domain/model/StorageInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Lcom/vesper/flipper/domain/model/DeviceInfo;Lcom/vesper/flipper/domain/model/StorageInfo;Lcom/vesper/flipper/domain/model/FileDiff;Ljava/lang/String;)Lcom/vesper/flipper/domain/model/CommandResultData;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
public final class CommandResultData {
    @org.jetbrains.annotations.Nullable
    private final java.util.List<com.vesper.flipper.domain.model.FileEntry> entries = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String content = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long bytesWritten = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.DeviceInfo deviceInfo = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.StorageInfo storageInfo = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.FileDiff diff = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String message = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.CommandResultData.Companion Companion = null;
    
    public CommandResultData(@org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.FileEntry> entries, @org.jetbrains.annotations.Nullable
    java.lang.String content, @org.jetbrains.annotations.Nullable
    java.lang.Long bytesWritten, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.DeviceInfo deviceInfo, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.StorageInfo storageInfo, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.FileDiff diff, @org.jetbrains.annotations.Nullable
    java.lang.String message) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.vesper.flipper.domain.model.FileEntry> getEntries() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getBytesWritten() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "bytes_written")
    @java.lang.Deprecated
    public static void getBytesWritten$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.DeviceInfo getDeviceInfo() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "device_info")
    @java.lang.Deprecated
    public static void getDeviceInfo$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.StorageInfo getStorageInfo() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "storage_info")
    @java.lang.Deprecated
    public static void getStorageInfo$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.FileDiff getDiff() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMessage() {
        return null;
    }
    
    public CommandResultData() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.vesper.flipper.domain.model.FileEntry> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.DeviceInfo component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.StorageInfo component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.FileDiff component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.CommandResultData copy(@org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.FileEntry> entries, @org.jetbrains.annotations.Nullable
    java.lang.String content, @org.jetbrains.annotations.Nullable
    java.lang.Long bytesWritten, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.DeviceInfo deviceInfo, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.StorageInfo storageInfo, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.FileDiff diff, @org.jetbrains.annotations.Nullable
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
    
    @kotlin.jvm.JvmStatic
    public static final void write$Self$app_debug(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.CommandResultData self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/vesper/flipper/domain/model/CommandResultData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vesper/flipper/domain/model/CommandResultData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.vesper.flipper.domain.model.CommandResultData> {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.domain.model.CommandResultData.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.vesper.flipper.domain.model.CommandResultData deserialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override
        public void serialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull
        com.vesper.flipper.domain.model.CommandResultData value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/domain/model/CommandResultData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vesper/flipper/domain/model/CommandResultData;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.CommandResultData> serializer() {
            return null;
        }
    }
}