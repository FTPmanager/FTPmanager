package com.example.ftpmanager.ui

import com.example.ftpmanager.domain.Connection
import com.example.ftpmanager.domain.FileData

data class FileBrowserMenuUIState(
    val workingConnections: List<Connection> = listOf(),
    val selectedConnection: Connection? = null,
    var nameList: List<FileData> = emptyList()
)
