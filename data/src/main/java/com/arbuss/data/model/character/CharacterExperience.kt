package com.arbuss.data.model.character

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterExperience(
    val value: Int,
    val level: CharacterLevel
) : Parcelable
