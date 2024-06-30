package com.arbuss.ui.utils.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arbuss.ui.R
import com.arbuss.ui.screen.main.LocalAppTheme
import com.arbuss.ui.theme.AppTheme
import com.arbuss.ui.theme.Padding
import com.arbuss.ui.theme.Shadow
import com.arbuss.ui.utils.TopBarButtonSettings
import com.arbuss.ui.utils.TopBarSettings

@Composable
internal fun TopBar(settings: TopBarSettings) {
    val interactionSource = remember { MutableInteractionSource() }

    val titleText = settings.additionalString?.let {
        stringResource(settings.stringId, it)
    } ?: stringResource(settings.stringId)

    Row(
        Modifier
            .fillMaxWidth()
            .background(AppTheme.background.PrimaryElevated)
            .shadow(Shadow.Low, spotColor = Color.Transparent),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.size(48.dp)) {
            settings.leftButton?.let { buttonSettings ->
                TopBarButton(buttonSettings, interactionSource)
            }
        }

        Text(
            titleText,
            Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth(0.8f),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.titleLarge
        )

        Box(Modifier.size(48.dp)) {
            settings.rightButton?.let { buttonSettings ->
                TopBarButton(buttonSettings, interactionSource)
            }
        }
    }
}

@Composable
private fun TopBarButton(
    buttonSettings: TopBarButtonSettings,
    interactionSource: MutableInteractionSource
) {
    Image(
        painterResource(buttonSettings.icon),
        null,
        Modifier
            .padding(Padding.Large)
            .clickable(interactionSource, null) {
                buttonSettings.onClicked.invoke()
            }
    )
}

@Preview
@Composable
private fun TopBarPreview() {
    val settings = TopBarSettings(
        stringId = R.string.top_bar_template,
        additionalString = "Title",
        leftButton = TopBarButtonSettings(R.drawable.ic_arrow_back) {  }
    )

    TopBar(settings = settings)
}