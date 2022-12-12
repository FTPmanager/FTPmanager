package com.example.ftpmanager.ui.components.basic_components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
        style = MaterialTheme.typography.titleMedium,
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