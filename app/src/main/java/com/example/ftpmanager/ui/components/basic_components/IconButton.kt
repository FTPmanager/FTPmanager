package com.example.ftpmanager.ui.components.basic_components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
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
        modifier = modifier.wrapContentHeight(),
        shape = RoundedCornerShape(100),
        elevation = null
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun IconButtonPreview() {
    FTPmanagerTheme {
        IconButton(R.drawable.ic_outline_settings_24, {})
    }
}
