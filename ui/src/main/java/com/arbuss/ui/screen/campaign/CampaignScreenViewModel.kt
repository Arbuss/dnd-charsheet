package com.arbuss.ui.screen.campaign

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arbuss.data.model.Campaign
import com.arbuss.data.repository.CampaignRepository
import com.arbuss.ui.R
import com.arbuss.ui.navigation.Destination
import com.arbuss.ui.navigation.Router
import com.arbuss.ui.utils.TopBarButtonSettings
import com.arbuss.ui.utils.TopBarSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CampaignScreenViewModel(
    private val campaignRepository: CampaignRepository,
    private val router: Router
) : ViewModel() {

    private val _campaignList: MutableStateFlow<List<Campaign>> = MutableStateFlow(emptyList())
    val campaignList: StateFlow<List<Campaign>> = _campaignList.asStateFlow()

    val topBarSettings = TopBarSettings(
        stringId = R.string.header_campaigns_screen,
        leftButton = TopBarButtonSettings(R.drawable.ic_arrow_back) { router.back() },
        rightButton = TopBarButtonSettings(R.drawable.ic_plus) {}
    )

    init {
        initCampaignList()
    }

    fun onClick(id: Int) {
        router.navigate(Destination.CharactersListScreen(id))
    }

    private fun initCampaignList() {
        viewModelScope.launch {
            _campaignList.emit(campaignRepository.getAll())
        }
    }
}