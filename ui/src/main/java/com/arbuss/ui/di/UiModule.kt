package com.arbuss.ui.di

import com.arbuss.data.repository.CampaignRepository
import com.arbuss.data.repository.CharacterRepository
import com.arbuss.ui.navigation.NavigationViewModel
import com.arbuss.ui.navigation.Router
import com.arbuss.ui.navigation.RouterImpl
import com.arbuss.ui.screen.campaign.CampaignScreenViewModel
import com.arbuss.ui.screen.campaign.add.CampaignAddViewModel
import com.arbuss.ui.screen.character.CharacterViewModel
import com.arbuss.ui.screen.characterslist.CharactersListViewModel
import com.arbuss.ui.screen.characterslist.add.CharacterAddViewModel
import com.arbuss.ui.screen.main.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    single<Router> { RouterImpl() }
    viewModel { NavigationViewModel(get<Router>()) }
    viewModel { MainScreenViewModel(get<Router>()) }
    viewModel { CampaignScreenViewModel(get<CampaignRepository>(), get<Router>()) }
    viewModel { CampaignAddViewModel(get<CampaignRepository>(), get<Router>()) }
    viewModel { CharactersListViewModel(get<CharacterRepository>(), get(), get<Router>()) }
    viewModel { CharacterAddViewModel(get<CharacterRepository>(), get<Router>()) }
    viewModel { CharacterViewModel(get<CharacterRepository>(), get<Router>(), get()) }
}
