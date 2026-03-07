package com.vesper.flipper.ai;

import com.vesper.flipper.ble.FlipperBleService;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.*;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/vesper/flipper/ai/PortalType;", "", "(Ljava/lang/String;I)V", "GENERIC", "CORPORATE_SSO", "GOOGLE_WORKSPACE", "MICROSOFT_365", "SOCIAL_MEDIA", "HOTEL_WIFI", "COFFEE_SHOP", "AIRPORT", "BANKING", "app_debug"})
public enum PortalType {
    /*public static final*/ GENERIC /* = new GENERIC() */,
    /*public static final*/ CORPORATE_SSO /* = new CORPORATE_SSO() */,
    /*public static final*/ GOOGLE_WORKSPACE /* = new GOOGLE_WORKSPACE() */,
    /*public static final*/ MICROSOFT_365 /* = new MICROSOFT_365() */,
    /*public static final*/ SOCIAL_MEDIA /* = new SOCIAL_MEDIA() */,
    /*public static final*/ HOTEL_WIFI /* = new HOTEL_WIFI() */,
    /*public static final*/ COFFEE_SHOP /* = new COFFEE_SHOP() */,
    /*public static final*/ AIRPORT /* = new AIRPORT() */,
    /*public static final*/ BANKING /* = new BANKING() */;
    
    PortalType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ai.PortalType> getEntries() {
        return null;
    }
}