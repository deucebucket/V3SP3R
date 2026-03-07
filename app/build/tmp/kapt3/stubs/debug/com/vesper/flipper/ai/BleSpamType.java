package com.vesper.flipper.ai;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.vesper.flipper.ble.BleServiceManager;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.PayloadType;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/vesper/flipper/ai/BleSpamType;", "", "(Ljava/lang/String;I)V", "APPLE_AIRPODS", "APPLE_AIRTAG", "SAMSUNG_BUDS", "GOOGLE_FAST_PAIR", "DEVICE_FLOOD", "STOP", "app_debug"})
public enum BleSpamType {
    /*public static final*/ APPLE_AIRPODS /* = new APPLE_AIRPODS() */,
    /*public static final*/ APPLE_AIRTAG /* = new APPLE_AIRTAG() */,
    /*public static final*/ SAMSUNG_BUDS /* = new SAMSUNG_BUDS() */,
    /*public static final*/ GOOGLE_FAST_PAIR /* = new GOOGLE_FAST_PAIR() */,
    /*public static final*/ DEVICE_FLOOD /* = new DEVICE_FLOOD() */,
    /*public static final*/ STOP /* = new STOP() */;
    
    BleSpamType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ai.BleSpamType> getEntries() {
        return null;
    }
}