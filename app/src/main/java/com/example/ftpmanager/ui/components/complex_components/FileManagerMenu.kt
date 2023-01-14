package com.example.ftpmanager.ui.components.complex_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.ftpmanager.R
import com.example.ftpmanager.domain.FTP
import com.example.ftpmanager.ui.components.basic_components.TextButton

@Composable
fun FileManagerMenu(
    modifier: Modifier = Modifier
) {
    Text(text = stringResource(R.string.wip))
    TextButton(
        text = R.string.test_button,
        onClick = {  },
        modifier = modifier.fillMaxWidth()
    )
}