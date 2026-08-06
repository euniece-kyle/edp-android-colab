package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val SevenZeroSevenColorScheme = darkColorScheme(
    primary = PrimaryMM,
    secondary = SecondaryMM,
    background = BackgroundMM,
    surface = SurfaceMM,
    onPrimary = OnPrimaryMM,
    onBackground = OnBackgroundMM,
    onSurface = OnSurfaceMM,
    primaryContainer = SevenRed.copy(alpha = 0.2f),
    onPrimaryContainer = SevenYellow
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = SevenZeroSevenColorScheme,
        typography = Typography,
        content = content
    )
}
