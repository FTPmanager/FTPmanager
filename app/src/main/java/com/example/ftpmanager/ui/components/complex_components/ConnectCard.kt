package com.example.ftpmanager.ui.components.complex_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.R
import com.example.ftpmanager.domain.ConnectionStatus
import com.example.ftpmanager.ui.components.basic_components.*
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

@Composable
fun ConnectCard(
    modifier: Modifier = Modifier
) {
    Row(

    ) {
        Row(

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                RoundBoxText(R.string.FTP)
                PresetNameText("Test preset name")
                SquareBoxText("192.168.1.1")
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Row(

                ) {
                    SquareBoxText("Connected")
                    Diode(ConnectionStatus.CONNECTED)
                }
                IconButton(
                    icon = R.drawable.ic_outline_insert_link_24,
                    onClick = {}
                )
            }
        }
        IconButton(
            icon = R.drawable.ic_outline_settings_24,
            onClick = {}
        )
    }

}

@Preview
@Composable
fun ConnectCardConnectedPreview() {
    FTPmanagerTheme {
        Surface(
            modifier = Modifier.size(300.dp)
        ) {
            ConnectCard()
        }
    }
}
