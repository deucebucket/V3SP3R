package com.vesper.flipper.domain.model;

/**
 * Signal synthesis engine
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\tJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalAlchemist;", "", "()V", "exportToFlipperFormat", "", "project", "Lcom/vesper/flipper/domain/model/AlchemyProject;", "generateBurst", "", "", "layer", "Lcom/vesper/flipper/domain/model/SignalLayer;", "generateCarrier", "generateDataBits", "generateLayerData", "modulation", "Lcom/vesper/flipper/domain/model/ModulationType;", "generateNoise", "generatePreamble", "generateSweep", "generateSync", "generateWaveformPreview", "", "width", "synthesize", "app_debug"})
public final class SignalAlchemist {
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.SignalAlchemist INSTANCE = null;
    
    private SignalAlchemist() {
        super();
    }
    
    /**
     * Generate RAW timing data from an Alchemy project
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> synthesize(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AlchemyProject project) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generateLayerData(com.vesper.flipper.domain.model.SignalLayer layer, com.vesper.flipper.domain.model.ModulationType modulation) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generateCarrier(com.vesper.flipper.domain.model.SignalLayer layer) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generateDataBits(com.vesper.flipper.domain.model.SignalLayer layer) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generatePreamble(com.vesper.flipper.domain.model.SignalLayer layer) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generateSync(com.vesper.flipper.domain.model.SignalLayer layer) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generateNoise(com.vesper.flipper.domain.model.SignalLayer layer) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generateSweep(com.vesper.flipper.domain.model.SignalLayer layer) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generateBurst(com.vesper.flipper.domain.model.SignalLayer layer) {
        return null;
    }
    
    /**
     * Export project to Flipper .sub file format
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String exportToFlipperFormat(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AlchemyProject project) {
        return null;
    }
    
    /**
     * Generate waveform visualization data
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Float> generateWaveformPreview(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AlchemyProject project, int width) {
        return null;
    }
}