package com.vesper.flipper.domain.service;

import com.vesper.flipper.data.database.AuditDao;
import com.vesper.flipper.data.database.AuditEntryEntity;
import com.vesper.flipper.domain.model.*;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.*;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Audit logging service.
 * All agent actions are logged for accountability and replay.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0014J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ$\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0018J\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u001e2\u0006\u0010#\u001a\u00020\u001cJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u001e2\b\b\u0002\u0010!\u001a\u00020\u0018J\u0016\u0010$\u001a\u00020%2\u0006\u0010#\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010&J\u000e\u0010\'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010\u0015J\u0012\u0010*\u001a\u00020\n2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001cR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/vesper/flipper/domain/service/AuditService;", "", "auditDao", "Lcom/vesper/flipper/data/database/AuditDao;", "(Lcom/vesper/flipper/data/database/AuditDao;)V", "_recentEntries", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/vesper/flipper/domain/model/AuditEntry;", "currentSession", "Lcom/vesper/flipper/domain/model/AuditSession;", "json", "Lkotlinx/serialization/json/Json;", "recentEntries", "Lkotlinx/coroutines/flow/StateFlow;", "getRecentEntries", "()Lkotlinx/coroutines/flow/StateFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "clearAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearOlderThan", "days", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSession", "getCurrentSessionId", "", "getEntriesByType", "Lkotlinx/coroutines/flow/Flow;", "actionType", "Lcom/vesper/flipper/domain/model/AuditActionType;", "limit", "getEntriesForSession", "sessionId", "getSessionSummary", "Lcom/vesper/flipper/domain/model/AuditSummary;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "log", "entry", "refreshRecentEntries", "startSession", "deviceName", "app_debug"})
public final class AuditService {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.database.AuditDao auditDao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.serialization.json.Json json = null;
    @org.jetbrains.annotations.Nullable
    private com.vesper.flipper.domain.model.AuditSession currentSession;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.domain.model.AuditEntry>> _recentEntries = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.AuditEntry>> recentEntries = null;
    
    @javax.inject.Inject
    public AuditService(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.database.AuditDao auditDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.domain.model.AuditEntry>> getRecentEntries() {
        return null;
    }
    
    /**
     * Start a new audit session
     */
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.domain.model.AuditSession startSession(@org.jetbrains.annotations.Nullable
    java.lang.String deviceName) {
        return null;
    }
    
    /**
     * End the current session
     */
    public final void endSession() {
    }
    
    /**
     * Log an audit entry
     */
    public final void log(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AuditEntry entry) {
    }
    
    /**
     * Get entries for a session
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.domain.model.AuditEntry>> getEntriesForSession(@org.jetbrains.annotations.NotNull
    java.lang.String sessionId) {
        return null;
    }
    
    /**
     * Get recent entries across all sessions
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.domain.model.AuditEntry>> getRecentEntries(int limit) {
        return null;
    }
    
    /**
     * Get entries by action type
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.domain.model.AuditEntry>> getEntriesByType(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.domain.model.AuditActionType actionType, int limit) {
        return null;
    }
    
    /**
     * Get summary statistics for a session
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSessionSummary(@org.jetbrains.annotations.NotNull
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.domain.model.AuditSummary> $completion) {
        return null;
    }
    
    /**
     * Clear all audit logs
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearAll(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Clear old audit logs (older than specified days)
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearOlderThan(int days, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object refreshRecentEntries(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentSessionId() {
        return null;
    }
}