package com.arbuss.ui.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class NavigationViewModel(
    private val router: Router
) : ViewModel() {

    val destination: StateFlow<Destination>
        get() = router.destination

    fun navigate(destination: Destination) {
        router.navigate(destination)
    }
}