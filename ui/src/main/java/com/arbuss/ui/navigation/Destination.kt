package com.arbuss.ui.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class Destination : Parcelable {

    @Parcelize
    data object CampaignScreen : Destination()

    @Parcelize
    data object CharacterScreen : Destination()
}