package com.custories.greeklearner

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF3F51B5),
    secondary = Color(0xFFFFB300),
    surfaceVariant = Color(0xFFF1F2FF),
    background = Color(0xFFF7F7FF)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF9FA8FF),
    secondary = Color(0xFFFFD54F),
    surfaceVariant = Color(0xFF1F2230),
    background = Color(0xFF12131A)
)

@Composable
fun GreekLearnerTheme(content: @Composable () -> Unit) {
    val colors = if (androidx.compose.foundation.isSystemInDarkTheme()) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}
