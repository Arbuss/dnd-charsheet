package com.arbuss.ui.di

import com.arbuss.data.repository.CampaignRepository
import com.arbuss.ui.main.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { MainScreenViewModel(get<CampaignRepository>()) }
}