package com.arbuss.data.repository.local

import com.arbuss.data.model.Character
import kotlinx.coroutines.flow.Flow

internal interface CharacterLocalDataSource {
    fun getAllCharacters(): List<Character>

    fun getAllCharactersFromCampaignObservable(campaignId: Int): Flow<List<Character>>

    fun addCharacter(character: Character)

    fun updateCharacter(character: Character)

    fun deleteCharacter(character: Character)

    fun deleteCharacter(id: Int)

    fun getAllCharactersFromCampaign(campaignId: Int): List<Character>
}