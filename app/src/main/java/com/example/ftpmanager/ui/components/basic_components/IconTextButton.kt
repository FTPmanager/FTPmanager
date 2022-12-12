package com.example.ftpmanager.ui.components.basic_components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.R
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

@Composable
fun IconTextButton(
    @DrawableRes icon: Int,
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(64.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
                .fillMaxHeight()
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = modifier
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.labelSmall,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun IconTextButtonPreview() {
    FTPmanagerTheme {
        Surface(
            modifier = Modifier.size(128.dp)
        ) {
            IconTextButton(
                icon = R.drawable.ic_outline_file_download_24,
                text = R.string.connect_menu,
                onClick = {},
                modifier = Modifier
            )
        }
    }
}