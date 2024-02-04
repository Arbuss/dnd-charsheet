package com.arbuss.ui.screen.characters_list.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.arbuss.ui.R
import com.arbuss.ui.screen.main.LocalAppTheme
import com.arbuss.ui.theme.Padding
import com.arbuss.ui.utils.ui.Button
import com.arbuss.ui.utils.ui.TopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterAddScreen(campaignId: Int, viewModel: CharacterAddViewModel = koinViewModel()) {
    viewModel.campaignId = campaignId

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        TopBar(settings = viewModel.topBarSettings)

        OutlinedTextField(
            value = viewModel.characterName,
            onValueChange = { viewModel.onCharacterNameChanged(it) },
            isError = viewModel.isError,
            label = { Text(stringResource(R.string.character_add_screen_name_label)) },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = LocalAppTheme.current.text.Primary,
                focusedBorderColor = LocalAppTheme.current.background.Stroke,
                unfocusedBorderColor = LocalAppTheme.current.background.Stroke,
                errorBorderColor = LocalAppTheme.current.text.Negative,
                focusedLabelColor = LocalAppTheme.current.text.Positive,
                errorLabelColor = LocalAppTheme.current.text.Negative
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.Giant, vertical = Padding.Large)
        )

        Button(
            onClick = viewModel::onSaveClick, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.Giant, vertical = Padding.Large),
            text = stringResource(R.string.character_add_screen_button_save)
        )
    }
}