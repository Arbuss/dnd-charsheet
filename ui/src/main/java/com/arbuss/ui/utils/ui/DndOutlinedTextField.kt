package com.arbuss.ui.utils.ui

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arbuss.ui.theme.AppTheme

@Composable
fun DndOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    isError: Boolean = false,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        cursorColor = AppTheme.text.primary,
        focusedBorderColor = AppTheme.background.stroke,
        unfocusedBorderColor = AppTheme.background.stroke,
        errorBorderColor = AppTheme.text.negative,
        focusedLabelColor = AppTheme.text.positive,
        errorLabelColor = AppTheme.text.negative
    ),
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        label = { Text(label) },
        colors = colors,
        modifier = modifier
    )
}
