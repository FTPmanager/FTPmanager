package com.example.ftpmanager.ui.components.complex_components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ftpmanager.R
import com.example.ftpmanager.ui.components.basic_components.IconTextButton
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

@Composable
fun BottomBarButton(
    @DrawableRes icon: Int,
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    if (isSelected)
        IconTextButton(
            icon = icon,
            text = text,
            onClick = onClick,
            modifier = modifier.background(MaterialTheme.colorScheme.tertiary)
        )
    else
        IconTextButton(
            icon = icon,
            text = text,
            onClick = onClick,
            modifier = modifier
        )
}

@Preview
@Composable
fun BottomBarButtonNormalPreview() {
    FTPmanagerTheme {
        Surface {
            BottomBarButton(
                icon = R.drawable.ic_outline_file_download_24,
                text = R.string.file_manager_menu,
                onClick = {},
                modifier = Modifier,
                isSelected = false
            )
        }
    }
}

@Preview
@Composable
fun BottomBarButtonSelectedPreview() {
    FTPmanagerTheme {
        Surface {
            BottomBarButton(
                icon = R.drawable.ic_outline_file_download_24,
                text = R.string.file_manager_menu,
                onClick = {},
                modifier = Modifier,
                isSelected = true
            )
        }
    }
}

