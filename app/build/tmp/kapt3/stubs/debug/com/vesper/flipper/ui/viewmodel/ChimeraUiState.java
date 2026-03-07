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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u00cb\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u000e\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u001aJ\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u00c6\u0003J\t\u0010,\u001a\u00020\u0013H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u0015\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u000eH\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eH\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003J\u00cf\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u000e2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010=\u001a\u00020\u0011H\u00d6\u0001J\t\u0010>\u001a\u00020\nH\u00d6\u0001R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010#R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010#R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010#R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010 R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 \u00a8\u0006?"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/ChimeraUiState;", "", "isLoading", "", "isExtracting", "isOptimizing", "isSynthesizing", "isSaving", "isTransmitting", "error", "", "currentProject", "Lcom/vesper/flipper/domain/model/ChimeraProject;", "selectedSignals", "", "Lcom/vesper/flipper/ui/viewmodel/SignalSource;", "resultTimings", "", "fusionConfig", "Lcom/vesper/flipper/ui/viewmodel/FusionConfig;", "synthesizedOutput", "polymorphicVariants", "aiSuggestions", "Lcom/vesper/flipper/ui/viewmodel/AISuggestion;", "saveSuccess", "savedPath", "(ZZZZZZLjava/lang/String;Lcom/vesper/flipper/domain/model/ChimeraProject;Ljava/util/List;Ljava/util/List;Lcom/vesper/flipper/ui/viewmodel/FusionConfig;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;)V", "getAiSuggestions", "()Ljava/util/List;", "getCurrentProject", "()Lcom/vesper/flipper/domain/model/ChimeraProject;", "getError", "()Ljava/lang/String;", "getFusionConfig", "()Lcom/vesper/flipper/ui/viewmodel/FusionConfig;", "()Z", "getPolymorphicVariants", "getResultTimings", "getSaveSuccess", "getSavedPath", "getSelectedSignals", "getSynthesizedOutput", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class ChimeraUiState {
    private final boolean isLoading = false;
    private final boolean isExtracting = false;
    private final boolean isOptimizing = false;
    private final boolean isSynthesizing = false;
    private final boolean isSaving = false;
    private final boolean isTransmitting = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    @org.jetbrains.annotations.Nullable
    private final com.vesper.flipper.domain.model.ChimeraProject currentProject = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.ui.viewmodel.SignalSource> selectedSignals = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Integer> resultTimings = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ui.viewmodel.FusionConfig fusionConfig = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String synthesizedOutput = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.util.List<java.lang.Integer>> polymorphicVariants = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vesper.flipper.ui.viewmodel.AISuggestion> aiSuggestions = null;
    private final boolean saveSuccess = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String savedPath = null;
    
    public ChimeraUiState(boolean isLoading, boolean isExtracting, boolean isOptimizing, boolean isSynthesizing, boolean isSaving, boolean isTransmitting, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ChimeraProject currentProject, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ui.viewmodel.SignalSource> selectedSignals, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> resultTimings, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.FusionConfig fusionConfig, @org.jetbrains.annotations.Nullable
    java.lang.String synthesizedOutput, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.util.List<java.lang.Integer>> polymorphicVariants, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ui.viewmodel.AISuggestion> aiSuggestions, boolean saveSuccess, @org.jetbrains.annotations.Nullable
    java.lang.String savedPath) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean isExtracting() {
        return false;
    }
    
    public final boolean isOptimizing() {
        return false;
    }
    
    public final boolean isSynthesizing() {
        return false;
    }
    
    public final boolean isSaving() {
        return false;
    }
    
    public final boolean isTransmitting() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ChimeraProject getCurrentProject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ui.viewmodel.SignalSource> getSelectedSignals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> getResultTimings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.FusionConfig getFusionConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSynthesizedOutput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.util.List<java.lang.Integer>> getPolymorphicVariants() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ui.viewmodel.AISuggestion> getAiSuggestions() {
        return null;
    }
    
    public final boolean getSaveSuccess() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSavedPath() {
        return null;
    }
    
    public ChimeraUiState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.FusionConfig component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.util.List<java.lang.Integer>> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ui.viewmodel.AISuggestion> component14() {
        return null;
    }
    
    public final boolean component15() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component16() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.vesper.flipper.domain.model.ChimeraProject component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.ui.viewmodel.SignalSource> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ui.viewmodel.ChimeraUiState copy(boolean isLoading, boolean isExtracting, boolean isOptimizing, boolean isSynthesizing, boolean isSaving, boolean isTransmitting, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.Nullable
    com.vesper.flipper.domain.model.ChimeraProject currentProject, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ui.viewmodel.SignalSource> selectedSignals, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> resultTimings, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.ui.viewmodel.FusionConfig fusionConfig, @org.jetbrains.annotations.Nullable
    java.lang.String synthesizedOutput, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.util.List<java.lang.Integer>> polymorphicVariants, @org.jetbrains.annotations.NotNull
    java.util.List<com.vesper.flipper.ui.viewmodel.AISuggestion> aiSuggestions, boolean saveSuccess, @org.jetbrains.annotations.Nullable
    java.lang.String savedPath) {
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