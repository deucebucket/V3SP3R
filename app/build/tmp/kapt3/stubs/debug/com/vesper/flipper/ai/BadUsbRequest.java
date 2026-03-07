package com.vesper.flipper.ai;

import com.vesper.flipper.ble.FlipperBleService;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.*;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.Serializable;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/vesper/flipper/ai/BadUsbRequest;", "", "description", "", "platform", "Lcom/vesper/flipper/domain/model/BadUsbPlatform;", "executionMode", "Lcom/vesper/flipper/ai/ExecutionMode;", "constraints", "", "(Ljava/lang/String;Lcom/vesper/flipper/domain/model/BadUsbPlatform;Lcom/vesper/flipper/ai/ExecutionMode;Ljava/util/List;)V", "getConstraints", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getExecutionMode", "()Lcom/vesper/flipper/ai/ExecutionMode;", "getPlatform", "()Lcom/vesper/flipper/domain/model/BadUsbPlatform;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class BadUsbRequest {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.domain.model.BadUsbPlatform platform = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ai.ExecutionMode executionMode = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> constraints = null;
    
    public BadUsbRequest(@org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.BadUsbPlatform platform, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.ExecutionMode executionMode, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> constraints) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.BadUsbPlatform getPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ai.ExecutionMode getExecutionMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getConstraints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.BadUsbPlatform component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ai.ExecutionMode component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ai.BadUsbRequest copy(@org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.BadUsbPlatform platform, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ai.ExecutionMode executionMode, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> constraints) {
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