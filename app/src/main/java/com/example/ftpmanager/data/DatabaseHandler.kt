package com.example.ftpmanager.data

import android.provider.BaseColumns

object DatabaseHandler {

    object ConnectData : BaseColumns {

        const val TABLE_NAME = "ConnectData"
        const val COL_IP = "Ip"
        const val COL_USERNAME = "Username"
        const val COL_PASSWORD = "Password"
        const val COL_PORT = "Port"
    }
}