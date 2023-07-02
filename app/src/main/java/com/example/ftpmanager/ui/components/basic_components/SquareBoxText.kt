package com.example.ftpmanager.ui.components.basic_components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(25),
        modifier = modifier.wrapContentHeight()
            .wrapContentWidth()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4,
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

@Preview
@Composable
fun SquareBoxTextWithIPv4Preview() {
    FTPmanagerTheme {
        SquareBoxText("192.168.1.1", Modifier)
    }
}

@Preview
@Composable
fun SquareBoxTextWithIPv6Preview() {
    FTPmanagerTheme {
        SquareBoxText("2345:0425:2CA1:0000:0000:0567:5673:23b5", Modifier)
    }
}
