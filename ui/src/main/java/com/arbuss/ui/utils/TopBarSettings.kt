package com.arbuss.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TopBarSettings(
    @StringRes val stringId: Int,
    val additionalString: String? = null,
    val leftButton: TopBarButtonSettings? = null,
    val rightButton: TopBarButtonSettings? = null
)

data class TopBarButtonSettings(
    @DrawableRes val icon: Int,
    val onClicked: () -> Unit,
)
