package com.arbuss.ui.screen.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import com.arbuss.ui.navigation.NavHostScreen
import com.arbuss.ui.theme.AppTheme
import com.arbuss.ui.theme.ApplicationTheme
import com.arbuss.ui.theme.DarkModeColorScheme
import com.arbuss.ui.theme.LightModeColorScheme
import org.koin.androidx.compose.koinViewModel

@Deprecated("Old stuff", ReplaceWith("AppTheme", "com.arbuss.ui.theme.AppTheme"))
internal val LocalAppTheme = compositionLocalOf<ApplicationTheme> { LightModeColorScheme }

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel()
) {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(Modifier.fillMaxSize()) {
                CompositionLocalProvider(LocalAppTheme provides if (isSystemInDarkTheme()) DarkModeColorScheme else LightModeColorScheme) {
                    NavHostScreen()
                }
            }
        }
    }
}