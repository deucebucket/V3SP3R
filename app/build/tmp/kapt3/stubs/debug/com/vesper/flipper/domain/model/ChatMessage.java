package com.vesper.flipper.domain.model;

import android.net.Uri;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import java.util.UUID;

/**
 * Chat message in the conversation with the AI agent.
 * Supports multimodal input with text and images.
 */
@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0002DEB\u0089\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0001\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u0018Bu\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0019J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\nH\u00c6\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u00c6\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fH\u00c6\u0003J\t\u00103\u001a\u00020\u0011H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fH\u00c6\u0003J}\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fH\u00c6\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020\u0003H\u00d6\u0001J\t\u0010;\u001a\u00020\u0005H\u00d6\u0001J&\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u00c1\u0001\u00a2\u0006\u0002\bCR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010 R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010 \u00a8\u0006F"}, d2 = {"Lcom/vesper/flipper/domain/model/ChatMessage;", "", "seen1", "", "id", "", "role", "Lcom/vesper/flipper/domain/model/MessageRole;", "content", "timestamp", "", "toolCalls", "", "Lcom/vesper/flipper/domain/model/ToolCall;", "toolResults", "Lcom/vesper/flipper/domain/model/ToolResult;", "status", "Lcom/vesper/flipper/domain/model/MessageStatus;", "metadata", "Lcom/vesper/flipper/domain/model/MessageMetadata;", "imageAttachments", "Lcom/vesper/flipper/domain/model/ImageAttachment;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/vesper/flipper/domain/model/MessageRole;Ljava/lang/String;JLjava/util/List;Ljava/util/List;Lcom/vesper/flipper/domain/model/MessageStatus;Lcom/vesper/flipper/domain/model/MessageMetadata;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/vesper/flipper/domain/model/MessageRole;Ljava/lang/String;JLjava/util/List;Ljava/util/List;Lcom/vesper/flipper/domain/model/MessageStatus;Lcom/vesper/flipper/domain/model/MessageMetadata;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getId", "getImageAttachments$annotations", "()V", "getImageAttachments", "()Ljava/util/List;", "getMetadata", "()Lcom/vesper/flipper/domain/model/MessageMetadata;", "getRole", "()Lcom/vesper/flipper/domain/model/MessageRole;", "getStatus", "()Lcom/vesper/flipper/domain/model/MessageStatus;", "getTimestamp", "()J", "getToolCalls$annotations", "getToolCalls", "getToolResults$annotations", "getToolResults", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
public final class ChatMessage {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.MessageRole role = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String content = null;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<com.vesper.flipper.domain.model.ToolCall> toolCalls = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<com.vesper.flipper.domain.model.ToolResult> toolResults = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.MessageStatus status = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.MessageMetadata metadata = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<com.vesper.flipper.domain.model.ImageAttachment> imageAttachments = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.ChatMessage.Companion Companion = null;
    
    public ChatMessage(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.MessageRole role, @org.jetbrains.annotations.NotNull
    java.lang.String content, long timestamp, @org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.ToolCall> toolCalls, @org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.ToolResult> toolResults, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.MessageStatus status, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.MessageMetadata metadata, @org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.ImageAttachment> imageAttachments) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.MessageRole getRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContent() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.vesper.flipper.domain.model.ToolCall> getToolCalls() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "tool_calls")
    @java.lang.Deprecated
    public static void getToolCalls$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.vesper.flipper.domain.model.ToolResult> getToolResults() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "tool_results")
    @java.lang.Deprecated
    public static void getToolResults$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.MessageStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.MessageMetadata getMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.vesper.flipper.domain.model.ImageAttachment> getImageAttachments() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "image_attachments")
    @java.lang.Deprecated
    public static void getImageAttachments$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.MessageRole component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.vesper.flipper.domain.model.ToolCall> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.vesper.flipper.domain.model.ToolResult> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.MessageStatus component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.MessageMetadata component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.vesper.flipper.domain.model.ImageAttachment> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ChatMessage copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.MessageRole role, @org.jetbrains.annotations.NotNull
    java.lang.String content, long timestamp, @org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.ToolCall> toolCalls, @org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.ToolResult> toolResults, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.MessageStatus status, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.MessageMetadata metadata, @org.jetbrains.annotations.Nullable
    java.util.List<com.vesper.flipper.domain.model.ImageAttachment> imageAttachments) {
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
    com.vesper.flipper.domain.model.ChatMessage self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    /**
     * Chat message in the conversation with the AI agent.
     * Supports multimodal input with text and images.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/vesper/flipper/domain/model/ChatMessage.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vesper/flipper/domain/model/ChatMessage;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.vesper.flipper.domain.model.ChatMessage> {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.domain.model.ChatMessage.$serializer INSTANCE = null;
        
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
        public com.vesper.flipper.domain.model.ChatMessage deserialize(@org.jetbrains.annotations.NotNull
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
        com.vesper.flipper.domain.model.ChatMessage value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    /**
     * Chat message in the conversation with the AI agent.
     * Supports multimodal input with text and images.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/domain/model/ChatMessage$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vesper/flipper/domain/model/ChatMessage;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.ChatMessage> serializer() {
            return null;
        }
    }
}