package com.arbuss.data.repository

import com.arbuss.data.model.Campaign
import com.arbuss.data.repository.local.CampaignLocalDataSource
import kotlinx.coroutines.flow.Flow

internal class CampaignRepositoryImpl(
    private val localDataSource: CampaignLocalDataSource
) : CampaignRepository {

    override fun getAll(): List<Campaign> {
        return localDataSource.getAllCampaign()
    }

    override fun getAllObservable(): Flow<List<Campaign>> {
        return localDataSource.getAllCampaignObservable()
    }

    override fun get(id: Int): Campaign? {
        return localDataSource.getCampaign(id)
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
