package com.arbuss.ui.navigation

import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

interface Router {
    val destination: StateFlow<Destination>
    val backAction: StateFlow<UUID?>

    fun navigate(destination: Destination)

    fun back()
}