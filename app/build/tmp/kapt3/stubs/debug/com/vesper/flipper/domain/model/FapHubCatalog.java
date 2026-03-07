package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/**
 * FapHub API endpoints and built-in app catalog
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/vesper/flipper/domain/model/FapHubCatalog;", "", "()V", "allApps", "", "Lcom/vesper/flipper/domain/model/FapApp;", "getAllApps", "()Ljava/util/List;", "featuredApps", "getFeaturedApps", "getAppsByCategory", "category", "Lcom/vesper/flipper/domain/model/FapCategory;", "searchApps", "query", "", "app_debug"})
public final class FapHubCatalog {
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<com.vesper.flipper.domain.model.FapApp> featuredApps = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.FapHubCatalog INSTANCE = null;
    
    private FapHubCatalog() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.FapApp> getFeaturedApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.FapApp> getAllApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.FapApp> getAppsByCategory(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.FapCategory category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.FapApp> searchApps(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
}