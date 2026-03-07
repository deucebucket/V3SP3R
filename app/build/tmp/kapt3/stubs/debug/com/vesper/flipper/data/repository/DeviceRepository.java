package com.vesper.flipper.data.repository;

import com.vesper.flipper.data.db.*;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Device Repository
 *
 * Provides access to device tracking data with intelligent
 * device classification and fingerprinting.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 X2\u00020\u0001:\u0001XB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J0\u0010\u0013\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J,\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0002J0\u0010\u001e\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00142\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0002J0\u0010 \u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00142\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0002J0\u0010!\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020$H\u0086@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\f2\u0006\u0010\'\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0086@\u00a2\u0006\u0002\u0010,J\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190/0.J\u0018\u00100\u001a\u0004\u0018\u00010\u00192\u0006\u00101\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u00102J\u0018\u00103\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u00102J\f\u00104\u001a\b\u0012\u0004\u0012\u00020$0.J\u001a\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190/0.2\u0006\u00106\u001a\u00020\u0015J\u001a\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190/0.2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190/0.J\u001a\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0/0.2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020$0.2\u0006\u0010;\u001a\u00020<J$\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0/0.2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010?\u001a\u00020$J\u001a\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0/0.2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190/0.Jd\u0010B\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010FH\u0086@\u00a2\u0006\u0002\u0010HJ\u001a\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190/0.2\u0006\u0010J\u001a\u00020\u000eJ \u0010K\u001a\u00020\f2\u0006\u00101\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010MJ\u001e\u0010N\u001a\u00020\f2\u0006\u00101\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010PJ\u001e\u0010Q\u001a\u00020\f2\u0006\u00101\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010PJ\u001e\u0010S\u001a\u00020\f2\u0006\u00101\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020UH\u0086@\u00a2\u0006\u0002\u0010VJ\u0016\u0010W\u001a\u00020\f2\u0006\u0010\'\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006Y"}, d2 = {"Lcom/vesper/flipper/data/repository/DeviceRepository;", "", "database", "Lcom/vesper/flipper/data/db/DeviceDatabase;", "(Lcom/vesper/flipper/data/db/DeviceDatabase;)V", "deviceDao", "Lcom/vesper/flipper/data/db/DeviceDao;", "noteDao", "Lcom/vesper/flipper/data/db/NoteDao;", "sightingDao", "Lcom/vesper/flipper/data/db/SightingDao;", "addNote", "", "deviceId", "", "content", "isAiGenerated", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classifyBleDevice", "Lkotlin/Triple;", "Lcom/vesper/flipper/data/db/DeviceCategory;", "mac", "name", "classifyDevice", "Lcom/vesper/flipper/data/db/TrackedDevice;", "identifier", "type", "Lcom/vesper/flipper/data/db/DeviceType;", "metadata", "classifyNfcDevice", "uid", "classifySubGhzDevice", "classifyWifiDevice", "cleanupOldSightings", "daysToKeep", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDevice", "device", "(Lcom/vesper/flipper/data/db/TrackedDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNote", "note", "Lcom/vesper/flipper/data/db/DeviceNote;", "(Lcom/vesper/flipper/data/db/DeviceNote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDevices", "Lkotlinx/coroutines/flow/Flow;", "", "getDeviceById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceByIdentifier", "getDeviceCount", "getDevicesByCategory", "category", "getDevicesByType", "getFavoriteDevices", "getNotesForDevice", "getRecentDeviceCount", "since", "", "getRecentSightings", "Lcom/vesper/flipper/data/db/DeviceSighting;", "limit", "getSightingsForDevice", "getVisibleDevices", "recordDevice", "rssi", "frequency", "latitude", "", "longitude", "(Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/data/db/DeviceType;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchDevices", "query", "setDeviceAlias", "alias", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeviceFavorite", "favorite", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeviceHidden", "hidden", "setThreatLevel", "threat", "Lcom/vesper/flipper/data/db/ThreatLevel;", "(Ljava/lang/String;Lcom/vesper/flipper/data/db/ThreatLevel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDevice", "Companion", "app_debug"})
public final class DeviceRepository {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.db.DeviceDatabase database = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.db.DeviceDao deviceDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.db.SightingDao sightingDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.db.NoteDao noteDao = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.Map<java.lang.String, java.lang.String> BLE_MANUFACTURERS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.Map<java.lang.String, java.lang.String> WIFI_MANUFACTURERS = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.data.repository.DeviceRepository.Companion Companion = null;
    
    @javax.inject.Inject
    public DeviceRepository(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getAllDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getDevicesByType(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceType type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getDevicesByCategory(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceCategory category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getFavoriteDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getVisibleDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> searchDevices(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getDeviceCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getRecentDeviceCount(long since) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDeviceById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.data.db.TrackedDevice> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDeviceByIdentifier(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.data.db.TrackedDevice> $completion) {
        return null;
    }
    
    /**
     * Record a device sighting - creates new device if not seen before,
     * or updates existing device's last seen time and sighting count.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object recordDevice(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceType type, @org.jetbrains.annotations.Nullable
    java.lang.Integer rssi, @org.jetbrains.annotations.Nullable
    java.lang.Long frequency, @org.jetbrains.annotations.Nullable
    java.lang.String metadata, @org.jetbrains.annotations.Nullable
    java.lang.Double latitude, @org.jetbrains.annotations.Nullable
    java.lang.Double longitude, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.data.db.TrackedDevice> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateDevice(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteDevice(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDeviceAlias(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.Nullable
    java.lang.String alias, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDeviceFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean favorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDeviceHidden(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean hidden, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setThreatLevel(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.ThreatLevel threat, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.DeviceSighting>> getSightingsForDevice(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.DeviceSighting>> getRecentSightings(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId, int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object cleanupOldSightings(int daysToKeep, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.DeviceNote>> getNotesForDevice(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addNote(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull
    java.lang.String content, boolean isAiGenerated, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceNote note, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Auto-classify a device based on its identifier, name, and type.
     * Uses manufacturer prefixes and known patterns.
     */
    private final com.vesper.flipper.data.db.TrackedDevice classifyDevice(java.lang.String identifier, java.lang.String name, com.vesper.flipper.data.db.DeviceType type, java.lang.String metadata) {
        return null;
    }
    
    private final kotlin.Triple<java.lang.String, com.vesper.flipper.data.db.DeviceCategory, java.lang.String> classifyBleDevice(java.lang.String mac, java.lang.String name) {
        return null;
    }
    
    private final kotlin.Triple<java.lang.String, com.vesper.flipper.data.db.DeviceCategory, java.lang.String> classifyWifiDevice(java.lang.String mac, java.lang.String name) {
        return null;
    }
    
    private final kotlin.Triple<java.lang.String, com.vesper.flipper.data.db.DeviceCategory, java.lang.String> classifySubGhzDevice(java.lang.String identifier, java.lang.String metadata) {
        return null;
    }
    
    private final kotlin.Triple<java.lang.String, com.vesper.flipper.data.db.DeviceCategory, java.lang.String> classifyNfcDevice(java.lang.String uid, java.lang.String metadata) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/vesper/flipper/data/repository/DeviceRepository$Companion;", "", "()V", "BLE_MANUFACTURERS", "", "", "WIFI_MANUFACTURERS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}