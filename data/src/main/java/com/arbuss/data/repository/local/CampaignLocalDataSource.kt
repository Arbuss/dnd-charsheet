package com.arbuss.data.repository.local

import com.arbuss.data.model.Campaign
import kotlinx.coroutines.flow.Flow

internal interface CampaignLocalDataSource {
    fun getAllCampaign(): List<Campaign>

    fun getAllCampaignObservable(): Flow<List<Campaign>>

    fun getCampaign(id: Int): Campaign?

    fun addCampaign(campaign: Campaign)

    fun updateCampaign(campaign: Campaign)

    fun deleteCampaign(campaign: Campaign)

    fun deleteCampaign(id: Int)
}
