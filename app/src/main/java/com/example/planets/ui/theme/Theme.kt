package com.example.planets.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val LightThemeColors = lightColors(
    primary = White1,
    secondary = White1,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = White2,
    onBackground = Color(0xff646464),
    surface = White2,
    onSurface = Color(0xff000000)
)

private val DarkThemeColors = darkColors(
    primary = Black1,
    secondary = Black1,
    error = RedErrorLight,
    background = Black2,
    onBackground = Color(0xffE1DCDC),
    surface = Black1,
    onSurface = Color(0xffE1DCDC)
)

@Composable
fun PlanetsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = DefaultTypography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun PlanetTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) dark else light
    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content,
        typography = DefaultTypography
    )
}

@Composable
fun NewPlanetTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkThemeColors else LightThemeColors
    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content,
        typography = DefaultTypography
    )
}
