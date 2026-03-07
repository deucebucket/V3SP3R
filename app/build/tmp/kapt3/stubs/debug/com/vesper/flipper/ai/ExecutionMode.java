package com.vesper.flipper.ai;

import com.vesper.flipper.ble.FlipperBleService;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.*;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/ai/ExecutionMode;", "", "(Ljava/lang/String;I)V", "NORMAL", "STEALTH", "AGGRESSIVE", "app_debug"})
public enum ExecutionMode {
    /*public static final*/ NORMAL /* = new NORMAL() */,
    /*public static final*/ STEALTH /* = new STEALTH() */,
    /*public static final*/ AGGRESSIVE /* = new AGGRESSIVE() */;
    
    ExecutionMode() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ai.ExecutionMode> getEntries() {
        return null;
    }
}