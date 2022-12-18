package com.example.ftpmanager.domain

import android.util.Log
import org.apache.commons.net.ftp.FTPClient


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
            client.connect(ip)
            client.login(username, password)
            client.disconnect()

        } catch (e: Exception) {
            Log.e(TAG, "Funny Szymon's Error")                             ///////
            //e.printStackTrace()                                  ///////
            connectionStatus = ConnectionStatus.ERROR
        }
    }

    override fun disconnect() {
        if(connectionStatus == ConnectionStatus.CONNECTED)
            client.disconnect()
    }

    override fun status(): ConnectionStatus {
        return connectionStatus
    }

    override fun toString(): String {
        return "name: " + name + ", ip: " + ip + ", username: " + username + ", password: " + password + ", port: " + port
    }
}
