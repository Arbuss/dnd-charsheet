package com.arbuss.ui.screen.characters_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arbuss.data.model.Character
import com.arbuss.data.repository.CharacterRepository
import com.arbuss.ui.R
import com.arbuss.ui.navigation.Destination
import com.arbuss.ui.navigation.Router
import com.arbuss.ui.utils.TopBarButtonSettings
import com.arbuss.ui.utils.TopBarSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersListViewModel(
    private val characterRepository: CharacterRepository,
    private val campaignId: Int,
    private val router: Router
) : ViewModel() {

    val topBarSettings = TopBarSettings(
        stringId = R.string.character_add_screen_header,
        leftButton = TopBarButtonSettings(R.drawable.ic_arrow_back) { router.back() },
        rightButton = TopBarButtonSettings(R.drawable.ic_plus) { router.navigate(Destination.CharacterAddScreen(campaignId)) }
    )

    private val _charactersList: MutableStateFlow<List<Character>> = MutableStateFlow(emptyList())
    val charactersList: StateFlow<List<Character>> = _charactersList.asStateFlow()

    init {
        viewModelScope.launch {
            characterRepository.getAllCharactersFromCampaignObservable(campaignId).collect {
                _charactersList.emit(it)
            }
        }
    }

    fun onClick(characterId: Int) {

    }
}