package com.arbuss.ui.screen.campaign.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.arbuss.ui.R
import com.arbuss.ui.theme.Padding
import com.arbuss.ui.utils.ui.DndButton
import com.arbuss.ui.utils.ui.DndOutlinedTextField
import com.arbuss.ui.utils.ui.TopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun CampaignAddScreen(viewModel: CampaignAddViewModel = koinViewModel()) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        TopBar(settings = viewModel.topBarSettings)

        DndOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.Giant, vertical = Padding.Large),
            value = viewModel.campaignName,
            label = stringResource(R.string.campaigns_add_screen_name_label),
            isError = viewModel.isError,
            onValueChange = { viewModel.onCampaignNameChanged(it) }
        )

        DndButton(
            onClick = viewModel::onSaveClick, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.Giant, vertical = Padding.Large),
            text = stringResource(R.string.campaigns_add_screen_button_save)
        )
    }
}