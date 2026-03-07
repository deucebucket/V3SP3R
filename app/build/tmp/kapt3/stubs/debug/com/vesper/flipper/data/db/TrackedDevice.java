package com.vesper.flipper.data.db;

import android.content.Context;
import androidx.room.*;
import kotlinx.coroutines.flow.Flow;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001B\u00bb\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u001bJ\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0011H\u00c6\u0003J\t\u00106\u001a\u00020\u0011H\u00c6\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u00c6\u0003J\t\u00108\u001a\u00020\u0016H\u00c6\u0003J\t\u00109\u001a\u00020\u0016H\u00c6\u0003J\t\u0010:\u001a\u00020\u0019H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\fH\u00c6\u0003J\t\u0010C\u001a\u00020\u000eH\u00c6\u0003J\u00c5\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010E\u001a\u00020\u00112\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010G\u001a\u00020\u0019H\u00d6\u0001J\t\u0010H\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010$R\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010$R\u0011\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102\u00a8\u0006I"}, d2 = {"Lcom/vesper/flipper/data/db/TrackedDevice;", "", "id", "", "identifier", "name", "type", "Lcom/vesper/flipper/data/db/DeviceType;", "subType", "manufacturer", "model", "category", "Lcom/vesper/flipper/data/db/DeviceCategory;", "threat", "Lcom/vesper/flipper/data/db/ThreatLevel;", "alias", "isFavorite", "", "isHidden", "tags", "", "firstSeen", "", "lastSeen", "sightingCount", "", "metadata", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/data/db/DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/vesper/flipper/data/db/DeviceCategory;Lcom/vesper/flipper/data/db/ThreatLevel;Ljava/lang/String;ZZLjava/util/List;JJILjava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "getCategory", "()Lcom/vesper/flipper/data/db/DeviceCategory;", "getFirstSeen", "()J", "getId", "getIdentifier", "()Z", "getLastSeen", "getManufacturer", "getMetadata", "getModel", "getName", "getSightingCount", "()I", "getSubType", "getTags", "()Ljava/util/List;", "getThreat", "()Lcom/vesper/flipper/data/db/ThreatLevel;", "getType", "()Lcom/vesper/flipper/data/db/DeviceType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "tracked_devices")
public final class TrackedDevice {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String identifier = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.db.DeviceType type = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String subType = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String manufacturer = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String model = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.db.DeviceCategory category = null;
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.data.db.ThreatLevel threat = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String alias = null;
    private final boolean isFavorite = false;
    private final boolean isHidden = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> tags = null;
    private final long firstSeen = 0L;
    private final long lastSeen = 0L;
    private final int sightingCount = 0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String metadata = null;
    
    public TrackedDevice(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceType type, @org.jetbrains.annotations.Nullable
    java.lang.String subType, @org.jetbrains.annotations.Nullable
    java.lang.String manufacturer, @org.jetbrains.annotations.Nullable
    java.lang.String model, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceCategory category, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.ThreatLevel threat, @org.jetbrains.annotations.Nullable
    java.lang.String alias, boolean isFavorite, boolean isHidden, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> tags, long firstSeen, long lastSeen, int sightingCount, @org.jetbrains.annotations.Nullable
    java.lang.String metadata) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIdentifier() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.DeviceType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSubType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getManufacturer() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.DeviceCategory getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.ThreatLevel getThreat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAlias() {
        return null;
    }
    
    public final boolean isFavorite() {
        return false;
    }
    
    public final boolean isHidden() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    public final long getFirstSeen() {
        return 0L;
    }
    
    public final long getLastSeen() {
        return 0L;
    }
    
    public final int getSightingCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final long component15() {
        return 0L;
    }
    
    public final int component16() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.DeviceType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.DeviceCategory component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.ThreatLevel component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.TrackedDevice copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String identifier, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceType type, @org.jetbrains.annotations.Nullable
    java.lang.String subType, @org.jetbrains.annotations.Nullable
    java.lang.String manufacturer, @org.jetbrains.annotations.Nullable
    java.lang.String model, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceCategory category, @org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.ThreatLevel threat, @org.jetbrains.annotations.Nullable
    java.lang.String alias, boolean isFavorite, boolean isHidden, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> tags, long firstSeen, long lastSeen, int sightingCount, @org.jetbrains.annotations.Nullable
    java.lang.String metadata) {
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