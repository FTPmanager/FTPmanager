package com.example.ftpmanager.ui.components.complex_components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.R
import com.example.ftpmanager.domain.Connection
import com.example.ftpmanager.domain.ConnectionStatus
import com.example.ftpmanager.domain.FTP
import com.example.ftpmanager.ui.components.basic_components.*
import com.example.ftpmanager.ui.theme.*

@Composable
fun ConnectCard(
    con: Connection,
    connect_button_onClick: () -> Unit,
    disconnect_button_onClick: () -> Unit,
    settings_button_onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.Start,
                modifier = modifier.padding(10.dp)
            ) {
                RoundBoxText(R.string.FTP)
                PresetNameText(con.name)
                SquareBoxText(con.ip)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.End,
                modifier = modifier.padding(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier.padding(5.dp)
                ) {
                    SquareBoxText(
                        when(con.connectionStatus) {
                            ConnectionStatus.DISCONNECTED -> stringResource(R.string.connection_disconnected)
                            ConnectionStatus.CONNECTING -> stringResource(R.string.connection_connecting)
                            ConnectionStatus.CONNECTED -> stringResource(R.string.connection_connected)
                            ConnectionStatus.ERROR -> stringResource(R.string.connection_error)
                        }
                    )
                    Spacer(modifier.size(3.dp))
                    Diode(con.connectionStatus, modifier = modifier.size(15.dp))
                }
                IconButton(
                    icon = R.drawable.ic_outline_link_24,
                    onClick = connect_button_onClick,
                    modifier = Modifier.size(64.dp)
                )
            }
            //Divider(color = MaterialTheme.colors.background)
            IconButton(
                icon = R.drawable.ic_outline_settings_24,
                onClick = settings_button_onClick,
                modifier = Modifier.size(64.dp)
            )
        }
    }
}

@Preview
@Composable
fun ConnectCardsPreview() {
    val testConnection = FTP(
        name = "test FTP preset",
        ip = "192.168.1.1"
    )
    FTPmanagerTheme {
        ConnectCard(testConnection, {}, {}, {})
    }
}
