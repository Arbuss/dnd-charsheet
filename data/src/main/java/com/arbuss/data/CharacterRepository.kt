package com.arbuss.data

import com.arbuss.data.model.Character

interface CharacterRepository {
    fun getAllCharacters(): List<Character>

    fun addCharacter(character: Character)

    fun updateCharacter(character: Character)

    fun deleteCharacter(character: Character)

    fun deleteCharacter(id: Int)
}