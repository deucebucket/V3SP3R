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

// ═══════════════════════════════════════════════════════════
// delphinOS BRAND — Cybernetic Orange on Black
// Matches the Flipper Zero LCD aesthetic (orange on dark)
// ═══════════════════════════════════════════════════════════

// Primary: Flipper Orange — the signal, the eye, the circuit glow
val DelphinOrange = Color(0xFFFF8800)           // Classic Flipper orange
val DelphinOrangeLight = Color(0xFFFFAA33)      // Lighter for highlights
val DelphinOrangeDark = Color(0xFFCC6600)       // Darker for pressed states
val DelphinAmber = Color(0xFFFFAA00)            // Warm amber for accents

// Legacy aliases — keeps existing references working
val VesperWine = DelphinOrange
val VesperWineLight = DelphinOrangeLight
val VesperWineDark = DelphinOrangeDark
val VesperOrange = DelphinOrange
val VesperOrangeDark = DelphinOrangeDark

// Secondary: Deep Black — the void behind the signal
val DelphinBlack = Color(0xFF0A0A14)            // Near-black with blue hint
val DelphinGunmetal = Color(0xFF1A1A2E)         // Matches simulator background
val VesperSecondary = DelphinBlack
val VesperGunmetal = DelphinGunmetal

// Accent: Cyan — sonar ping, data flow, neural network
val DelphinCyan = Color(0xFF00CCFF)             // Electric cyan
val DelphinCyanDim = Color(0xFF0088AA)          // Dimmed for secondary
val VesperAccent = DelphinCyan
val VesperGold = DelphinCyan
val VesperGoldMuted = DelphinCyanDim

// Surface Colors — deep black palette
val VesperSurface = Color(0xFF0E0E1A)
val VesperSurfaceVariant = Color(0xFF141428)
val VesperBackground = Color(0xFF060610)
val VesperBackgroundDeep = Color(0xFF030308)
val VesperBackgroundGlow = Color(0xFF0D0A10)

val VesperBackdropBrush = Brush.verticalGradient(
    colors = listOf(
        VesperBackground,
        VesperBackgroundDeep,
        Color(0xFF0A0814),  // Subtle orange tint in the depths
        VesperBackground
    )
)

// Risk Colors
val RiskLow = Color(0xFF4CAF7D)
val RiskMedium = DelphinAmber
val RiskHigh = Color(0xFFFF4444)
val RiskBlocked = Color(0xFF6B7394)

// Diff Colors
val DiffAdded = Color(0xFF3CBF88)
val DiffRemoved = Color(0xFFFF4444)
val DiffChanged = DelphinAmber
val DiffAddedBackground = Color(0x403CBF88)
val DiffRemovedBackground = Color(0x40FF4444)

// Chat Colors
val ChatAssistant = Color(0xFF141428)           // Dark surface bubble
val ChatUser = DelphinOrangeDark                // Orange bubble for user
val ChatTool = Color(0xFF0A0A18)                // Even darker for tool results
val ChatToolAccent = DelphinCyan                // Cyan for tool highlights

private val DarkColorScheme = darkColorScheme(
    primary = DelphinOrange,
    onPrimary = Color(0xFF1A0E00),
    primaryContainer = DelphinOrangeDark,
    onPrimaryContainer = Color(0xFFFFF0DD),
    secondary = DelphinBlack,
    onSecondary = Color(0xFFCCD0E0),
    secondaryContainer = VesperSurfaceVariant,
    onSecondaryContainer = Color(0xFFD5DEF0),
    tertiary = DelphinCyan,
    onTertiary = Color(0xFF001A22),
    background = VesperBackground,
    onBackground = Color(0xFFE6E8F0),
    surface = VesperSurface,
    onSurface = Color(0xFFE4E6EE),
    surfaceVariant = VesperSurfaceVariant,
    onSurfaceVariant = Color(0xFF8E96AE),
    outline = Color(0xFF2E3548),
    outlineVariant = Color(0xFF1E2536),
    error = RiskHigh,
    onError = Color(0xFF200909)
)

private val LightColorScheme = lightColorScheme(
    primary = DelphinOrangeDark,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFE0B2),
    onPrimaryContainer = Color(0xFF4D2800),
    secondary = DelphinBlack,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFE0E0F0),
    onSecondaryContainer = Color(0xFF1A1A2E),
    tertiary = DelphinCyanDim,
    onTertiary = Color.White,
    background = Color(0xFFF4F2F5),
    onBackground = Color(0xFF121520),
    surface = Color.White,
    onSurface = Color(0xFF111420),
    surfaceVariant = Color(0xFFEBE8EE),
    onSurfaceVariant = Color(0xFF504862),
    outline = Color(0xFF706680),
    outlineVariant = Color(0xFFBEB4C8),
    error = RiskHigh,
    onError = Color.White
)

private val DelphinShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(20.dp)
)

private val BaseTypography = androidx.compose.material3.Typography()

val VesperTypography = BaseTypography.copy(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Light,
        fontSize = 48.sp,
        letterSpacing = 1.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        letterSpacing = 0.8.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 0.4.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.3.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 1.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = 0.6.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun VesperTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // delphinOS is always dark — matches the Flipper LCD aesthetic
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = VesperTypography,
        shapes = DelphinShapes,
        content = content
    )
}
