package com.vesper.flipper.ble;

import com.flipperdevices.protobuf.screen.Gui;
import com.vesper.flipper.domain.model.*;
import com.vesper.flipper.security.SecurityUtils;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Exception for Flipper file system operations
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/ble/FlipperException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "code", "", "(Ljava/lang/String;I)V", "getCode", "()I", "app_debug"})
public final class FlipperException extends java.lang.Exception {
    private final int code = 0;
    
    public FlipperException(@org.jetbrains.annotations.NotNull
    java.lang.String message, int code) {
        super();
    }
    
    public final int getCode() {
        return 0;
    }
}