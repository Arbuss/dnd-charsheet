package com.arbuss.ui.screen.characters_list

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
import com.arbuss.data.model.Character
import com.arbuss.ui.screen.main.LocalAppTheme
import com.arbuss.ui.theme.Padding
import com.arbuss.ui.theme.RoundedCorner
import com.arbuss.ui.theme.Shadow
import com.arbuss.ui.utils.ui.TopBar
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CharactersListScreen(campaignId: Int, viewModel: CharactersListViewModel = koinViewModel(parameters = { parametersOf(campaignId) })) {
    val charactersList by viewModel.charactersList.collectAsState()

    Column(Modifier.fillMaxSize()) {
        TopBar(settings = viewModel.topBarSettings)

        LazyColumn {
            items(charactersList) { character ->
                character.id?.let { id ->
                    CharactersListItem(id, character) { viewModel.onClick(id) }
                }
            }
        }
    }
}

@Composable
private fun CharactersListItem(id: Int, character: Character, onClick: (Int) -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(vertical = Padding.Medium, horizontal = Padding.Medium)
            .background(LocalAppTheme.current.background.Card, RoundedCornerShape(RoundedCorner.Medium))
            .shadow(Shadow.Low, spotColor = Color.Transparent)
            .clickable { onClick.invoke(id) }
    ) {
        Column(Modifier.padding(vertical = Padding.Medium, horizontal = Padding.Medium)) {
            Text(text = "id = $id", Modifier.padding(vertical = Padding.Small, horizontal = Padding.Small))
            Text(text = "name = ${character.name}", Modifier.padding(vertical = Padding.Small, horizontal = Padding.Small))
        }
    }
}