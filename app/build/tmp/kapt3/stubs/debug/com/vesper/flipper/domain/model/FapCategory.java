package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/vesper/flipper/domain/model/FapCategory;", "", "displayName", "", "icon", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getIcon", "GAMES", "TOOLS", "NFC", "SUBGHZ", "INFRARED", "GPIO", "BLUETOOTH", "USB", "MEDIA", "MISC", "Companion", "app_debug"})
public enum FapCategory {
    @kotlinx.serialization.SerialName(value = "games")
    /*public static final*/ GAMES /* = new GAMES(null, null) */,
    @kotlinx.serialization.SerialName(value = "tools")
    /*public static final*/ TOOLS /* = new TOOLS(null, null) */,
    @kotlinx.serialization.SerialName(value = "nfc")
    /*public static final*/ NFC /* = new NFC(null, null) */,
    @kotlinx.serialization.SerialName(value = "subghz")
    /*public static final*/ SUBGHZ /* = new SUBGHZ(null, null) */,
    @kotlinx.serialization.SerialName(value = "infrared")
    /*public static final*/ INFRARED /* = new INFRARED(null, null) */,
    @kotlinx.serialization.SerialName(value = "gpio")
    /*public static final*/ GPIO /* = new GPIO(null, null) */,
    @kotlinx.serialization.SerialName(value = "bluetooth")
    /*public static final*/ BLUETOOTH /* = new BLUETOOTH(null, null) */,
    @kotlinx.serialization.SerialName(value = "usb")
    /*public static final*/ USB /* = new USB(null, null) */,
    @kotlinx.serialization.SerialName(value = "media")
    /*public static final*/ MEDIA /* = new MEDIA(null, null) */,
    @kotlinx.serialization.SerialName(value = "misc")
    /*public static final*/ MISC /* = new MISC(null, null) */;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String displayName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String icon = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.FapCategory.Companion Companion = null;
    
    FapCategory(java.lang.String displayName, java.lang.String icon) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.model.FapCategory> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/domain/model/FapCategory$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vesper/flipper/domain/model/FapCategory;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.FapCategory> serializer() {
            return null;
        }
    }
}