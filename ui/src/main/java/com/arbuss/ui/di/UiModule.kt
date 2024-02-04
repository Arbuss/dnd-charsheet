package com.arbuss.ui.di

import com.arbuss.data.repository.CampaignRepository
import com.arbuss.data.repository.CharacterRepository
import com.arbuss.ui.navigation.NavigationViewModel
import com.arbuss.ui.navigation.Router
import com.arbuss.ui.navigation.RouterImpl
import com.arbuss.ui.screen.campaign.CampaignScreenViewModel
import com.arbuss.ui.screen.characters_list.CharactersListViewModel
import com.arbuss.ui.screen.main.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    single<Router> { RouterImpl() }
    viewModel { NavigationViewModel(get<Router>()) }
    viewModel { MainScreenViewModel(get<Router>()) }
//    viewModel { MainScreenViewModel(get<Router>(), get(), get()) }
    viewModel { CampaignScreenViewModel(get<CampaignRepository>(), get<Router>()) }
    viewModel { CharactersListViewModel(get<CharacterRepository>(), get<Router>()) }
}