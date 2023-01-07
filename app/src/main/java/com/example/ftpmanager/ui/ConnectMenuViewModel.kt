package com.example.ftpmanager.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ftpmanager.data.DatabaseHandler
import com.example.ftpmanager.domain.Connection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ConnectMenuViewModel(db: DatabaseHandler) : ViewModel() {
    private val _uiState = MutableStateFlow(ConnectMenuUIState())
    val uiState: StateFlow<ConnectMenuUIState> = _uiState.asStateFlow()

    init {
        //load connections to the ConnectMenuUIState
        _uiState.value = ConnectMenuUIState(connections = db.loadConnections())
    }

    fun startAddingConnection() {
        _uiState.update { currentState -> currentState.copy(
            isBeingAdded = true,
            isBeingEdited = false,
            textFieldName = "",
            textFieldIP = "",
            textFieldUsername = "",
            textFieldPassword = "",
            textFieldPort = ""
        ) }
    }

    fun startEditingConnection(con: Connection) {
        _uiState.update { currentState -> currentState.copy(
            isBeingAdded = false,
            isBeingEdited = true,
            editedConnection = con,
            textFieldName = con.name,
            textFieldIP = con.ip,
            textFieldUsername = con.username,
            textFieldPassword = con.password,
            textFieldPort = con.port.toString()
        ) }
    }

    fun stopAddingOrEditingConnection() {
        _uiState.update { currentState -> currentState.copy(isBeingAdded = false, isBeingEdited = false) }
    }

    fun createConnection() {
        //create new connection in the database
        //create new Connection object and add it to ConnectMenuUIState

    }

    fun removeConnection() {
        //remove connection from the database
        //remove Connection object from ConnectMenuUIState
    }

    fun editConnection() {

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

    fun updateTextFieldName(s: String) {
        _uiState.update { currentState -> currentState.copy(textFieldName = s) }
    }

    fun updateTextFieldIP(s: String) {
        _uiState.update { currentState -> currentState.copy(textFieldIP = s) }
    }

    fun updateTextFieldUsername(s: String) {
        _uiState.update { currentState -> currentState.copy(textFieldUsername = s) }
    }

    fun updateTextFieldPassword(s: String) {
        _uiState.update { currentState -> currentState.copy(textFieldPassword = s) }
    }

    fun updateTextFieldPort(s: String) {
        _uiState.update { currentState -> currentState.copy(textFieldPort = s) }
    }
}