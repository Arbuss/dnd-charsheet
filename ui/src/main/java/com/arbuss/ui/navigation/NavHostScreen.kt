package com.arbuss.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arbuss.ui.screen.campaign.CampaignScreen
import com.arbuss.ui.screen.campaign.add.CampaignAddScreen
import com.arbuss.ui.screen.character.CharacterScreen
import com.arbuss.ui.screen.characterslist.CharactersListScreen
import com.arbuss.ui.screen.characterslist.add.CharacterAddScreen
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.pop
import dev.olshevski.navigation.reimagined.rememberNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavHostScreen(navigationViewModel: NavigationViewModel = koinViewModel()) {
    val navController = rememberNavController<Destination>(startDestination = Destination.CampaignScreen())
    val currentDestination by navigationViewModel.destination.collectAsState()
    val backAction by navigationViewModel.backAction.collectAsState()

    LaunchedEffect(currentDestination) {
        navController.navigate(currentDestination)
    }

    LaunchedEffect(backAction) {
        backAction?.let {
            if (navController.backstack.entries.size > 1) {
                navController.pop()
            }
        }
    }

    NavBackHandler(controller = navController)

    NavHost(navController) { destination ->
        when (destination) {
            is Destination.CampaignScreen -> {
                CampaignScreen()
            }

            is Destination.CampaignAddScreen -> {
                CampaignAddScreen()
            }

            is Destination.CharactersListScreen -> {
                CharactersListScreen(destination.campaignId)
            }

            is Destination.CharacterAddScreen -> {
                CharacterAddScreen(destination.campaignId)
            }

            is Destination.CharacterScreen -> {
                CharacterScreen(destination.character)
            }
        }
    }
}
