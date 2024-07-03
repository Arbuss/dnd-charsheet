package com.arbuss.ui.screen.campaign

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import com.arbuss.data.model.Campaign
import com.arbuss.ui.theme.AppTheme
import com.arbuss.ui.theme.Padding
import com.arbuss.ui.theme.RoundedCorner
import com.arbuss.ui.theme.Shadow
import com.arbuss.ui.utils.ui.TopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun CampaignScreen(viewModel: CampaignScreenViewModel = koinViewModel()) {
    val campaignList by viewModel.campaignList.collectAsState()

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
    Box(
        Modifier
            .fillMaxWidth()
            .padding(vertical = Padding.Medium, horizontal = Padding.Medium)
            .background(AppTheme.background.card, RoundedCornerShape(RoundedCorner.Medium))
            .shadow(Shadow.Low, spotColor = Color.Transparent)
            .clickable { onClick.invoke(id) }
    ) {
        Column(Modifier.padding(vertical = Padding.Medium, horizontal = Padding.Medium)) {
            Text(
                text = "id = $id",
                modifier = Modifier
                    .padding(vertical = Padding.Small, horizontal = Padding.Small)
            )
            Text(
                text = "name = ${campaign.name}",
                modifier = Modifier
                    .padding(vertical = Padding.Small, horizontal = Padding.Small)
            )
        }
    }
}
