package com.example.ftpmanager.ui.components.basic_components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.R
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

@Composable
fun IconButton(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
            //.background(MaterialTheme.colorScheme.secondary)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun IconButtonPreview() {
    FTPmanagerTheme {
        Surface(modifier = Modifier.size(64.dp)) {
            IconButton(R.drawable.ic_outline_settings_24, {})
        }
    }
}
