package com.example.ftpmanager.domain

import com.example.ftpmanager.data.DatabaseHandler

class ConnectionFactory constructor(    ///// try to not use it

    var db: DatabaseHandler
) {

    fun createFTP(name: String, ip: String, username: String = "", password: String = "", port: Int = 21): FTP {
        val ftp = FTP(name, ip, username, password, port)
        db.insertConnection(ftp)
        return ftp
    }
    fun deleteFTP(ftp: FTP) {
        db.deleteConnection(ftp)
    }
}