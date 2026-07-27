package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = MaroonPrimary,
    onPrimary = OnMaroonPrimary,
    secondary = MaroonSecondary,
    surface = MaroonOnSurface,
    onSurface = MaroonSurface,
    onSurfaceVariant = MaroonOnSurfaceVariant
)

private val LightColorScheme = lightColorScheme(
    primary = MaroonPrimary,
    onPrimary = OnMaroonPrimary,
    secondary = MaroonSecondary,
    surface = MaroonSurface,
    onSurface = MaroonOnSurface,
    onSurfaceVariant = MaroonOnSurfaceVariant
)

@Composable
fun ProfileCardLabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


@Composable
fun ProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    ProfileCardLabTheme(darkTheme = darkTheme, content = content)
}
