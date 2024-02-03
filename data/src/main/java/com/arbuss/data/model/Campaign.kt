package com.arbuss.data.model

data class Campaign(
    override val id: Int?,
    val name: String
) : DataModel
