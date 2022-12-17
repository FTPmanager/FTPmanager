package com.example.ftpmanager.ui.components.complex_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.R
import com.example.ftpmanager.ui.components.basic_components.IconTextButton
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

@Composable
fun BottomBar(
    selected: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconTextButton(
            icon = R.drawable.ic_outline_file_download_24,
            text = R.string.connect_menu,
            onClick = {},
            modifier = modifier
        )
        IconTextButton(
            icon = R.drawable.ic_outline_file_upload_24,
            text = R.string.share_menu,
            onClick = {},
            modifier = modifier
        )
        IconTextButton(
            icon = R.drawable.ic_outline_file_download_24,
            text = R.string.sync_menu,
            onClick = {},
            modifier = modifier
        )
        IconTextButton(
            icon = R.drawable.ic_outline_file_download_24,
            text = R.string.file_status_menu,
            onClick = {},
            modifier = modifier
        )
        IconTextButton(
            icon = R.drawable.ic_outline_file_download_24,
            text = R.string.file_manager_menu,
            onClick = {},
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    FTPmanagerTheme {
        Surface(
            modifier = Modifier.width(500.dp)
                .height(100.dp)
        ) {
            BottomBar(selected = 1, modifier = Modifier)
        }
    }
}