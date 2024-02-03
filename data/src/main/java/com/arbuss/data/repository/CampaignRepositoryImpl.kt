package com.arbuss.data.repository

import com.arbuss.data.model.Campaign
import com.arbuss.data.repository.local.CampaignLocalDataSource

internal class CampaignRepositoryImpl(
    private val localDataSource: CampaignLocalDataSource
) : CampaignRepository {

    override fun getAll(): List<Campaign> {
        return localDataSource.getAllCampaign()
    }

    override fun add(item: Campaign) {
        localDataSource.addCampaign(item)
    }

    override fun update(item: Campaign) {
        localDataSource.updateCampaign(item)
    }

    override fun delete(item: Campaign) {
        localDataSource.deleteCampaign(item)
    }

    override fun delete(id: Int) {
        localDataSource.deleteCampaign(id)
    }
}