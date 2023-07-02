package com.example.ftpmanager.domain

import com.example.ftpmanager.data.DatabaseHandler

object ConnectionFactory {

    fun getConnection(name: String, ip: String, username: String = "", password: String = "", port: Int = 21): Connection {
        val ftp = FTP(name, ip, username, password, port)
        //db.insertConnection(ftp)
        return ftp
    }
//    fun deleteFTP(ftp: FTP) {
//        db.deleteConnection(ftp)
//    }
}