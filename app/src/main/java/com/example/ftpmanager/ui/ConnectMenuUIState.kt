package com.example.ftpmanager.ui

import com.example.ftpmanager.domain.Connection

data class ConnectMenuUIState(
    val connections: List<Connection> = listOf(),
    val isBeingAdded: Boolean = false,
    val isBeingEdited: Boolean = false,
    val editedConnection: Connection? = null,
    val textFieldName: String = "",
    val textFieldIP: String = "",
    val textFieldUsername: String = "",
    val textFieldPassword: String = "",
    val textFieldPort: String = ""
)

