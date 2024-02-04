package com.arbuss.ui.screen.characters_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arbuss.data.model.Character
import com.arbuss.data.repository.CharacterRepository
import com.arbuss.ui.navigation.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersListViewModel(
    private val characterRepository: CharacterRepository,
    private val router: Router
) : ViewModel() {

    private val _charactersList: MutableStateFlow<List<Character>> = MutableStateFlow(emptyList())
    val charactersList: StateFlow<List<Character>> = _charactersList.asStateFlow()

    fun init(campaignId: Int) {
        viewModelScope.launch {
            val characters = characterRepository.getAllCharactersFromCampaign(campaignId)
            _charactersList.emit(characters)
        }
    }

    fun onClick(id: Int) {

    }
}