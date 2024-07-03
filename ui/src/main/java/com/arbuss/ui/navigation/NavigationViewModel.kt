package com.arbuss.ui.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class NavigationViewModel(
    private val router: Router
) : ViewModel() {

    val destination: StateFlow<Destination>
        get() = router.destination

    val backAction: StateFlow<UUID?>
        get() = router.backAction

    fun navigate(destination: Destination) {
        router.navigate(destination)
    }

    fun back() {
        router.back()
    }
}
