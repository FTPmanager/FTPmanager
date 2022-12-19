package com.example.ftpmanager.ui

import com.example.ftpmanager.domain.Connection

data class ConnectMenuUIState(
    val connections: List<Connection> = listOf()
)

