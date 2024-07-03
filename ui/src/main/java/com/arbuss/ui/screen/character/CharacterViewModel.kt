package com.arbuss.ui.screen.character

import androidx.lifecycle.ViewModel
import com.arbuss.data.model.Character
import com.arbuss.data.repository.CharacterRepository
import com.arbuss.ui.R
import com.arbuss.ui.navigation.Router
import com.arbuss.ui.utils.TopBarButtonSettings
import com.arbuss.ui.utils.TopBarSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Suppress("UnusedPrivateProperty")
class CharacterViewModel(
    private val characterRepository: CharacterRepository,
    private val router: Router,
    initialCharacter: Character
) : ViewModel() {

    val topBarSettings = TopBarSettings(
        stringId = R.string.character_screen_title_with_name,
        additionalString = initialCharacter.name,
        leftButton = TopBarButtonSettings(R.drawable.ic_arrow_back) { router.back() }
    )

    private var _character: MutableStateFlow<Character> = MutableStateFlow(initialCharacter)
    val character: StateFlow<Character> = _character.asStateFlow()
}
