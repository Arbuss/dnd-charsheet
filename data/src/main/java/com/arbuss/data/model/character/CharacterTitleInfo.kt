package com.arbuss.data.model.character

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterTitleInfo(
    val race: String,
    val characterClass: String,
    val armorPoint: String,
    val speed: String,
    val initiative: String,
    val experience: CharacterExperience
) : Parcelable
