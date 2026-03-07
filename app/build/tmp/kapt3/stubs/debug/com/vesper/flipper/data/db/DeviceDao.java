package com.vesper.flipper.data.db;

import android.content.Context;
import androidx.room.*;
import kotlinx.coroutines.flow.Flow;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0017\u001a\u00020\u0018H\'J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010\u001b\u001a\u00020\u001cH\'J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010 \u001a\u00020\tH\'J \u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u00a7@\u00a2\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020\'H\u00a7@\u00a2\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020\'H\u00a7@\u00a2\u0006\u0002\u0010(J \u0010+\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010,\u001a\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010-J\u001e\u0010.\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010/\u001a\u000200H\u00a7@\u00a2\u0006\u0002\u00101\u00a8\u00062"}, d2 = {"Lcom/vesper/flipper/data/db/DeviceDao;", "", "deleteDevice", "", "device", "Lcom/vesper/flipper/data/db/TrackedDevice;", "(Lcom/vesper/flipper/data/db/TrackedDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDeviceById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDevices", "Lkotlinx/coroutines/flow/Flow;", "", "getDeviceById", "getDeviceByIdentifier", "identifier", "getDeviceCount", "", "getDevicesByCategory", "category", "Lcom/vesper/flipper/data/db/DeviceCategory;", "getDevicesByType", "type", "Lcom/vesper/flipper/data/db/DeviceType;", "getFavoriteDevices", "getRecentDeviceCount", "since", "", "getVisibleDevices", "insertDevice", "searchDevices", "query", "updateAlias", "alias", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDevice", "updateFavorite", "favorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHidden", "hidden", "updateSighting", "timestamp", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateThreatLevel", "threat", "Lcom/vesper/flipper/data/db/ThreatLevel;", "(Ljava/lang/String;Lcom/vesper/flipper/data/db/ThreatLevel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface DeviceDao {
    
    @androidx.room.Query(value = "SELECT * FROM tracked_devices ORDER BY lastSeen DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getAllDevices();
    
    @androidx.room.Query(value = "SELECT * FROM tracked_devices WHERE type = :type ORDER BY lastSeen DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getDevicesByType(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceType type);
    
    @androidx.room.Query(value = "SELECT * FROM tracked_devices WHERE category = :category ORDER BY lastSeen DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getDevicesByCategory(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceCategory category);
    
    @androidx.room.Query(value = "SELECT * FROM tracked_devices WHERE isFavorite = 1 ORDER BY lastSeen DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getFavoriteDevices();
    
    @androidx.room.Query(value = "SELECT * FROM tracked_devices WHERE isHidden = 0 ORDER BY lastSeen DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> getVisibleDevices();
    
    @androidx.room.Query(value = "SELECT * FROM tracked_devices WHERE identifier = :identifier LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDeviceByIdentifier(@org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.data.db.TrackedDevice> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tracked_devices WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDeviceById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.data.db.TrackedDevice> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tracked_devices WHERE name LIKE \'%\' || :query || \'%\' OR alias LIKE \'%\' || :query || \'%\' OR identifier LIKE \'%\' || :query || \'%\'")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.vesper.flipper.data.db.TrackedDevice>> searchDevices(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM tracked_devices")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getDeviceCount();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM tracked_devices WHERE lastSeen > :since")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getRecentDeviceCount(long since);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertDevice(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateDevice(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteDevice(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.TrackedDevice device, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM tracked_devices WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteDeviceById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE tracked_devices SET lastSeen = :timestamp, sightingCount = sightingCount + 1 WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateSighting(@org.jetbrains.annotations.NotNull
    java.lang.String id, long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE tracked_devices SET alias = :alias WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateAlias(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.Nullable
    java.lang.String alias, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE tracked_devices SET isFavorite = :favorite WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean favorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE tracked_devices SET isHidden = :hidden WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateHidden(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean hidden, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE tracked_devices SET threat = :threat WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateThreatLevel(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.ThreatLevel threat, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}