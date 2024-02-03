package com.arbuss.data.repository

import com.arbuss.data.model.Campaign
import com.arbuss.data.repository.local.CampaignLocalDataSource

internal class CampaignRepositoryImpl(
    private val localDataSource: CampaignLocalDataSource
) : CampaignRepository {

    override fun getAllCampaign(): List<Campaign> {
        return localDataSource.getAllCampaign()
    }

    override fun addCampaign(campaign: Campaign) {
        localDataSource.addCampaign(campaign)
    }

    override fun updateCampaign(campaign: Campaign) {
        localDataSource.updateCampaign(campaign)
    }

    override fun deleteCampaign(campaign: Campaign) {
        localDataSource.deleteCampaign(campaign)
    }

    override fun deleteCampaign(id: Int) {
        localDataSource.deleteCampaign(id)
    }
}