package com.arbuss.ui.utils.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arbuss.data.model.character.CharacterExperience
import com.arbuss.data.model.character.CharacterLevel
import com.arbuss.data.model.character.CharacterLevelConstants
import com.arbuss.ui.theme.AppTheme

@Composable
fun CharacterTitleInfoExpBar(experience: CharacterExperience) {
    val roundedCornerShape = RoundedCornerShape(
        topEnd = AppTheme.corners.Medium, bottomEnd = AppTheme.corners.Medium
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(24.dp)
                .background(
                    color = AppTheme.background.card,
                    shape = RoundedCornerShape(
                        topStart = AppTheme.corners.Medium,
                        bottomStart = AppTheme.corners.Medium
                    )
                )
        ) {
            Text(
                text = "${experience.level.levelAsInt} уровень",
                textAlign = TextAlign.Center,
                color = AppTheme.text.inverted,
                modifier = Modifier
                    .padding(horizontal = AppTheme.padding.Medium)
            )
        }

        Row(
            modifier = Modifier
                .height(24.dp)
                .padding(start = 4.dp)
                .background(
                    color = AppTheme.background.stroke,
                    shape = roundedCornerShape
                )
        ) {
            CharacterTitleInfoExpBarFilling(
                experience = experience,
                roundedCornerShape = roundedCornerShape
            )
        }
    }
}

@Composable
private fun CharacterTitleInfoExpBarFilling(
    experience: CharacterExperience,
    roundedCornerShape: RoundedCornerShape
) {
    val isMaxLevel = experience.level.nextLevelAsInt == CharacterLevelConstants.MAX_LEVEL

    Box(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth(getProgressValue(experience.level.range, experience.value))
                .fillMaxHeight()
                .background(
                    color = AppTheme.background.card,
                    shape = roundedCornerShape
                )
        ) {}

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "${experience.value}/${
                    if (!isMaxLevel) {
                        experience.level.maxExp
                    } else {
                        ""
                    }
                }",
                textAlign = TextAlign.Center,
                color = AppTheme.text.inverted
            )
        }

        if (!isMaxLevel) {
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = AppTheme.padding.Medium)
            ) {
                Text(
                    text = "${experience.level.nextLevelAsInt}",
                    textAlign = TextAlign.Center,
                    color = AppTheme.text.inverted
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Suppress("MagicNumber")
private fun CharacterTitleInfoExpBarPreview() {
    val experience = CharacterExperience(354_000, CharacterLevel.LEVEL_20)
    CharacterTitleInfoExpBar(experience = experience)
}

private fun getProgressValue(range: IntRange, value: Int): Float {
    val end = range.last
    return value.toFloat() / end
}
