package com.vesper.flipper.domain.service;

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.vesper.flipper.domain.model.FileDiff;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/vesper/flipper/domain/service/DiffLineType;", "", "(Ljava/lang/String;I)V", "UNCHANGED", "ADDED", "REMOVED", "CHANGED", "app_debug"})
public enum DiffLineType {
    /*public static final*/ UNCHANGED /* = new UNCHANGED() */,
    /*public static final*/ ADDED /* = new ADDED() */,
    /*public static final*/ REMOVED /* = new REMOVED() */,
    /*public static final*/ CHANGED /* = new CHANGED() */;
    
    DiffLineType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.service.DiffLineType> getEntries() {
        return null;
    }
}