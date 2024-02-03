package com.arbuss.ui.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arbuss.data.model.Campaign
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel = koinViewModel()) {
    val campaignList by viewModel.campaignList.collectAsState()

    LazyColumn {
        items(campaignList) {
            CampaignListItem(it)
        }
    }
}

@Composable
private fun CampaignListItem(campaign: Campaign) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(text = "id = ${campaign.id}")
        Text(text = "name = ${campaign.name}", Modifier.padding(start = 8.dp))
    }
}