package com.arbuss.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.arbuss.ui.R
import com.arbuss.ui.navigation.NavHostScreen
import com.arbuss.ui.navigation.NavigationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel(),
    navigationViewModel: NavigationViewModel = koinViewModel()
) {
    Scaffold(
        topBar = { TopBar(navigationViewModel) }
    ) {
        Box(Modifier.padding(it)) {
            NavHostScreen(navigationViewModel)
        }
    }
}

@Composable
private fun TopBar(navigationViewModel: NavigationViewModel) {
    Row {
        Image(
            painterResource(R.drawable.ic_arrow_back),
            null,
            Modifier.clickable { navigationViewModel.back() }
        )
        Text(text = "Main Screen")
    }
}