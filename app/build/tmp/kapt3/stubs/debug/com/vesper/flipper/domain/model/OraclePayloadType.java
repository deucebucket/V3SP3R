package com.vesper.flipper.domain.model;

import kotlinx.serialization.Serializable;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/vesper/flipper/domain/model/OraclePayloadType;", "", "(Ljava/lang/String;I)V", "REPLAY", "CRAFTED", "BRUTE_FORCE_SEQUENCE", "JAMMING", "INJECTION", "app_debug"})
public enum OraclePayloadType {
    /*public static final*/ REPLAY /* = new REPLAY() */,
    /*public static final*/ CRAFTED /* = new CRAFTED() */,
    /*public static final*/ BRUTE_FORCE_SEQUENCE /* = new BRUTE_FORCE_SEQUENCE() */,
    /*public static final*/ JAMMING /* = new JAMMING() */,
    /*public static final*/ INJECTION /* = new INJECTION() */;
    
    OraclePayloadType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.model.OraclePayloadType> getEntries() {
        return null;
    }
}