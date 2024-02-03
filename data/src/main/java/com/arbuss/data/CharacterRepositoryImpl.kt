package com.arbuss.data

import com.arbuss.data.model.Character
import com.arbuss.data.repository.local.LocalDataSource
import com.arbuss.data.repository.local.LocalDataSourceRealm

class CharacterRepositoryImpl : CharacterRepository {
    private val localDataSource: LocalDataSource = LocalDataSourceRealm()
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