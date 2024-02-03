package com.arbuss.ui.navigation

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RouterImpl : Router, CoroutineScope by CoroutineScope(SupervisorJob() + Dispatchers.IO + CoroutineName("Router")) {
    private val _destination: MutableStateFlow<Destination> = MutableStateFlow<Destination>(Destination.CampaignScreen)
    override val destination: StateFlow<Destination> = _destination.asStateFlow()
    override fun navigate(destination: Destination) {
        launch {
            _destination.emit(destination)
        }
    }
}