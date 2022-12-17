package com.example.ftpmanager.data

import com.example.ftpmanager.domain.Connection
import com.example.ftpmanager.domain.Share
import com.example.ftpmanager.domain.Sync

object LoadedData {

    var connections = mutableListOf<Connection>()
    var shares = mutableListOf<Share>()
    var syncs = mutableListOf<Sync>()
}