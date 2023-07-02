package com.example.ftpmanager.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun FTPmanagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        shapes = AppShapes,
        colors = AppDarkColorScheme,
        typography = AppTypography,
        content = content
    )
}