package com.arbuss.ui.utils.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.arbuss.ui.screen.main.LocalAppTheme
import com.arbuss.ui.theme.Padding
import com.arbuss.ui.theme.Shadow
import com.arbuss.ui.theme.Typography
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
            .background(LocalAppTheme.current.background.PrimaryElevated)
            .shadow(Shadow.Low, spotColor = Color.Transparent),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        settings.leftButton?.let { buttonSettings ->
            Image(
                painterResource(buttonSettings.icon),
                null,
                Modifier
                    .padding(Padding.Large)
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .clickable(interactionSource, null) { buttonSettings.onClicked.invoke() }
            )
        }

        Text(
            titleText,
            Modifier
                .align(Alignment.CenterVertically)
                .weight(4f),
            textAlign = TextAlign.Center,
            style = Typography.titleLarge
        )

        settings.rightButton?.let { buttonSettings ->
            Image(
                painterResource(buttonSettings.icon),
                null,
                Modifier
                    .padding(Padding.Large)
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .clickable(interactionSource, null) { buttonSettings.onClicked.invoke() }
            )
        }
    }
}