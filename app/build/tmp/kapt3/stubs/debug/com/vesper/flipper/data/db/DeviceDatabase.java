package com.vesper.flipper.data.db;

import android.content.Context;
import androidx.room.*;
import kotlinx.coroutines.flow.Flow;
import java.util.UUID;

/**
 * Device Tracking Database
 *
 * Tracks all discovered devices across different protocols:
 * - BLE devices (phones, wearables, beacons)
 * - Sub-GHz devices (remotes, sensors, key fobs)
 * - NFC/RFID tags
 * - WiFi access points (via ESP32 Marauder)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/vesper/flipper/data/db/DeviceDatabase;", "Landroidx/room/RoomDatabase;", "()V", "deviceDao", "Lcom/vesper/flipper/data/db/DeviceDao;", "noteDao", "Lcom/vesper/flipper/data/db/NoteDao;", "sightingDao", "Lcom/vesper/flipper/data/db/SightingDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.vesper.flipper.data.db.TrackedDevice.class, com.vesper.flipper.data.db.DeviceSighting.class, com.vesper.flipper.data.db.DeviceNote.class}, version = 1, exportSchema = true)
@androidx.room.TypeConverters(value = {com.vesper.flipper.data.db.Converters.class})
public abstract class DeviceDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.vesper.flipper.data.db.DeviceDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.data.db.DeviceDatabase.Companion Companion = null;
    
    public DeviceDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.vesper.flipper.data.db.DeviceDao deviceDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.vesper.flipper.data.db.SightingDao sightingDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.vesper.flipper.data.db.NoteDao noteDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/vesper/flipper/data/db/DeviceDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/vesper/flipper/data/db/DeviceDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.data.db.DeviceDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}