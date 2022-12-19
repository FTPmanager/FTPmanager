package com.example.ftpmanager.ui.components.complex_components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ftpmanager.domain.Connection
import com.example.ftpmanager.ui.ConnectMenuViewModel
import com.example.ftpmanager.R
import com.example.ftpmanager.domain.FTP

@Composable
fun ConnectMenu(
    modifier: Modifier = Modifier,
    connectMenuViewModel: ConnectMenuViewModel = viewModel()
) {
    val connectMenuUIState by connectMenuViewModel.uiState.collectAsState()
    Scaffold(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        floatingActionButton = { FloatingAddButton() }
    ) {
        paddingValues -> ConnectMenuBody(
            connectMenuUIState.connections,
            modifier = modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .verticalScroll(rememberScrollState())
        )
    }

}

@Composable
fun ConnectMenuBody(cons: List<Connection>, modifier: Modifier = Modifier) {
    val testConnection = FTP(
        name = "test FTP preset",
        ip = "192.168.1.1"
    )
    LazyColumn(
        userScrollEnabled = true,
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
//        cons.forEach { con ->
//            //ConnectCard(con, {}, {}, {})
//        }
        //item{ConnectCard(testConnection, {}, {}, {})}
    }
}

@Composable
fun FloatingAddButton(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = modifier
    ) {
        Icon(
            painter= painterResource(R.drawable.ic_outline_add_24),
            contentDescription = null,
            tint = MaterialTheme.colors.onPrimary
        )
    }
}
