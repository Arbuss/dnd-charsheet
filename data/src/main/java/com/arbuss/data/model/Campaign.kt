package com.arbuss.data.model

import kotlinx.parcelize.Parcelize

@Parcelize
data class Campaign(
    override val id: Int?,
    val name: String
) : DataModel
