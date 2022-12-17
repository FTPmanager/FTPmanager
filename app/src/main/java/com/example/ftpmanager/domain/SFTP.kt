package com.example.ftpmanager.domain

import android.util.Log
import it.sauronsoftware.ftp4j.FTPClient

class SFTP public constructor(

    override var name: String,
    override var ip: String,
    override var username: String = "",
    override var password: String = "",
    override var port: Int = 21

) : Connection {

    override var connectionStatus: ConnectionStatus = ConnectionStatus.DISCONNECTED

    override fun connect() {}

    override fun disconnect() {}

    override fun status(): ConnectionStatus {
        return connectionStatus
    }
}