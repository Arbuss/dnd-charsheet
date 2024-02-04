package com.arbuss.ui.screen.campaign

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import com.arbuss.ui.utils.ui.TopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun CampaignScreen(viewModel: CampaignScreenViewModel = koinViewModel()) {
    val campaignList by viewModel.campaignList.collectAsState()
    viewModel.updateCampaignList()

    Column(Modifier.fillMaxSize()) {
        TopBar(settings = viewModel.topBarSettings)

        LazyColumn {
            items(campaignList) { campaign ->
                campaign.id?.let { id ->
                    CampaignListItem(id, campaign) { viewModel.onClick(id) }
                }
            }
        }
    }
}

@Composable
private fun CampaignListItem(id: Int, campaign: Campaign, onClick: (Int) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clickable { onClick.invoke(id) }
    ) {
        Text(text = "id = $id", Modifier.padding(vertical = 4.dp, horizontal = 4.dp))
        Text(text = "name = ${campaign.name}", Modifier.padding(vertical = 4.dp, horizontal = 4.dp))
    }
}