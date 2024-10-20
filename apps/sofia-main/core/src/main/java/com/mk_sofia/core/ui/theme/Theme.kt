package com.mk_sofia.core.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = SofiaRed,
    onTertiaryContainer = GrayCard,
)

private val LightColorScheme = lightColorScheme(
    primary = SofiaRed,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    surface = Black,
    surfaceVariant = White,
    background = GrayField,
    onBackground = GrayText,
    primaryContainer = DarkBoard,
    onPrimary = DarkText,
    onPrimaryContainer = BlueText,
    secondaryContainer = GrayBackgroundScreen,
    onTertiaryContainer = GrayCard,


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val ColorScheme.darkText2: Color
    get() = DarkText2

val ColorScheme.darkCard: Color
    get() = DarkCard

val ColorScheme.iconDark: Color
    get() = IconDark

val ColorScheme.sofiaGreen: Color
    get() = Green

val ColorScheme.lightGrayCard: Color
    get() = LightGrayCard

@Composable
fun SofiaMainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.surfaceVariant.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}