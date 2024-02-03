package com.arbuss.data.repository

import com.arbuss.data.model.Campaign

interface CampaignRepository {
    fun getAllCampaign(): List<Campaign>

    fun addCampaign(campaign: Campaign)

    fun updateCampaign(campaign: Campaign)

    fun deleteCampaign(campaign: Campaign)

    fun deleteCampaign(id: Int)
}