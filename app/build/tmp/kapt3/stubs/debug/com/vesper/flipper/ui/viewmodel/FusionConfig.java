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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/FusionConfig;", "", "outputFrequency", "", "polymorphicMode", "", "polymorphicSeed", "variantCount", "", "(JZJI)V", "getOutputFrequency", "()J", "getPolymorphicMode", "()Z", "getPolymorphicSeed", "getVariantCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class FusionConfig {
    private final long outputFrequency = 0L;
    private final boolean polymorphicMode = false;
    private final long polymorphicSeed = 0L;
    private final int variantCount = 0;
    
    public FusionConfig(long outputFrequency, boolean polymorphicMode, long polymorphicSeed, int variantCount) {
        super();
    }
    
    public final long getOutputFrequency() {
        return 0L;
    }
    
    public final boolean getPolymorphicMode() {
        return false;
    }
    
    public final long getPolymorphicSeed() {
        return 0L;
    }
    
    public final int getVariantCount() {
        return 0;
    }
    
    public FusionConfig() {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.FusionConfig copy(long outputFrequency, boolean polymorphicMode, long polymorphicSeed, int variantCount) {
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