package com.arbuss.ui.screen.main

import androidx.compose.runtime.Composable
import com.arbuss.ui.navigation.NavHostScreen
import com.arbuss.ui.navigation.NavigationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel(),
    navigationViewModel: NavigationViewModel = koinViewModel()
) {
    NavHostScreen(navigationViewModel)
}