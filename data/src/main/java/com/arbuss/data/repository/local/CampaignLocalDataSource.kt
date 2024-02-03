package com.arbuss.data.repository.local

import com.arbuss.data.model.Campaign

internal interface CampaignLocalDataSource {
    fun getAllCampaign(): List<Campaign>

    fun addCampaign(campaign: Campaign)

    fun updateCampaign(campaign: Campaign)

    fun deleteCampaign(campaign: Campaign)

    fun deleteCampaign(id: Int)
}