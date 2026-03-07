package com.vesper.flipper.data;

import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Fetches OpenRouter's live model catalog and selects one latest model
 * for each major manufacturer/provider used by the app.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0002\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u000e*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0017"}, d2 = {"Lcom/vesper/flipper/data/OpenRouterModelCatalog;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "json", "Lkotlinx/serialization/json/Json;", "fetchLatestByManufacturer", "Lkotlin/Result;", "", "Lcom/vesper/flipper/data/ModelInfo;", "fetchLatestByManufacturer-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "providerFromId", "", "modelId", "long", "", "Lkotlinx/serialization/json/JsonObject;", "key", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "string", "Companion", "app_debug"})
public final class OpenRouterModelCatalog {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.serialization.json.Json json = null;
    @org.jetbrains.annotations.NotNull
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String MODELS_URL = "https://openrouter.ai/api/v1/models";
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<com.vesper.flipper.data.OpenRouterModelCatalog.Companion.Manufacturer> MAJOR_MANUFACTURERS = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.data.OpenRouterModelCatalog.Companion Companion = null;
    
    @javax.inject.Inject
    public OpenRouterModelCatalog() {
        super();
    }
    
    private final java.lang.String providerFromId(java.lang.String modelId) {
        return null;
    }
    
    private final java.lang.String string(kotlinx.serialization.json.JsonObject $this$string, java.lang.String key) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/data/OpenRouterModelCatalog$Companion;", "", "()V", "MAJOR_MANUFACTURERS", "", "Lcom/vesper/flipper/data/OpenRouterModelCatalog$Companion$Manufacturer;", "MODELS_URL", "", "Manufacturer", "RemoteModel", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/vesper/flipper/data/OpenRouterModelCatalog$Companion$Manufacturer;", "", "providerId", "", "displayName", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getProviderId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
        static final class Manufacturer {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String providerId = null;
            @org.jetbrains.annotations.NotNull
            private final java.lang.String displayName = null;
            
            public Manufacturer(@org.jetbrains.annotations.NotNull
            java.lang.String providerId, @org.jetbrains.annotations.NotNull
            java.lang.String displayName) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getProviderId() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getDisplayName() {
                return null;
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
            public final com.vesper.flipper.data.OpenRouterModelCatalog.Companion.Manufacturer copy(@org.jetbrains.annotations.NotNull
            java.lang.String providerId, @org.jetbrains.annotations.NotNull
            java.lang.String displayName) {
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
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/vesper/flipper/data/OpenRouterModelCatalog$Companion$RemoteModel;", "", "id", "", "name", "created", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getCreated", "()J", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
        static final class RemoteModel {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String id = null;
            @org.jetbrains.annotations.NotNull
            private final java.lang.String name = null;
            private final long created = 0L;
            
            public RemoteModel(@org.jetbrains.annotations.NotNull
            java.lang.String id, @org.jetbrains.annotations.NotNull
            java.lang.String name, long created) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getId() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getName() {
                return null;
            }
            
            public final long getCreated() {
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
            
            public final long component3() {
                return 0L;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.vesper.flipper.data.OpenRouterModelCatalog.Companion.RemoteModel copy(@org.jetbrains.annotations.NotNull
            java.lang.String id, @org.jetbrains.annotations.NotNull
            java.lang.String name, long created) {
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
        }
    }
}