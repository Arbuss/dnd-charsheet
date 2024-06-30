package com.arbuss.data.model

import com.arbuss.data.model.character.CharacterTitleInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    override val id: Int?,
    val name: String,
    val titleInfo: CharacterTitleInfo,
    val campaignId: Int
) : DataModel
