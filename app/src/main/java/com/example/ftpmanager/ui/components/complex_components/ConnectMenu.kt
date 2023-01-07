package com.example.ftpmanager.ui.components.complex_components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ftpmanager.R
import com.example.ftpmanager.domain.Connection
import com.example.ftpmanager.ui.ConnectMenuUIState
import com.example.ftpmanager.ui.ConnectMenuViewModel
import com.example.ftpmanager.ui.components.basic_components.BasicTextField
import com.example.ftpmanager.ui.components.basic_components.TextButton

@Composable
fun ConnectMenu(
    modifier: Modifier = Modifier,
    connectMenuViewModel: ConnectMenuViewModel
) {
    val connectMenuUIState by connectMenuViewModel.uiState.collectAsState()
    if (connectMenuUIState.isBeingAdded || connectMenuUIState.isBeingEdited) {
        Scaffold(
            modifier = modifier,
            backgroundColor = MaterialTheme.colors.primary,
            topBar = { ConnectMenuAddTopBar(onCancel = connectMenuViewModel::stopAddingOrEditingConnection, isEdited = connectMenuUIState.isBeingEdited) },
        ) { paddingValues ->
            ConnectMenuAdd(
                connectMenuUIState,
                connectMenuViewModel,
                modifier = modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
            )
        }
    }
    else {
        Scaffold(
            modifier = modifier,
            backgroundColor = MaterialTheme.colors.primary,
            topBar = { ConnectMenuListTopBar(modifier) },
            floatingActionButton = { FloatingAddButton(onClick = connectMenuViewModel::startAddingConnection) }
        ) { paddingValues ->
            ConnectMenuList(
                connectMenuViewModel = connectMenuViewModel,
                connectMenuUIState = connectMenuUIState,
                modifier = modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
            )
        }
    }
}

@Composable
fun ConnectMenuList(connectMenuViewModel: ConnectMenuViewModel, connectMenuUIState: ConnectMenuUIState, modifier: Modifier = Modifier) {
    LazyColumn(
        userScrollEnabled = true,
        verticalArrangement = Arrangement.spacedBy((-10).dp),
        modifier = modifier
    ) {
        items(connectMenuUIState.connections.size) { i ->
            ConnectCard(
                con = connectMenuUIState.connections[i],
                connect_button_onClick = { connectMenuViewModel.connectConnection(connectMenuUIState.connections[i]) },
                disconnect_button_onClick = { connectMenuViewModel.disconnectConnection(connectMenuUIState.connections[i]) },
                settings_button_onClick = { connectMenuViewModel.startEditingConnection(connectMenuUIState.connections[i]) }
            )
        }
    }
}

@Composable
fun FloatingAddButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_outline_add_24),
            contentDescription = null,
            tint = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
fun ConnectMenuAdd(
    connectMenuUIState: ConnectMenuUIState,
    connectMenuViewModel: ConnectMenuViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy((-10).dp),
        modifier = modifier
    ) {
        BasicTextField(
            label = R.string.con_name_text_field,
            value = connectMenuUIState.textFieldName,
            onValueChange = { connectMenuViewModel.updateTextFieldName(it) },
            modifier = modifier.fillMaxWidth().padding(10.dp)
        )
        BasicTextField(
            label = R.string.con_ip_text_field,
            value = connectMenuUIState.textFieldIP,
            onValueChange = { connectMenuViewModel.updateTextFieldIP(it) },
            modifier = modifier.fillMaxWidth().padding(10.dp)
        )
        BasicTextField(
            label = R.string.con_username_text_field,
            value = connectMenuUIState.textFieldUsername,
            onValueChange = { connectMenuViewModel.updateTextFieldUsername(it) },
            modifier = modifier.fillMaxWidth().padding(10.dp)
        )
        BasicTextField(
            label = R.string.con_password_text_field,
            value = connectMenuUIState.textFieldPassword,
            onValueChange = { connectMenuViewModel.updateTextFieldPassword(it) },
            modifier = modifier.fillMaxWidth().padding(10.dp)
        )
        BasicTextField(
            label = R.string.con_port_text_field,
            value = connectMenuUIState.textFieldPort,
            onValueChange = { connectMenuViewModel.updateTextFieldPort(it) },
            modifier = modifier.fillMaxWidth().padding(10.dp)
        )
        if (connectMenuUIState.isBeingAdded) {
            TextButton(
                text = R.string.add,
                onClick = {
                    connectMenuViewModel.createConnection()
                    connectMenuViewModel.stopAddingOrEditingConnection()
                          },
                modifier = modifier.padding(10.dp).fillMaxWidth()
            )
        }
        else {
            Row(
                modifier = modifier.fillMaxWidth().wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    text = R.string.save,
                    onClick = {
                        connectMenuViewModel.editConnection()
                        connectMenuViewModel.stopAddingOrEditingConnection()
                              },
                    modifier = modifier.padding(10.dp)
                )
                TextButton(
                    text = R.string.remove,
                    onClick = {
                        connectMenuViewModel.removeConnection()
                        connectMenuViewModel.stopAddingOrEditingConnection()
                              },
                    modifier = modifier.padding(10.dp)
                )
            }
        }

    }
}

@Composable
fun ConnectMenuListTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.connect_menu)) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(painter= painterResource(R.drawable.ic_outline_list_24), contentDescription = null)
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 4.dp,
        modifier = modifier
    )
}

@Composable
fun ConnectMenuAddTopBar(onCancel: () -> Unit, isEdited: Boolean, modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            if (isEdited)
                Text(text = stringResource(R.string.edit_connection))
            else
                Text(text = stringResource(R.string.add_connection))
                },
        navigationIcon = {
            IconButton(onClick = onCancel) {
                Icon(painter= painterResource(R.drawable.ic_outline_arrow_back_24), contentDescription = null)
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 4.dp,
        modifier = modifier
    )
}
