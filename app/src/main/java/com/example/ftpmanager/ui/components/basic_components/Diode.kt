package com.example.ftpmanager.ui.components.basic_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.Icon
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ftpmanager.R
import com.example.ftpmanager.domain.ConnectionStatus
import com.example.ftpmanager.ui.theme.*

@Composable
fun Diode(
    connectionStatus: ConnectionStatus,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(R.drawable.ic_baseline_circle_24),
        contentDescription = null,
        tint = when (connectionStatus) {
            ConnectionStatus.DISCONNECTED -> DarkNormal
            ConnectionStatus.CONNECTING -> YellowNormal
            ConnectionStatus.CONNECTED -> GreenNormal
            ConnectionStatus.ERROR -> RedNormal
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun DiodeDisconnectedPreview() {
    FTPmanagerTheme {
        Diode(ConnectionStatus.DISCONNECTED)
    }
}

@Preview
@Composable
fun DiodeConnectingPreview() {
    FTPmanagerTheme {
        Diode(ConnectionStatus.CONNECTING)
    }
}

@Preview
@Composable
fun DiodeConnectedPreview() {
    FTPmanagerTheme {
        Diode(ConnectionStatus.CONNECTED)
    }
}

@Preview
@Composable
fun DiodeErrorPreview() {
    FTPmanagerTheme {
        Diode(ConnectionStatus.ERROR)
    }
}
