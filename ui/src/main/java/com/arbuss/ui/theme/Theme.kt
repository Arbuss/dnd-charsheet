package com.arbuss.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
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
        typography = typographyTemplate,
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

fun appTheme(isDarkMode: Boolean): ApplicationTheme = if (isDarkMode) {
    DarkModeColorScheme
} else {
    LightModeColorScheme
}

object AppTheme {
    val text: TextColorScheme
        @Composable get() = AppTheme().text

    val background: BackgroundColorScheme
        @Composable get() = AppTheme().background

    val icon: IconColorScheme
        @Composable get() = AppTheme().icon

    val button: ButtonColorScheme
        @Composable get() = AppTheme().button

    val typography: Typography
        @Composable get() = typographyTemplate

    val padding: Padding
        @Composable get() = Padding

    val corners: RoundedCorner
        @Composable get() = RoundedCorner

    val shadow: Shadow
        @Composable get() = Shadow
}

internal object LightModeColorScheme : ApplicationTheme {
    override val text = TextColorScheme(
        primary = Colors.Text.Light.Primary,
        secondary = Colors.Text.Light.Secondary,
        tertiary = Colors.Text.Light.Tertiary,
        inverted = Colors.Text.Light.Inverted,
        positive = Colors.Text.Light.Positive,
        negative = Colors.Text.Light.Negative,
        primaryLink = Colors.Text.Light.PrimaryLink,
        visitedLink = Colors.Text.Light.VisitedLink,
        primaryLinkInverted = Colors.Text.Light.PrimaryLinkInverted,
        secondaryLink = Colors.Text.Light.SecondaryLink,
        inactiveTabbar = Colors.Text.Light.InactiveTabbar
    )

    override val background = BackgroundColorScheme(
        primary = Colors.Background.Light.Primary,
        primaryElevated = Colors.Background.Light.PrimaryElevated,
        modal = Colors.Background.Light.Modal,
        stroke = Colors.Background.Light.Stroke,
        secondary = Colors.Background.Light.Secondary,
        secondaryElevated = Colors.Background.Light.SecondaryElevated,
        overlay = Colors.Background.Light.Overlay,
        inverted = Colors.Background.Light.Inverted,
        hover = Colors.Background.Light.Hover,
        bar = Colors.Background.Light.Bar,
        disabled = Colors.Background.Light.Disabled,
        strokeDisabled = Colors.Background.Light.StrokeDisabled,
        lower = Colors.Background.Light.Lower,
        card = Colors.Background.Light.Card
    )

    override val icon = IconColorScheme(
        primary = Colors.Icons.Light.Primary,
        secondary = Colors.Icons.Light.Secondary,
        tertiary = Colors.Icons.Light.Tertiary,
    )

    override val button = ButtonColorScheme(
        primary = Colors.Buttons.Light.Primary,
        secondary = Colors.Buttons.Light.Secondary,
        negative = Colors.Buttons.Light.Negative,
    )

    override val typography = typographyTemplate
}

internal object DarkModeColorScheme : ApplicationTheme {
    override val text = TextColorScheme(
        primary = Colors.Text.Dark.Primary,
        secondary = Colors.Text.Dark.Secondary,
        tertiary = Colors.Text.Dark.Tertiary,
        inverted = Colors.Text.Dark.Inverted,
        positive = Colors.Text.Dark.Positive,
        negative = Colors.Text.Dark.Negative,
        primaryLink = Colors.Text.Dark.PrimaryLink,
        visitedLink = Colors.Text.Dark.VisitedLink,
        primaryLinkInverted = Colors.Text.Dark.PrimaryLinkInverted,
        secondaryLink = Colors.Text.Dark.SecondaryLink,
        inactiveTabbar = Colors.Text.Dark.InactiveTabbar
    )

    override val background = BackgroundColorScheme(
        primary = Colors.Background.Dark.Primary,
        primaryElevated = Colors.Background.Dark.PrimaryElevated,
        modal = Colors.Background.Dark.Modal,
        stroke = Colors.Background.Dark.Stroke,
        secondary = Colors.Background.Dark.Secondary,
        secondaryElevated = Colors.Background.Dark.SecondaryElevated,
        overlay = Colors.Background.Dark.Overlay,
        inverted = Colors.Background.Dark.Inverted,
        hover = Colors.Background.Dark.Hover,
        bar = Colors.Background.Dark.Bar,
        disabled = Colors.Background.Dark.Disabled,
        strokeDisabled = Colors.Background.Dark.StrokeDisabled,
        lower = Colors.Background.Dark.Lower,
        card = Colors.Background.Dark.Card
    )

    override val icon = IconColorScheme(
        primary = Colors.Icons.Dark.Primary,
        secondary = Colors.Icons.Dark.Secondary,
        tertiary = Colors.Icons.Dark.Tertiary,
    )

    override val button = ButtonColorScheme(
        primary = Colors.Buttons.Dark.Primary,
        secondary = Colors.Buttons.Dark.Secondary,
        negative = Colors.Buttons.Dark.Negative,
    )

    override val typography = typographyTemplate
}

interface ApplicationTheme {
    val text: TextColorScheme
    val background: BackgroundColorScheme
    val icon: IconColorScheme
    val button: ButtonColorScheme
    val typography: Typography
}

data class TextColorScheme(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val inverted: Color,
    val positive: Color,
    val negative: Color,
    val primaryLink: Color,
    val visitedLink: Color,
    val primaryLinkInverted: Color,
    val secondaryLink: Color,
    val inactiveTabbar: Color,
)

data class BackgroundColorScheme(
    val primary: Color,
    val primaryElevated: Color,
    val modal: Color,
    val stroke: Color,
    val secondary: Color,
    val secondaryElevated: Color,
    val overlay: Color,
    val inverted: Color,
    val hover: Color,
    val bar: Color,
    val disabled: Color,
    val strokeDisabled: Color,
    val lower: Color,
    val card: Color
)

data class IconColorScheme(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color
)

data class ButtonColorScheme(
    val primary: Color,
    val secondary: Color,
    val negative: Color
)

private val typographyTemplate = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
