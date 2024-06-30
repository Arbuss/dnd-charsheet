package com.arbuss.data.repository

import com.arbuss.data.model.Character
import com.arbuss.data.repository.local.CharacterLocalDataSource
import kotlinx.coroutines.flow.Flow

internal class CharacterRepositoryImpl(
    private val localDataSource: CharacterLocalDataSource
) : CharacterRepository {

    override fun getAll(): List<Character> {
        return localDataSource.getAllCharacters()
    }

    override fun getAllCharactersFromCampaignObservable(campaignId: Int): Flow<List<Character>> {
        return localDataSource.getAllCharactersFromCampaignObservable(campaignId)
    }

    override fun get(id: Int): Character? {
        return localDataSource.getCharacter(id)
    }

    override fun add(item: Character) {
        localDataSource.addCharacter(item)
    }

    override fun update(item: Character) {
        localDataSource.updateCharacter(item)
    }

    override fun delete(item: Character) {
        localDataSource.deleteCharacter(item)
    }

    override fun delete(id: Int) {
        localDataSource.deleteCharacter(id)
    }

    override fun getAllCharactersFromCampaign(campaignId: Int): List<Character> {
        return localDataSource.getAllCharactersFromCampaign(campaignId)
    }
}