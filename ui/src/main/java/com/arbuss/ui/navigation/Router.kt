package com.arbuss.ui.navigation

import kotlinx.coroutines.flow.StateFlow

interface Router {
    val destination: StateFlow<Destination>
    fun navigate(destination: Destination)
}