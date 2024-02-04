package com.arbuss.data.repository

import com.arbuss.data.model.Character

interface CharacterRepository : CRUD<Character> {

    fun getAllCharactersFromCampaign(campaignId: Int): List<Character>
}