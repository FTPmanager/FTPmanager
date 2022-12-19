package com.example.ftpmanager.ui.components.basic_components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.R

@Composable
fun FileListElement(
    text: String,
    modifier: Modifier = Modifier,
    isDirectory: Boolean = false
) {
    Button(onClick = {}, modifier = modifier.fillMaxWidth().wrapContentHeight()) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()) {
            if (isDirectory)
                Icon(painter = painterResource(R.drawable.ic_outline_folder_24), contentDescription = null)
            else
                Icon(painter = painterResource(R.drawable.ic_outline_insert_drive_file_24), contentDescription = null)
            Text(text = text, style = MaterialTheme.typography.h4)
        }
    }
}

@Preview
@Composable
fun FileListElementFilePreview() {
    val modifier = Modifier
    Surface(modifier = modifier.size(100.dp)) {
        FileListElement(text = "test file", modifier = modifier, isDirectory = false)
    }
}

@Preview
@Composable
fun FileListElementFolderPreview() {
    val modifier = Modifier
    Surface(modifier = modifier.size(100.dp)) {
        FileListElement(text = "test file", modifier = modifier, isDirectory = true)
    }
}