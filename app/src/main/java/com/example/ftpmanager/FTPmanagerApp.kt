package com.example.ftpmanager.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ftpmanager.R
import com.example.ftpmanager.data.DatabaseHandler
import com.example.ftpmanager.ui.components.complex_components.ConnectMenu
import com.example.ftpmanager.ui.components.complex_components.FloatingAddButton

@Composable
fun FTPmanagerApp(
    modifier: Modifier = Modifier,
    db: DatabaseHandler
) {
    val navController = rememberNavController()
    Scaffold(
        topBar = { FTPmanagerAppTopBar() },
        modifier = modifier,
    ) {
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.CONNECT.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = Screens.CONNECT.name) {
                ConnectMenu(
                    modifier = modifier.padding(innerPadding),
                    connectMenuViewModel = ConnectMenuViewModel(db)
                )
            }

            composable(route = Screens.SHARE.name) {

            }

            composable(route = Screens.SYNC.name) {

            }

            composable(route = Screens.FILE_STATUS.name) {

            }

            composable(route = Screens.FILE_BROWSER.name) {

            }
        }

    }
}

@Composable
fun FTPmanagerAppTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
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