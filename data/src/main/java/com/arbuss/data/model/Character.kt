package com.arbuss.data.model

data class Character(
    override val id: Int?,
    val name: String,
    val campaignId: Int
) : DataModel
