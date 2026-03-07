package com.vesper.flipper.data.db;

import android.content.Context;
import androidx.room.*;
import kotlinx.coroutines.flow.Flow;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/vesper/flipper/data/db/DeviceType;", "", "displayName", "", "icon", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getIcon", "BLE", "SUBGHZ", "NFC", "RFID", "WIFI", "INFRARED", "IBUTTON", "app_debug"})
public enum DeviceType {
    /*public static final*/ BLE /* = new BLE(null, null) */,
    /*public static final*/ SUBGHZ /* = new SUBGHZ(null, null) */,
    /*public static final*/ NFC /* = new NFC(null, null) */,
    /*public static final*/ RFID /* = new RFID(null, null) */,
    /*public static final*/ WIFI /* = new WIFI(null, null) */,
    /*public static final*/ INFRARED /* = new INFRARED(null, null) */,
    /*public static final*/ IBUTTON /* = new IBUTTON(null, null) */;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String displayName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String icon = null;
    
    DeviceType(java.lang.String displayName, java.lang.String icon) {
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
    public static kotlin.enums.EnumEntries<com.vesper.flipper.data.db.DeviceType> getEntries() {
        return null;
    }
}