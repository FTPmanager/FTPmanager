package com.example.ftpmanager.ui.components.basic_components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
        shape = MaterialTheme.shapes.medium,
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
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun IconTextButtonPreview() {
    FTPmanagerTheme {
        IconTextButton(
            icon = R.drawable.ic_outline_file_download_24,
            text = R.string.connect_menu,
            onClick = {},
            modifier = Modifier
        )
    }
}