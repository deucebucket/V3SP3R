package com.vesper.flipper.data.db;

import android.content.Context;
import androidx.room.*;
import kotlinx.coroutines.flow.Flow;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/vesper/flipper/data/db/Converters;", "", "()V", "fromDeviceCategory", "", "value", "Lcom/vesper/flipper/data/db/DeviceCategory;", "fromDeviceType", "Lcom/vesper/flipper/data/db/DeviceType;", "fromStringList", "", "fromThreatLevel", "Lcom/vesper/flipper/data/db/ThreatLevel;", "toDeviceCategory", "toDeviceType", "toStringList", "toThreatLevel", "app_debug"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fromDeviceType(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceType value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.DeviceType toDeviceType(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fromDeviceCategory(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceCategory value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.DeviceCategory toDeviceCategory(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fromThreatLevel(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.ThreatLevel value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.ThreatLevel toThreatLevel(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fromStringList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> toStringList(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
}