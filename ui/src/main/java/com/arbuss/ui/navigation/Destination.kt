package com.arbuss.ui.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

sealed class Destination : Parcelable {

    @Parcelize
    data class CampaignScreen(val uuid: UUID = UUID.randomUUID()) : Destination()

    @Parcelize
    data class CharactersListScreen(val id: Int, val uuid: UUID = UUID.randomUUID()) : Destination()
}
