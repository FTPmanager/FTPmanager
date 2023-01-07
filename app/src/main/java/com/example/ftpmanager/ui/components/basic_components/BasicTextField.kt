package com.example.ftpmanager.ui.components.basic_components

import androidx.annotation.StringRes
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun BasicTextField(
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        label = { Text(stringResource(label))},
        onValueChange = onValueChange,
        singleLine = true,
        modifier = modifier
    )
}