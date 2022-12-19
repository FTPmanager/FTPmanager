package com.example.ftpmanager.ui

import androidx.lifecycle.ViewModel
import com.example.ftpmanager.domain.Connection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConnectMenuViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ConnectMenuUIState())
    val uiState: StateFlow<ConnectMenuUIState> = _uiState.asStateFlow()

    init {
        //load connections to the ConnectMenuUIState
    }

    fun createConnection(/*values*/) {
        //create new connection in the database
        //create new Connection object and add it to ConnectMenuUIState
    }

    fun removeConnection(con: Connection) {
        //remove connection from the database
        //remove Connection object from ConnectMenuUIState
    }

    fun updateConnectionStates() {
        //don't know if required
        //function that would run f.e. every 1 second that would change diode colors and state messages
    }

    fun connectConnection(con: Connection) {
        //connect using this connection
    }

    fun disconnectConnection(con: Connection) {

    }
}