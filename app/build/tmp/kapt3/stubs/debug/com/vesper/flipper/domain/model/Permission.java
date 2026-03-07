package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import java.util.UUID;

/**
 * Scoped permission for path-based access control.
 * Permissions are time-limited and explicitly granted.
 */
@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\'\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@ABi\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012BK\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\t\u0010(\u001a\u00020\u000bH\u00c6\u0003J\t\u0010)\u001a\u00020\u000bH\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u000fH\u00c6\u0003JU\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001J\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020\u000fJ\u0016\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\tJ\u0010\u00105\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u0005H\u0002J\u0006\u00106\u001a\u00020\u000bJ\t\u00107\u001a\u00020\u0005H\u00d6\u0001J&\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u00c1\u0001\u00a2\u0006\u0002\b?R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010!\u00a8\u0006B"}, d2 = {"Lcom/vesper/flipper/domain/model/Permission;", "", "seen1", "", "id", "", "pathPattern", "allowedActions", "", "Lcom/vesper/flipper/domain/model/CommandAction;", "grantedAt", "", "expiresAt", "grantedBy", "active", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Set;JJLjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;JJLjava/lang/String;Z)V", "getActive", "()Z", "getAllowedActions$annotations", "()V", "getAllowedActions", "()Ljava/util/Set;", "getExpiresAt$annotations", "getExpiresAt", "()J", "getGrantedAt$annotations", "getGrantedAt", "getGrantedBy$annotations", "getGrantedBy", "()Ljava/lang/String;", "getId", "getPathPattern$annotations", "getPathPattern", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "isExpired", "isValid", "matches", "path", "action", "matchesPath", "remainingTimeMs", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
public final class Permission {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String pathPattern = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Set<com.vesper.flipper.domain.model.CommandAction> allowedActions = null;
    private final long grantedAt = 0L;
    private final long expiresAt = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String grantedBy = null;
    private final boolean active = false;
    public static final long DURATION_5_MINUTES = 300000L;
    public static final long DURATION_15_MINUTES = 900000L;
    public static final long DURATION_1_HOUR = 3600000L;
    public static final long DURATION_SESSION = 86400000L;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.Permission.Companion Companion = null;
    
    public Permission(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String pathPattern, @org.jetbrains.annotations.NotNull
    java.util.Set<? extends com.vesper.flipper.domain.model.CommandAction> allowedActions, long grantedAt, long expiresAt, @org.jetbrains.annotations.NotNull
    java.lang.String grantedBy, boolean active) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPathPattern() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "path_pattern")
    @java.lang.Deprecated
    public static void getPathPattern$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<com.vesper.flipper.domain.model.CommandAction> getAllowedActions() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "allowed_actions")
    @java.lang.Deprecated
    public static void getAllowedActions$annotations() {
    }
    
    public final long getGrantedAt() {
        return 0L;
    }
    
    @kotlinx.serialization.SerialName(value = "granted_at")
    @java.lang.Deprecated
    public static void getGrantedAt$annotations() {
    }
    
    public final long getExpiresAt() {
        return 0L;
    }
    
    @kotlinx.serialization.SerialName(value = "expires_at")
    @java.lang.Deprecated
    public static void getExpiresAt$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGrantedBy() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "granted_by")
    @java.lang.Deprecated
    public static void getGrantedBy$annotations() {
    }
    
    public final boolean getActive() {
        return false;
    }
    
    public final boolean isExpired() {
        return false;
    }
    
    public final boolean isValid() {
        return false;
    }
    
    public final boolean matches(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.CommandAction action) {
        return false;
    }
    
    private final boolean matchesPath(java.lang.String path) {
        return false;
    }
    
    public final long remainingTimeMs() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<com.vesper.flipper.domain.model.CommandAction> component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.Permission copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String pathPattern, @org.jetbrains.annotations.NotNull
    java.util.Set<? extends com.vesper.flipper.domain.model.CommandAction> allowedActions, long grantedAt, long expiresAt, @org.jetbrains.annotations.NotNull
    java.lang.String grantedBy, boolean active) {
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
    com.vesper.flipper.domain.model.Permission self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    /**
     * Scoped permission for path-based access control.
     * Permissions are time-limited and explicitly granted.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/vesper/flipper/domain/model/Permission.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vesper/flipper/domain/model/Permission;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.vesper.flipper.domain.model.Permission> {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.domain.model.Permission.$serializer INSTANCE = null;
        
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
        public com.vesper.flipper.domain.model.Permission deserialize(@org.jetbrains.annotations.NotNull
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
        com.vesper.flipper.domain.model.Permission value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u00c6\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/vesper/flipper/domain/model/Permission$Companion;", "", "()V", "DURATION_15_MINUTES", "", "DURATION_1_HOUR", "DURATION_5_MINUTES", "DURATION_SESSION", "createForPath", "Lcom/vesper/flipper/domain/model/Permission;", "path", "", "actions", "", "Lcom/vesper/flipper/domain/model/CommandAction;", "duration", "createProjectScope", "projectPath", "serializer", "Lkotlinx/serialization/KSerializer;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.Permission createForPath(@org.jetbrains.annotations.NotNull
        java.lang.String path, @org.jetbrains.annotations.NotNull
        java.util.Set<? extends com.vesper.flipper.domain.model.CommandAction> actions, long duration) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.Permission createProjectScope(@org.jetbrains.annotations.NotNull
        java.lang.String projectPath) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.Permission> serializer() {
            return null;
        }
    }
}