package com.vesper.flipper.ai;

import com.vesper.flipper.ble.FlipperBleService;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.*;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u00c6\u0003JW\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\nH\u00d6\u0001J\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f\u00a8\u0006$"}, d2 = {"Lcom/vesper/flipper/ai/ValidatedPortalHtml;", "", "html", "", "isValid", "", "errors", "", "warnings", "sizeBytes", "", "suggestedActions", "Lcom/vesper/flipper/ai/SuggestedAction;", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;ILjava/util/List;)V", "getErrors", "()Ljava/util/List;", "getHtml", "()Ljava/lang/String;", "()Z", "getSizeBytes", "()I", "getSuggestedActions", "getWarnings", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toMetadata", "", "toString", "app_debug"})
public final class ValidatedPortalHtml {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String html = null;
    private final boolean isValid = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> errors = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> warnings = null;
    private final int sizeBytes = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.ai.SuggestedAction> suggestedActions = null;
    
    public ValidatedPortalHtml(@org.jetbrains.annotations.NotNull
    java.lang.String html, boolean isValid, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> errors, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> warnings, int sizeBytes, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ai.SuggestedAction> suggestedActions) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHtml() {
        return null;
    }
    
    public final boolean isValid() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getErrors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getWarnings() {
        return null;
    }
    
    public final int getSizeBytes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ai.SuggestedAction> getSuggestedActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Object> toMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ai.SuggestedAction> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ai.ValidatedPortalHtml copy(@org.jetbrains.annotations.NotNull
    java.lang.String html, boolean isValid, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> errors, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> warnings, int sizeBytes, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ai.SuggestedAction> suggestedActions) {
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