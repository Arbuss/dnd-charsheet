package com.arbuss.ui.utils.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arbuss.ui.theme.AppTheme

@Composable
fun DndButton(
    modifier: Modifier = Modifier,
    text: String, textColor: Color = AppTheme.text.inverted,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(containerColor = AppTheme.button.primary),
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = buttonColors,
        interactionSource = interactionSource,
    ) {
        Text(text = text, color = textColor)
    }
}
