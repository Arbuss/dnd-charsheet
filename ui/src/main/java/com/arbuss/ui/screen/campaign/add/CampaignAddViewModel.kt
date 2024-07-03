package com.arbuss.ui.screen.campaign.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.arbuss.data.model.Campaign
import com.arbuss.data.repository.CampaignRepository
import com.arbuss.ui.R
import com.arbuss.ui.navigation.Router
import com.arbuss.ui.utils.TopBarButtonSettings
import com.arbuss.ui.utils.TopBarSettings

class CampaignAddViewModel(
    private val campaignRepository: CampaignRepository,
    private val router: Router
) : ViewModel() {
    val topBarSettings = TopBarSettings(
        stringId = R.string.header_campaigns_add_screen,
        leftButton = TopBarButtonSettings(R.drawable.ic_arrow_back) { router.back() }
    )

    var campaignName by mutableStateOf("")
        private set

    var isError by mutableStateOf(false)
        private set

    fun onSaveClick() {
        if (campaignName.isNotBlank()) {
            campaignRepository.add(Campaign(null, campaignName))
            router.back()
        } else {
            isError = true
        }
    }

    fun onCampaignNameChanged(name: String) {
        campaignName = name
        isError = false
    }
}
