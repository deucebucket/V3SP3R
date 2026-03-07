package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ai.OpenRouterClient;
import com.vesper.flipper.ble.BleServiceManager;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.ChimeraProject;
import com.vesper.flipper.domain.model.ChimeraSplicer;
import com.vesper.flipper.domain.model.FusionMode;
import com.vesper.flipper.domain.model.GeneType;
import com.vesper.flipper.domain.model.Mutation;
import com.vesper.flipper.domain.model.SignalGene;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/SuggestionPriority;", "", "color", "", "(Ljava/lang/String;IJ)V", "getColor", "()J", "HIGH", "MEDIUM", "LOW", "app_debug"})
public enum SuggestionPriority {
    /*public static final*/ HIGH /* = new HIGH(0L) */,
    /*public static final*/ MEDIUM /* = new MEDIUM(0L) */,
    /*public static final*/ LOW /* = new LOW(0L) */;
    private final long color = 0L;
    
    SuggestionPriority(long color) {
    }
    
    public final long getColor() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ui.viewmodel.SuggestionPriority> getEntries() {
        return null;
    }
}