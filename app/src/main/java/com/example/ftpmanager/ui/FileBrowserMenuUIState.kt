package com.example.ftpmanager.ui

import com.example.ftpmanager.domain.Connection

data class FileBrowserMenuUIState(
    val workingConnections: List<Connection> = listOf(),
    val selectedConnection: Connection? = null
)
