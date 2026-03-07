package com.vesper.flipper.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Vesper Brand Colors - "Bond Noir"
val VesperOrange = Color(0xFFCDAA63)      // Gold accent
val VesperOrangeDark = Color(0xFF9E7A3F)
val VesperSecondary = Color(0xFF1D2A3A)   // Steel blue
val VesperAccent = Color(0xFF3ED9C8)      // Tactical cyan

// Surface Colors
val VesperSurface = Color(0xFF0F1622)
val VesperSurfaceVariant = Color(0xFF172131)
val VesperBackground = Color(0xFF05080F)
val VesperBackgroundDeep = Color(0xFF0A111C)
val VesperBackgroundGlow = Color(0xFF11223A)

val VesperBackdropBrush = Brush.verticalGradient(
    colors = listOf(
        VesperBackground,
        VesperBackgroundDeep,
        VesperBackgroundGlow,
        VesperBackground
    )
)

// Risk Colors
val RiskLow = Color(0xFF5ED39D)
val RiskMedium = Color(0xFFE0BF6B)
val RiskHigh = Color(0xFFFF6D6D)
val RiskBlocked = Color(0xFF8C99B3)

// Diff Colors
val DiffAdded = Color(0xFF3CBF88)
val DiffRemoved = Color(0xFFE06262)
val DiffChanged = Color(0xFFD1B062)
val DiffAddedBackground = Color(0x403CBF88)
val DiffRemovedBackground = Color(0x40E06262)

private val DarkColorScheme = darkColorScheme(
    primary = VesperOrange,
    onPrimary = Color(0xFF111213),
    primaryContainer = VesperOrangeDark,
    onPrimaryContainer = Color(0xFFF8E9C8),
    secondary = VesperSecondary,
    onSecondary = Color(0xFFCAD8EA),
    secondaryContainer = VesperSurfaceVariant,
    onSecondaryContainer = Color(0xFFD5E2F4),
    tertiary = VesperAccent,
    onTertiary = Color(0xFF051414),
    background = VesperBackground,
    onBackground = Color(0xFFE6EDF8),
    surface = VesperSurface,
    onSurface = Color(0xFFE8EEF7),
    surfaceVariant = VesperSurfaceVariant,
    onSurfaceVariant = Color(0xFF9EADC3),
    outline = Color(0xFF34465E),
    outlineVariant = Color(0xFF24354A),
    error = RiskHigh,
    onError = Color(0xFF200909)
)

private val LightColorScheme = lightColorScheme(
    primary = VesperOrange,
    onPrimary = Color(0xFF1A1B1C),
    primaryContainer = Color(0xFFFFE3B0),
    onPrimaryContainer = Color(0xFF4D3618),
    secondary = VesperSecondary,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFDCE8F5),
    onSecondaryContainer = Color(0xFF1D2A3A),
    tertiary = VesperAccent,
    onTertiary = Color(0xFF001211),
    background = Color(0xFFF2F5FA),
    onBackground = Color(0xFF121A25),
    surface = Color.White,
    onSurface = Color(0xFF111821),
    surfaceVariant = Color(0xFFE8EDF5),
    onSurfaceVariant = Color(0xFF455A72),
    outline = Color(0xFF61758E),
    outlineVariant = Color(0xFFB4C0CE),
    error = RiskHigh,
    onError = Color.White
)

private val VesperShapes = Shapes(
    extraSmall = RoundedCornerShape(6.dp),
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(14.dp),
    large = RoundedCornerShape(18.dp),
    extraLarge = RoundedCornerShape(24.dp)
)

private val BaseTypography = androidx.compose.material3.Typography()

val VesperTypography = BaseTypography.copy(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 56.sp,
        letterSpacing = 0.8.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        letterSpacing = 0.4.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        letterSpacing = 0.2.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        letterSpacing = 0.15.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.2.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        letterSpacing = 0.4.sp
    )
)

@Composable
fun VesperTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = VesperTypography,
        shapes = VesperShapes,
        content = content
    )
}
