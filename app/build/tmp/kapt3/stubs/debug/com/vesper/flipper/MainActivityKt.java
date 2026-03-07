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

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0007\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"screens", "", "Lcom/vesper/flipper/Screen;", "getScreens", "()Ljava/util/List;", "VesperApp", "", "app_debug"})
public final class MainActivityKt {
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<com.vesper.flipper.Screen> screens = null;
    
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<com.vesper.flipper.Screen> getScreens() {
        return null;
    }
    
    @androidx.compose.runtime.Composable
    public static final void VesperApp() {
    }
}