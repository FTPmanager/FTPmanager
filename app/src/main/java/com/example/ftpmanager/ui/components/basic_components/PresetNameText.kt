package com.example.ftpmanager.ui.components.basic_components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

@Composable
fun PresetNameText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h3,
        modifier = modifier
    )
}

@Preview
@Composable
fun PresetNameTextPreview() {
    FTPmanagerTheme {
        Surface {
            PresetNameText("This is a preset name")
        }
    }
}