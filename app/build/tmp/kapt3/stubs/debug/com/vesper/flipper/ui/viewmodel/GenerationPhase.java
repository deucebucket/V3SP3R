package com.vesper.flipper.ui.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ai.*;
import com.vesper.flipper.domain.model.*;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.*;
import java.io.ByteArrayOutputStream;
import javax.inject.Inject;
import com.vesper.flipper.ai.ToolResult;

/**
 * Generation phase for progress tracking
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/GenerationPhase;", "", "(Ljava/lang/String;I)V", "IDLE", "GENERATING", "VALIDATING", "READY", "COMPLETE", "ERROR", "app_debug"})
public enum GenerationPhase {
    /*public static final*/ IDLE /* = new IDLE() */,
    /*public static final*/ GENERATING /* = new GENERATING() */,
    /*public static final*/ VALIDATING /* = new VALIDATING() */,
    /*public static final*/ READY /* = new READY() */,
    /*public static final*/ COMPLETE /* = new COMPLETE() */,
    /*public static final*/ ERROR /* = new ERROR() */;
    
    GenerationPhase() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ui.viewmodel.GenerationPhase> getEntries() {
        return null;
    }
}