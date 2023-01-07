package com.example.ftpmanager.ui

import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.ftpmanager.ui.components.complex_components.*

@Composable
fun FTPmanagerApp(
    modifier: Modifier = Modifier,
    db: DatabaseHandler
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController)},
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.CONNECT.name,
            modifier = modifier.padding(
                paddingValues = innerPadding
            )
        ) {
            composable(route = Screens.CONNECT.name) {
                ConnectMenu(
                    connectMenuViewModel = ConnectMenuViewModel(db)
                )
            }

            composable(route = Screens.SHARE.name) {
                ShareMenu(

                )
            }

            composable(route = Screens.SYNC.name) {
                SyncMenu(

                )
            }

            composable(route = Screens.FILE_STATUS.name) {
                FileStatusMenu(

                )
            }

            composable(route = Screens.FILE_BROWSER.name) {
                FileManagerMenu()
            }
        }
    }

}
