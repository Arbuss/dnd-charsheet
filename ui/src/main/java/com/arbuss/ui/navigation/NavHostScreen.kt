package com.arbuss.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arbuss.ui.screen.campaign.CampaignScreen
import com.arbuss.ui.screen.character.CharacterScreen
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.rememberNavController

@Composable
fun NavHostScreen(navigationViewModel: NavigationViewModel) {
    val navController = rememberNavController<Destination>(startDestination = Destination.CampaignScreen)
    val currentDestination by navigationViewModel.destination.collectAsState()

    LaunchedEffect(key1 = currentDestination) {
        navController.navigate(currentDestination)
    }

    NavBackHandler(controller = navController)

    NavHost(navController) { destination ->
        when (destination) {
            Destination.CampaignScreen -> {
                CampaignScreen()
            }

            Destination.CharacterScreen -> {
                CharacterScreen()
            }
        }
    }
}