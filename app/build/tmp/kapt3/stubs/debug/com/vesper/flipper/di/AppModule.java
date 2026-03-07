package com.vesper.flipper.di;

import android.content.Context;
import com.vesper.flipper.data.database.AuditDao;
import com.vesper.flipper.data.database.ChatDao;
import com.vesper.flipper.data.database.VesperDatabase;
import com.vesper.flipper.data.db.DeviceDao;
import com.vesper.flipper.data.db.DeviceDatabase;
import com.vesper.flipper.data.db.NoteDao;
import com.vesper.flipper.data.db.SightingDao;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u000bH\u0007J\u0012\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/vesper/flipper/di/AppModule;", "", "()V", "provideAuditDao", "Lcom/vesper/flipper/data/database/AuditDao;", "database", "Lcom/vesper/flipper/data/database/VesperDatabase;", "provideChatDao", "Lcom/vesper/flipper/data/database/ChatDao;", "provideDeviceDao", "Lcom/vesper/flipper/data/db/DeviceDao;", "Lcom/vesper/flipper/data/db/DeviceDatabase;", "provideDeviceDatabase", "context", "Landroid/content/Context;", "provideNoteDao", "Lcom/vesper/flipper/data/db/NoteDao;", "provideSightingDao", "Lcom/vesper/flipper/data/db/SightingDao;", "provideVesperDatabase", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.database.VesperDatabase provideVesperDatabase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.database.AuditDao provideAuditDao(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.database.VesperDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.database.ChatDao provideChatDao(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.database.VesperDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.DeviceDatabase provideDeviceDatabase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.DeviceDao provideDeviceDao(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.SightingDao provideSightingDao(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.data.db.NoteDao provideNoteDao(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.data.db.DeviceDatabase database) {
        return null;
    }
}