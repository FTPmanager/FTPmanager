package com.example.ftpmanager.domain

import android.util.Log
import android.os.Handler
import android.os.Looper
import org.apache.commons.net.ftp.FTPClient
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class FTP public constructor(

    override var name: String,
    override var ip: String,
    override var username: String = "",
    override var password: String = "",
    override var port: Int = 21

) : Connection {

    @Volatile
    override var currentPath: String = ""

    @Volatile
    override var connectionStatus: ConnectionStatus = ConnectionStatus.DISCONNECTED

    @Volatile
    override var nameList: List<FileData> = emptyList()

    var handler = Handler(Looper.getMainLooper())

    override fun activate() {
        if(connectionStatus == ConnectionStatus.DISCONNECTED || connectionStatus == ConnectionStatus.CONNECTING) {
            handler.post( Runnable {

                val client = FTPClient()
                try {
                    connectionStatus = ConnectionStatus.CONNECTING

                    client.connect(ip, port)
                    client.login(username, password)

                    connectionStatus = ConnectionStatus.CONNECTED

                } catch (e: Exception) {

                    Log.e("FTPmanager FTP activate", "Could not connect to $name")
                    connectionStatus = ConnectionStatus.ERROR

                } finally {
                    client.disconnect()
                }
            })
        }
    }
    override fun deactivate() {
        connectionStatus = ConnectionStatus.DISCONNECTED
    }
    override fun status(): ConnectionStatus {
        return connectionStatus
    }
    override fun listNames(): Boolean {

        if (connectionStatus != ConnectionStatus.CONNECTED) {
            Log.e("FTPmanager FTP listNames", "Could not list file names for $name, because connection to server is not established!")
        }

        var ftpClient = FTPClient()
        var nameListI: List<FileData> = emptyList()
        var result = true
        try {
            ftpClient.connect(ip)
            ftpClient.login(username, password)
            ftpClient.changeWorkingDirectory(currentPath)

            nameListI = ftpClient.listNames(currentPath).toList().map {
                FileData(it, ftpClient.mlistFile(it).isDirectory)
            }
            nameList= nameListI
        } catch (e: Exception) {
            Log.e("FTPmanager FTP listNames", "Could not list file names of $name in $currentPath")
            result = false
        } finally {
            ftpClient.disconnect()
        }
        return result
    }
    override fun downloadFiles(localPath: String, fileNames: List<String>): Boolean {

        if (connectionStatus != ConnectionStatus.CONNECTED) {
            Log.e("FTPmanager FTP downloadFiles", "Could not download files from $name, because connection to server is not established!")
        }

        val ftpClient = FTPClient()
        var result = true
        try {
            ftpClient.connect(ip)
            ftpClient.login(username, password)
            ftpClient.changeWorkingDirectory(currentPath)

            for (name in fileNames) {

                var file = File(localPath + name)
                while (file.exists()) {
                    file = File(localPath+ "(1)" + file.name)              //// Might not work properly
                }

                val outputStream = FileOutputStream(file)
                ftpClient.retrieveFile(name, outputStream)
            }
        } catch (e: Exception) {
            Log.e("FTPmanager FTP downloadFiles", "Could not download files from $name")
            result = false
        } finally {
            ftpClient.disconnect()
        }
        return result
    }
    override fun uploadFiles(localPath: String, fileNames: List<String>): Boolean {
        if (connectionStatus != ConnectionStatus.CONNECTED) {
            Log.e("FTPmanager FTP uploadFiles", "Could not upload files to $name, because connection to server is not established!")
        }

        val ftpClient = FTPClient()
        var result = true
        try {
            ftpClient.connect(ip)
            ftpClient.login(username, password)
            ftpClient.changeWorkingDirectory(currentPath)

            for (name in fileNames) {

                var file = File(localPath + name)
                val inputStream = FileInputStream(file)
                ftpClient.storeFile(name, inputStream)
            }
        } catch (e: Exception) {
            Log.e("FTPmanager FTP uploadFiles", "Could not upload files to $name")
            result = false
        } finally {
            ftpClient.disconnect()
        }
        return result
    }

    override fun type(): Connections {
        return Connections.FTP
    }
    override fun toString(): String {
        return "name: " + name +
                ", ip: " + ip +
                ", username: " + username +
                ", password: " + password +
                ", port: " + port
    }
}
