package com.arbuss.data.di

import com.arbuss.data.repository.CampaignRepository
import com.arbuss.data.repository.CampaignRepositoryImpl
import com.arbuss.data.repository.CharacterRepository
import com.arbuss.data.repository.CharacterRepositoryImpl
import com.arbuss.data.repository.local.CampaignLocalDataSource
import com.arbuss.data.repository.local.CampaignLocalDataSourceRealm
import com.arbuss.data.repository.local.CharacterLocalDataSource
import com.arbuss.data.repository.local.CharacterLocalDataSourceRealm
import org.koin.dsl.module

val dataModule = module {
    single<CharacterLocalDataSource> { CharacterLocalDataSourceRealm() }
    single<CharacterRepository> { CharacterRepositoryImpl(get<CharacterLocalDataSource>()) }

    single<CampaignLocalDataSource> { CampaignLocalDataSourceRealm() }
    single<CampaignRepository> { CampaignRepositoryImpl(get<CampaignLocalDataSource>()) }
}
