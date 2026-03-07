package com.vesper.flipper.ui.theme;

import androidx.compose.material3.Shapes;
import androidx.compose.material3.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002082\u0011\u00109\u001a\r\u0012\u0004\u0012\u0002060:\u00a2\u0006\u0002\b;H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0013\u0010\t\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007\"\u0013\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007\"\u0013\u0010\r\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007\"\u0013\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007\"\u0013\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007\"\u0013\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u0013\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u0013\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001b\u0010\u0007\"\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0013\u0010 \u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b!\u0010\u0007\"\u0013\u0010\"\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b#\u0010\u0007\"\u0013\u0010$\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b%\u0010\u0007\"\u0013\u0010&\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\'\u0010\u0007\"\u0013\u0010(\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b)\u0010\u0007\"\u0013\u0010*\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b+\u0010\u0007\"\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0013\u0010.\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b/\u0010\u0007\"\u0013\u00100\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b1\u0010\u0007\"\u0011\u00102\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104\u00a8\u0006<"}, d2 = {"BaseTypography", "Landroidx/compose/material3/Typography;", "DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "DiffAdded", "Landroidx/compose/ui/graphics/Color;", "getDiffAdded", "()J", "J", "DiffAddedBackground", "getDiffAddedBackground", "DiffChanged", "getDiffChanged", "DiffRemoved", "getDiffRemoved", "DiffRemovedBackground", "getDiffRemovedBackground", "LightColorScheme", "RiskBlocked", "getRiskBlocked", "RiskHigh", "getRiskHigh", "RiskLow", "getRiskLow", "RiskMedium", "getRiskMedium", "VesperAccent", "getVesperAccent", "VesperBackdropBrush", "Landroidx/compose/ui/graphics/Brush;", "getVesperBackdropBrush", "()Landroidx/compose/ui/graphics/Brush;", "VesperBackground", "getVesperBackground", "VesperBackgroundDeep", "getVesperBackgroundDeep", "VesperBackgroundGlow", "getVesperBackgroundGlow", "VesperOrange", "getVesperOrange", "VesperOrangeDark", "getVesperOrangeDark", "VesperSecondary", "getVesperSecondary", "VesperShapes", "Landroidx/compose/material3/Shapes;", "VesperSurface", "getVesperSurface", "VesperSurfaceVariant", "getVesperSurfaceVariant", "VesperTypography", "getVesperTypography", "()Landroidx/compose/material3/Typography;", "VesperTheme", "", "darkTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "app_debug"})
public final class ThemeKt {
    private static final long VesperOrange = 0L;
    private static final long VesperOrangeDark = 0L;
    private static final long VesperSecondary = 0L;
    private static final long VesperAccent = 0L;
    private static final long VesperSurface = 0L;
    private static final long VesperSurfaceVariant = 0L;
    private static final long VesperBackground = 0L;
    private static final long VesperBackgroundDeep = 0L;
    private static final long VesperBackgroundGlow = 0L;
    @org.jetbrains.annotations.NotNull
    private static final androidx.compose.ui.graphics.Brush VesperBackdropBrush = null;
    private static final long RiskLow = 0L;
    private static final long RiskMedium = 0L;
    private static final long RiskHigh = 0L;
    private static final long RiskBlocked = 0L;
    private static final long DiffAdded = 0L;
    private static final long DiffRemoved = 0L;
    private static final long DiffChanged = 0L;
    private static final long DiffAddedBackground = 0L;
    private static final long DiffRemovedBackground = 0L;
    @org.jetbrains.annotations.NotNull
    private static final androidx.compose.material3.ColorScheme DarkColorScheme = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.compose.material3.ColorScheme LightColorScheme = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.compose.material3.Shapes VesperShapes = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.compose.material3.Typography BaseTypography = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.compose.material3.Typography VesperTypography = null;
    
    public static final long getVesperOrange() {
        return 0L;
    }
    
    public static final long getVesperOrangeDark() {
        return 0L;
    }
    
    public static final long getVesperSecondary() {
        return 0L;
    }
    
    public static final long getVesperAccent() {
        return 0L;
    }
    
    public static final long getVesperSurface() {
        return 0L;
    }
    
    public static final long getVesperSurfaceVariant() {
        return 0L;
    }
    
    public static final long getVesperBackground() {
        return 0L;
    }
    
    public static final long getVesperBackgroundDeep() {
        return 0L;
    }
    
    public static final long getVesperBackgroundGlow() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final androidx.compose.ui.graphics.Brush getVesperBackdropBrush() {
        return null;
    }
    
    public static final long getRiskLow() {
        return 0L;
    }
    
    public static final long getRiskMedium() {
        return 0L;
    }
    
    public static final long getRiskHigh() {
        return 0L;
    }
    
    public static final long getRiskBlocked() {
        return 0L;
    }
    
    public static final long getDiffAdded() {
        return 0L;
    }
    
    public static final long getDiffRemoved() {
        return 0L;
    }
    
    public static final long getDiffChanged() {
        return 0L;
    }
    
    public static final long getDiffAddedBackground() {
        return 0L;
    }
    
    public static final long getDiffRemovedBackground() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final androidx.compose.material3.Typography getVesperTypography() {
        return null;
    }
    
    @androidx.compose.runtime.Composable
    public static final void VesperTheme(boolean darkTheme, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
}