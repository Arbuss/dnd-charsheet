package com.arbuss.data.repository

import com.arbuss.data.model.Character
import com.arbuss.data.repository.local.CharacterLocalDataSource

internal class CharacterRepositoryImpl(
    private val localDataSource: CharacterLocalDataSource
) : CharacterRepository {

    override fun getAllCharacters(): List<Character> {
        return localDataSource.getAllCharacters()
    }

    override fun addCharacter(character: Character) {
        localDataSource.addCharacter(character)
    }

    override fun updateCharacter(character: Character) {
        localDataSource.updateCharacter(character)
    }

    override fun deleteCharacter(character: Character) {
        localDataSource.deleteCharacter(character)
    }

    override fun deleteCharacter(id: Int) {
        localDataSource.deleteCharacter(id)
    }
}