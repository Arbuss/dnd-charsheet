package com.arbuss.data.repository

import com.arbuss.data.model.Campaign
import kotlinx.coroutines.flow.Flow

interface CampaignRepository : CRUD<Campaign> {

    fun getAllObservable(): Flow<List<Campaign>>
}
