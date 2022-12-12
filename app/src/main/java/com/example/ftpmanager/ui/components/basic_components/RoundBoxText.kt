package com.example.ftpmanager.ui.components.basic_components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.R
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

@Composable
fun RoundBoxText(
    @StringRes text_id: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.tertiary,
        shape = RoundedCornerShape(50),
        modifier = modifier.wrapContentHeight()
            .wrapContentWidth()
    ) {
        Text(
            text = stringResource(text_id),
            style = MaterialTheme.typography.labelSmall,
            modifier = modifier.padding(horizontal = 4.dp)
        )
    }
}

@Preview
@Composable
fun RoundBoxTextFTPPreview() {
    FTPmanagerTheme {
        RoundBoxText(R.string.FTP, Modifier)
    }
}

@Preview
@Composable
fun RoundBoxTextSFTPPreview() {
    FTPmanagerTheme {
        RoundBoxText(R.string.SFTP, Modifier)
    }
}