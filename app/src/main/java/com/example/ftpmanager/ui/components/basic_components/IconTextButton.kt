package com.example.ftpmanager.ui.components.basic_components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
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
        shape = RoundedCornerShape(25),
        modifier = modifier.size(96.dp)
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
        IconTextButton(
            icon = R.drawable.ic_outline_file_download_24,
            text = R.string.connect_menu,
            onClick = {},
            modifier = Modifier
        )
    }
}