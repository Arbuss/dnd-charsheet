package com.arbuss.ui.screen.characterslist.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.arbuss.data.model.Character
import com.arbuss.data.model.character.CharacterExperience
import com.arbuss.data.model.character.CharacterLevel
import com.arbuss.data.model.character.CharacterTitleInfo
import com.arbuss.data.repository.CharacterRepository
import com.arbuss.ui.R
import com.arbuss.ui.navigation.Router
import com.arbuss.ui.utils.TopBarButtonSettings
import com.arbuss.ui.utils.TopBarSettings

class CharacterAddViewModel(
    private val characterRepository: CharacterRepository,
    private val router: Router
) : ViewModel() {
    val topBarSettings = TopBarSettings(
        stringId = R.string.character_add_screen_header,
        leftButton = TopBarButtonSettings(R.drawable.ic_arrow_back) { router.back() }
    )

    var characterName by mutableStateOf("")
        private set

    var isError by mutableStateOf(false)
        private set

    var campaignId: Int = -1

    var characterTitleInfo = CharacterTitleInfo(
        race = "Human",
        characterClass = "Warrior",
        armorPoint = "14 + 1",
        speed = "30",
        initiative = "30",
        experience = CharacterExperience(
            2200, CharacterLevel.LEVEL_3
        )
    )

    fun onSaveClick() {
        if (characterName.isNotBlank()) {
            characterRepository.add(Character(null, characterName, characterTitleInfo, campaignId))
            router.back()
        } else {
            isError = true
        }
    }

    fun onCharacterNameChanged(name: String) {
        characterName = name
        isError = false
    }
}
