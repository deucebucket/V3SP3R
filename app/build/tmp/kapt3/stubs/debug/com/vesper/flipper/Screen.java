package com.vesper.flipper;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.core.content.ContextCompat;
import com.vesper.flipper.ble.FlipperBleService;
import com.vesper.flipper.ui.screen.*;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u0082\u0001\u000b\u001a\u001b\u001c\u001d\u001e\u001f !\"#$\u00a8\u0006%"}, d2 = {"Lcom/vesper/flipper/Screen;", "", "route", "", "title", "selectedIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "unselectedIcon", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getRoute", "()Ljava/lang/String;", "getSelectedIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getTitle", "getUnselectedIcon", "Alchemy", "Arsenal", "Audit", "Chat", "Device", "FapHub", "Files", "OpsCenter", "Oracle", "PayloadLab", "Settings", "Lcom/vesper/flipper/Screen$Alchemy;", "Lcom/vesper/flipper/Screen$Arsenal;", "Lcom/vesper/flipper/Screen$Audit;", "Lcom/vesper/flipper/Screen$Chat;", "Lcom/vesper/flipper/Screen$Device;", "Lcom/vesper/flipper/Screen$FapHub;", "Lcom/vesper/flipper/Screen$Files;", "Lcom/vesper/flipper/Screen$OpsCenter;", "Lcom/vesper/flipper/Screen$Oracle;", "Lcom/vesper/flipper/Screen$PayloadLab;", "Lcom/vesper/flipper/Screen$Settings;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.ui.graphics.vector.ImageVector selectedIcon = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.ui.graphics.vector.ImageVector unselectedIcon = null;
    
    private Screen(java.lang.String route, java.lang.String title, androidx.compose.ui.graphics.vector.ImageVector selectedIcon, androidx.compose.ui.graphics.vector.ImageVector unselectedIcon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.ui.graphics.vector.ImageVector getSelectedIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.ui.graphics.vector.ImageVector getUnselectedIcon() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$Alchemy;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class Alchemy extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.Alchemy INSTANCE = null;
        
        private Alchemy() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$Arsenal;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class Arsenal extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.Arsenal INSTANCE = null;
        
        private Arsenal() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$Audit;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class Audit extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.Audit INSTANCE = null;
        
        private Audit() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$Chat;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class Chat extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.Chat INSTANCE = null;
        
        private Chat() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$Device;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class Device extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.Device INSTANCE = null;
        
        private Device() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$FapHub;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class FapHub extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.FapHub INSTANCE = null;
        
        private FapHub() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$Files;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class Files extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.Files INSTANCE = null;
        
        private Files() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$OpsCenter;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class OpsCenter extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.OpsCenter INSTANCE = null;
        
        private OpsCenter() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$Oracle;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class Oracle extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.Oracle INSTANCE = null;
        
        private Oracle() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$PayloadLab;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class PayloadLab extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.PayloadLab INSTANCE = null;
        
        private PayloadLab() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/vesper/flipper/Screen$Settings;", "Lcom/vesper/flipper/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.vesper.flipper.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.vesper.flipper.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
}