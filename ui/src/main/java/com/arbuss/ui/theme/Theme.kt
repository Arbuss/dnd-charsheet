package com.arbuss.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
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
    // background
    primary = Colors.Background.Dark.Primary,
    secondary = Colors.Background.Dark.Secondary,
    tertiary = Colors.Background.Dark.Secondary,

    // text and icons
    onPrimary = Colors.Text.Dark.Primary,
    onSecondary = Colors.Text.Dark.Secondary,
    onTertiary = Colors.Text.Dark.Tertiary
)

private val LightColorScheme = lightColorScheme(
    // background
    primary = Colors.Background.Light.Primary,
    secondary = Colors.Background.Light.Secondary,
    tertiary = Colors.Background.Light.Secondary,

    // text and icons
    onPrimary = Colors.Text.Light.Primary,
    onSecondary = Colors.Text.Light.Secondary,
    onTertiary = Colors.Text.Light.Tertiary

    /* Other default colors to override
    background: Color
    surface: Color
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground: Color
    onSurface: Color
    */
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun AppTheme(): ApplicationTheme {
    return if (isSystemInDarkTheme()) {
        DarkModeColorScheme
    } else {
        LightModeColorScheme
    }
}

fun appTheme(isDarkMode: Boolean): ApplicationTheme = if(isDarkMode) {
    DarkModeColorScheme
} else {
    LightModeColorScheme
}

internal object LightModeColorScheme : ApplicationTheme {
    override val text = TextColorScheme(
        Primary = Colors.Text.Light.Primary,
        Secondary = Colors.Text.Light.Secondary,
        Tertiary = Colors.Text.Light.Tertiary,
        Inverted = Colors.Text.Light.Inverted,
        Positive = Colors.Text.Light.Positive,
        Negative = Colors.Text.Light.Negative,
        PrimaryLink = Colors.Text.Light.PrimaryLink,
        VisitedLink = Colors.Text.Light.VisitedLink,
        PrimaryLinkInverted = Colors.Text.Light.PrimaryLinkInverted,
        SecondaryLink = Colors.Text.Light.SecondaryLink,
        InactiveTabbar = Colors.Text.Light.InactiveTabbar
    )

    override val background = BackgroundColorScheme(
        Primary = Colors.Background.Light.Primary,
        PrimaryElevated = Colors.Background.Light.PrimaryElevated,
        Modal = Colors.Background.Light.Modal,
        Stroke = Colors.Background.Light.Stroke,
        Secondary = Colors.Background.Light.Secondary,
        SecondaryElevated = Colors.Background.Light.SecondaryElevated,
        Overlay = Colors.Background.Light.Overlay,
        Inverted = Colors.Background.Light.Inverted,
        Hover = Colors.Background.Light.Hover,
        Bar = Colors.Background.Light.Bar,
        Disabled = Colors.Background.Light.Disabled,
        StrokeDisabled = Colors.Background.Light.StrokeDisabled,
        Lower = Colors.Background.Light.Lower,
        Card = Colors.Background.Light.Card
    )

    override val icon = IconColorScheme(
        Primary = Colors.Icons.Light.Primary,
        Secondary = Colors.Icons.Light.Secondary,
        Tertiary = Colors.Icons.Light.Tertiary,
    )

    override val button = ButtonColorScheme(
        Primary = Colors.Buttons.Light.Primary,
        Secondary = Colors.Buttons.Light.Secondary,
        Negative = Colors.Buttons.Light.Negative,
    )
}

internal object DarkModeColorScheme : ApplicationTheme {
    override val text = TextColorScheme(
        Primary = Colors.Text.Dark.Primary,
        Secondary = Colors.Text.Dark.Secondary,
        Tertiary = Colors.Text.Dark.Tertiary,
        Inverted = Colors.Text.Dark.Inverted,
        Positive = Colors.Text.Dark.Positive,
        Negative = Colors.Text.Dark.Negative,
        PrimaryLink = Colors.Text.Dark.PrimaryLink,
        VisitedLink = Colors.Text.Dark.VisitedLink,
        PrimaryLinkInverted = Colors.Text.Dark.PrimaryLinkInverted,
        SecondaryLink = Colors.Text.Dark.SecondaryLink,
        InactiveTabbar = Colors.Text.Dark.InactiveTabbar
    )

    override val background = BackgroundColorScheme(
        Primary = Colors.Background.Dark.Primary,
        PrimaryElevated = Colors.Background.Dark.PrimaryElevated,
        Modal = Colors.Background.Dark.Modal,
        Stroke = Colors.Background.Dark.Stroke,
        Secondary = Colors.Background.Dark.Secondary,
        SecondaryElevated = Colors.Background.Dark.SecondaryElevated,
        Overlay = Colors.Background.Dark.Overlay,
        Inverted = Colors.Background.Dark.Inverted,
        Hover = Colors.Background.Dark.Hover,
        Bar = Colors.Background.Dark.Bar,
        Disabled = Colors.Background.Dark.Disabled,
        StrokeDisabled = Colors.Background.Dark.StrokeDisabled,
        Lower = Colors.Background.Dark.Lower,
        Card = Colors.Background.Dark.Card
    )

    override val icon = IconColorScheme(
        Primary = Colors.Icons.Dark.Primary,
        Secondary = Colors.Icons.Dark.Secondary,
        Tertiary = Colors.Icons.Dark.Tertiary,
    )

    override val button = ButtonColorScheme(
        Primary = Colors.Buttons.Dark.Primary,
        Secondary = Colors.Buttons.Dark.Secondary,
        Negative = Colors.Buttons.Dark.Negative,
    )
}

interface ApplicationTheme {
    val text: TextColorScheme
    val background: BackgroundColorScheme
    val icon: IconColorScheme
    val button: ButtonColorScheme
}

data class TextColorScheme(
    val Primary: Color,
    val Secondary: Color,
    val Tertiary: Color,
    val Inverted: Color,
    val Positive: Color,
    val Negative: Color,
    val PrimaryLink: Color,
    val VisitedLink: Color,
    val PrimaryLinkInverted: Color,
    val SecondaryLink: Color,
    val InactiveTabbar: Color,
)

data class BackgroundColorScheme(
    val Primary: Color,
    val PrimaryElevated: Color,
    val Modal: Color,
    val Stroke: Color,
    val Secondary: Color,
    val SecondaryElevated: Color,
    val Overlay: Color,
    val Inverted: Color,
    val Hover: Color,
    val Bar: Color,
    val Disabled: Color,
    val StrokeDisabled: Color,
    val Lower: Color,
    val Card: Color
)

data class IconColorScheme(
    val Primary: Color,
    val Secondary: Color,
    val Tertiary: Color
)

data class ButtonColorScheme(
    val Primary: Color,
    val Secondary: Color,
    val Negative: Color
)