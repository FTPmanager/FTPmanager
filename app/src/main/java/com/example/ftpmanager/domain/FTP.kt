package com.example.ftpmanager.domain

import android.util.Log
import it.sauronsoftware.ftp4j.FTPClient


class FTP public constructor(

    override var name: String,
    override var ip: String,
    override var username: String = "",
    override var password: String = "",
    override var port: Int = 21

) : Connection {

    val client = FTPClient()
    private val TAG = "MyActivity"                              ///////

    override var connectionStatus: ConnectionStatus = ConnectionStatus.DISCONNECTED

    override fun connect() {

        try {
            connectionStatus = ConnectionStatus.CONNECTING
            client.connect(ip, port)
            Log.e(TAG, "Connected 1")                       ///////
            client.login(username, password)
            Log.e(TAG, "Connected 2")                       ///////
            client.type = FTPClient.TYPE_BINARY
            Log.e(TAG, "Connected 3")                       ///////
            client.disconnect(true)             ///////

        } catch (e: Exception) {
            Log.e(TAG, "Funny Szymon's Error")                             ///////
            //e.printStackTrace()                                  ///////
            connectionStatus = ConnectionStatus.ERROR
        }
    }

    override fun disconnect() {
        if(connectionStatus == ConnectionStatus.CONNECTED)
            client.disconnect(true)
    }

    override fun status(): ConnectionStatus {
        return connectionStatus
    }
}
