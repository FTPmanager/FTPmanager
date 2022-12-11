package com.example.ftpmanager.ui.components.basic_components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

@Composable
fun SquareBoxText(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        //color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(25),
        modifier = modifier.wrapContentHeight()
            .wrapContentWidth()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            modifier = modifier.padding(horizontal = 4.dp)
        )
    }
}

@Preview
@Composable
fun SquareBoxTextPreview() {
    FTPmanagerTheme {
        SquareBoxText("text text", Modifier)
    }
}

