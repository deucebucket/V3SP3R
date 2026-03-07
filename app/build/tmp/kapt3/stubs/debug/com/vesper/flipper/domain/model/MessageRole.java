package com.vesper.flipper.domain.model;

import android.net.Uri;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import java.util.UUID;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\b"}, d2 = {"Lcom/vesper/flipper/domain/model/MessageRole;", "", "(Ljava/lang/String;I)V", "USER", "ASSISTANT", "SYSTEM", "TOOL", "Companion", "app_debug"})
public enum MessageRole {
    @kotlinx.serialization.SerialName(value = "user")
    /*public static final*/ USER /* = new USER() */,
    @kotlinx.serialization.SerialName(value = "assistant")
    /*public static final*/ ASSISTANT /* = new ASSISTANT() */,
    @kotlinx.serialization.SerialName(value = "system")
    /*public static final*/ SYSTEM /* = new SYSTEM() */,
    @kotlinx.serialization.SerialName(value = "tool")
    /*public static final*/ TOOL /* = new TOOL() */;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.MessageRole.Companion Companion = null;
    
    MessageRole() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.model.MessageRole> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/domain/model/MessageRole$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vesper/flipper/domain/model/MessageRole;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.MessageRole> serializer() {
            return null;
        }
    }
}