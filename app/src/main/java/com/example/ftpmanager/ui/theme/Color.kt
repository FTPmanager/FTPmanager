package com.example.ftpmanager.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val DarkNormal = Color(0xFF4d4646)
val DarkLight = Color(0xFF797171)
val DarkDark = Color(0xFF251f1f)

val GrayNormal = Color(0xFF5b5656)
val GrayLight = Color(0xFF888383)
val GrayDark = Color(0xFF322d2d)

val GreenNormal = Color(0xFF7fcd91)
val GreenLight = Color(0xFFb1ffc2)
val GreenDark = Color(0xFF4f9c63)

val WhiteNormal = Color(0xFFf5eaea)
val WhiteLight = Color(0xFFffffff)
val WhiteDark = Color(0xFFc2b8b8)

val RedNormal = Color(0xFFdd2211)
val RedLight = Color(0xFFff5f3e)
val RedDark = Color(0xFFa30000)

val YellowNormal = Color(0xFFfdda0d)
val YellowLight = Color(0xFFffff56)
val YellowDark = Color(0xFFc5a900)


val AppDarkColorScheme = Colors(
    background = DarkNormal,
    primary = GrayNormal,
    secondary = GreenNormal,
    surface = GrayNormal,
    onBackground = WhiteNormal,
    onPrimary = WhiteNormal,
    onSecondary = DarkNormal,
    onSurface = WhiteNormal,
    error = RedNormal,
    onError = RedLight,
    isLight = false,
    primaryVariant = GrayLight,
    secondaryVariant = GreenLight

)
