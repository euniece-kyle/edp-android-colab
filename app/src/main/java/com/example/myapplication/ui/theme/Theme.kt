package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightPastelColorScheme = lightColorScheme(
    primary = PastelPurple,
    secondary = PastelBlue,
    tertiary = PastelPink,
    background = PastelBackground,
    surface = PastelSurface,
    onPrimary = Color.White,
    onSecondary = PastelOnSurface,
    onBackground = PastelOnSurface,
    onSurface = PastelOnSurface,
    onSurfaceVariant = PastelOnSurfaceVariant
)

private val DarkPastelColorScheme = darkColorScheme(
    primary = PastelPurple.copy(alpha = 0.8f),
    secondary = PastelBlue.copy(alpha = 0.8f),
    tertiary = PastelPink.copy(alpha = 0.8f),
    background = Color(0xFF1C1B1F),
    surface = Color(0xFF25232A),
    onPrimary = Color.White,
    onBackground = Color(0xFFE6E1E5),
    onSurface = Color(0xFFE6E1E5),
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkPastelColorScheme else LightPastelColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
