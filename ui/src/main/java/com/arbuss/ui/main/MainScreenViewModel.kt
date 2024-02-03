package com.arbuss.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arbuss.data.model.Campaign
import com.arbuss.data.repository.CampaignRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val campaignRepository: CampaignRepository
) : ViewModel() {

    private val _campaignList: MutableStateFlow<List<Campaign>> = MutableStateFlow(emptyList())
    val campaignList: StateFlow<List<Campaign>> = _campaignList.asStateFlow()

    init {
        initCampaignList()
    }

    private fun initCampaignList() {
        viewModelScope.launch {
            _campaignList.emit(campaignRepository.getAll())
        }
    }
}