package com.vesper.flipper.domain.service;

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.vesper.flipper.domain.model.FileDiff;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Service for computing file diffs.
 * Shows what will change before any write operation.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/vesper/flipper/domain/service/DiffService;", "", "()V", "computeDiff", "Lcom/vesper/flipper/domain/model/FileDiff;", "originalContent", "", "newContent", "generateSideBySide", "", "Lcom/vesper/flipper/domain/service/DiffLine;", "diff", "app_debug"})
public final class DiffService {
    
    @javax.inject.Inject
    public DiffService() {
        super();
    }
    
    /**
     * Compute a diff between original and new content.
     */
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.FileDiff computeDiff(@org.jetbrains.annotations.Nullable
    java.lang.String originalContent, @org.jetbrains.annotations.NotNull
    java.lang.String newContent) {
        return null;
    }
    
    /**
     * Generate a side-by-side diff representation
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vesper.flipper.domain.service.DiffLine> generateSideBySide(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.FileDiff diff) {
        return null;
    }
}