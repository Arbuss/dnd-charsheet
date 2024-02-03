package com.arbuss.data.repository.local

import com.arbuss.data.model.Character

internal interface CharacterLocalDataSource {
    fun getAllCharacters(): List<Character>

    fun addCharacter(character: Character)

    fun updateCharacter(character: Character)

    fun deleteCharacter(character: Character)

    fun deleteCharacter(id: Int)
}