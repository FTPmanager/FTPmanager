package com.example.ftpmanager.ui.components.basic_components

import androidx.annotation.StringRes
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun TextButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        elevation = null,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(text = stringResource(text))
    }
}