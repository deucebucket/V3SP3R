package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\t"}, d2 = {"Lcom/vesper/flipper/domain/model/EvilPortalType;", "", "(Ljava/lang/String;I)V", "WIFI_LOGIN", "SOCIAL_MEDIA", "CORPORATE", "BANKING", "CUSTOM", "Companion", "app_debug"})
public enum EvilPortalType {
    @kotlinx.serialization.SerialName(value = "wifi_login")
    /*public static final*/ WIFI_LOGIN /* = new WIFI_LOGIN() */,
    @kotlinx.serialization.SerialName(value = "social_media")
    /*public static final*/ SOCIAL_MEDIA /* = new SOCIAL_MEDIA() */,
    @kotlinx.serialization.SerialName(value = "corporate")
    /*public static final*/ CORPORATE /* = new CORPORATE() */,
    @kotlinx.serialization.SerialName(value = "banking")
    /*public static final*/ BANKING /* = new BANKING() */,
    @kotlinx.serialization.SerialName(value = "custom")
    /*public static final*/ CUSTOM /* = new CUSTOM() */;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.EvilPortalType.Companion Companion = null;
    
    EvilPortalType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.model.EvilPortalType> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/domain/model/EvilPortalType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vesper/flipper/domain/model/EvilPortalType;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.EvilPortalType> serializer() {
            return null;
        }
    }
}