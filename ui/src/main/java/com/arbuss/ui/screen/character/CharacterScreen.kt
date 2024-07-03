package com.arbuss.ui.screen.character

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arbuss.data.model.Character
import com.arbuss.data.model.character.CharacterExperience
import com.arbuss.data.model.character.CharacterLevel
import com.arbuss.data.model.character.CharacterTitleInfo
import com.arbuss.ui.R
import com.arbuss.ui.theme.AppTheme
import com.arbuss.ui.utils.ui.CharacterTitleInfoExpBar
import com.arbuss.ui.utils.ui.TopBar
import com.arbuss.ui.utils.ui.bottomElevation
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CharacterScreen(
    initialCharacter: Character,
    viewModel: CharacterViewModel = koinViewModel(parameters = { parametersOf(initialCharacter) })
) {
    val character = viewModel.character.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TopBar(settings = viewModel.topBarSettings)
        CharacterTitleInfo(character.value.titleInfo)
    }
}

@Composable
private fun CharacterTitleInfo(info: CharacterTitleInfo) {
    Column(Modifier.background(color = AppTheme.background.Primary)) {
        Box(Modifier.padding(AppTheme.padding.Small)) {
            CharacterTitleInfoExpBar(experience = info.experience)
        }

        Row(
            modifier = Modifier
                .padding(AppTheme.padding.Medium)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .bottomElevation(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CharacterTitleInfoArmorPoint(info.armorPoint)

            Column(
                modifier = Modifier
                    .padding(AppTheme.padding.Medium)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                CharacterTitleInfoTextField(
                    title = R.string.character_screen_character_title_info_race,
                    text = info.race
                )

                CharacterTitleInfoTextField(
                    title = R.string.character_screen_character_title_info_class,
                    text = info.characterClass
                )
            }

            Column(
                modifier = Modifier
                    .padding(AppTheme.padding.Medium)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                CharacterTitleInfoTextField(
                    title = R.string.character_screen_character_title_info_speed,
                    text = info.speed
                )

                CharacterTitleInfoTextField(
                    title = R.string.character_screen_character_title_info_initiative,
                    text = info.initiative
                )
            }
        }
    }
}

@Composable
private fun CharacterTitleInfoArmorPoint(armorPoint: String) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .paint(
                painterResource(id = R.drawable.ic_shield_icon),
                contentScale = ContentScale.FillBounds,
                colorFilter = ColorFilter.tint(AppTheme.icon.Primary)
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = armorPoint, color = AppTheme.text.Primary)
    }
}

@Composable
private fun CharacterTitleInfoTextField(@StringRes title: Int, text: String) {
    Text(stringResource(title, text), color = AppTheme.text.Primary)
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CharacterTitleInfoPreview() {
    val data = CharacterTitleInfo(
        race = "Human",
        characterClass = "Warrior",
        armorPoint = "14 + 1",
        speed = "30",
        initiative = "30",
        experience = CharacterExperience(2200, CharacterLevel.LEVEL_3)
    )

    CharacterTitleInfo(data)
}