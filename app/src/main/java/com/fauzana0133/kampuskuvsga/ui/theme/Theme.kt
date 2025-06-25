package com.fauzana0133.kampuskuvsga.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color.White,
    background = Color(0xFFF1F8E9),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    outline = Color(0xFFBDBDBD)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF81C784),
    onPrimary = Color.Black,
    background = Color(0xFF1B1B1B),
    onBackground = Color.White,
    surface = Color(0xFF121212),
    onSurface = Color.White,
    outline = Color(0xFF616161)
)

@Composable
fun KampusKuVSGATheme(
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
