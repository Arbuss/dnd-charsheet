package com.arbuss.ui.screen.characters_list

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
import com.arbuss.data.model.Character
import com.arbuss.ui.utils.ui.TopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersListScreen(campaignId: Int, viewModel: CharactersListViewModel = koinViewModel()) {
    val charactersList by viewModel.charactersList.collectAsState()
    viewModel.updateCharactersList(campaignId)

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
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clickable { onClick.invoke(id) }
//            .background(RoundedCornerShape(8.dp))
    ) {
        Text(text = "id = $id", Modifier.padding(vertical = 4.dp, horizontal = 4.dp))
        Text(text = "name = ${character.name}", Modifier.padding(vertical = 4.dp, horizontal = 4.dp))
    }
}