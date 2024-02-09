package com.arbuss.data.repository

import com.arbuss.data.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository : CRUD<Character> {

    fun getAllCharactersFromCampaign(campaignId: Int): List<Character>

    fun getAllCharactersFromCampaignObservable(campaignId: Int): Flow<List<Character>>
}