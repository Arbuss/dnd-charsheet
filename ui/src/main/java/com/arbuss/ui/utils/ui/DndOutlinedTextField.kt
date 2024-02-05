package com.arbuss.ui.utils.ui

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arbuss.ui.screen.main.LocalAppTheme

@Composable
fun DndOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    isError: Boolean = false,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        cursorColor = LocalAppTheme.current.text.Primary,
        focusedBorderColor = LocalAppTheme.current.background.Stroke,
        unfocusedBorderColor = LocalAppTheme.current.background.Stroke,
        errorBorderColor = LocalAppTheme.current.text.Negative,
        focusedLabelColor = LocalAppTheme.current.text.Positive,
        errorLabelColor = LocalAppTheme.current.text.Negative
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