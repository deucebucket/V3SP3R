package com.vesper.flipper.domain.model;

/**
 * The Chimera synthesis engine
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0002J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0002J\u001e\u0010\u0012\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J$\u0010!\u001a\u00020\u00152\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0002J*\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017\u00a8\u0006\'"}, d2 = {"Lcom/vesper/flipper/domain/model/ChimeraSplicer;", "", "()V", "applyMutation", "Lcom/vesper/flipper/domain/model/SignalGene;", "gene", "mutation", "Lcom/vesper/flipper/domain/model/Mutation;", "applyMutations", "", "genes", "mutations", "applyPolymorphism", "", "timing", "seed", "", "detectPreambleEnd", "detectSyncEnd", "start", "exportToFlipper", "", "project", "Lcom/vesper/flipper/domain/model/ChimeraProject;", "extractGenes", "signal", "Lcom/vesper/flipper/domain/model/SignalCapture$SubGhz;", "fuseAdaptive", "fuseDominant", "fuseInterleaved", "fuseLayered", "fuseRandom", "fuseSequential", "generateStats", "generateVisualization", "Lcom/vesper/flipper/domain/model/ChimeraVisualization;", "finalTiming", "synthesize", "Lcom/vesper/flipper/domain/model/ChimeraOutput;", "app_debug"})
public final class ChimeraSplicer {
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.ChimeraSplicer INSTANCE = null;
    
    private ChimeraSplicer() {
        super();
    }
    
    /**
     * Synthesize a chimera into raw timing data
     */
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.ChimeraOutput synthesize(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ChimeraProject project) {
        return null;
    }
    
    private final java.util.List<com.vesper.flipper.domain.model.SignalGene> applyMutations(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes, java.util.List<com.vesper.flipper.domain.model.Mutation> mutations) {
        return null;
    }
    
    private final com.vesper.flipper.domain.model.SignalGene applyMutation(com.vesper.flipper.domain.model.SignalGene gene, com.vesper.flipper.domain.model.Mutation mutation) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> fuseSequential(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> fuseInterleaved(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> fuseLayered(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> fuseDominant(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> fuseRandom(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes, long seed) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> fuseAdaptive(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> applyPolymorphism(java.util.List<java.lang.Integer> timing, long seed) {
        return null;
    }
    
    private final java.util.List<com.vesper.flipper.domain.model.ChimeraVisualization> generateVisualization(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes, java.util.List<java.lang.Integer> finalTiming) {
        return null;
    }
    
    private final java.lang.String generateStats(java.util.List<com.vesper.flipper.domain.model.SignalGene> genes, java.util.List<java.lang.Integer> timing) {
        return null;
    }
    
    /**
     * Export chimera to Flipper .sub format
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String exportToFlipper(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.ChimeraProject project) {
        return null;
    }
    
    /**
     * Extract genes from a signal
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.model.SignalGene> extractGenes(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.SignalCapture.SubGhz signal) {
        return null;
    }
    
    private final int detectPreambleEnd(java.util.List<java.lang.Integer> timing) {
        return 0;
    }
    
    private final int detectSyncEnd(java.util.List<java.lang.Integer> timing, int start) {
        return 0;
    }
}