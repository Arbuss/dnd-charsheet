package com.arbuss.data.repository

import com.arbuss.data.model.Character
import com.arbuss.data.repository.local.CharacterLocalDataSource

internal class CharacterRepositoryImpl(
    private val localDataSource: CharacterLocalDataSource
) : CharacterRepository {

    override fun getAll(): List<Character> {
        return localDataSource.getAllCharacters()
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
}