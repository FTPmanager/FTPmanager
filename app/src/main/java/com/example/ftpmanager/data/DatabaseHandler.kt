package com.example.ftpmanager.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log
import com.example.ftpmanager.domain.*

class DatabaseHandler(context: Context): SQLiteOpenHelper(context, "FTPmanagerDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val createConnectTable = "CREATE TABLE IF NOT EXISTS " + ConnectionColumns.TABLE_NAME + "(" +
                ConnectionColumns.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConnectionColumns.COL_CONNECTION_TYPE + " INTEGER," +
                ConnectionColumns.COL_NAME + " VARCHAR(64)," +
                ConnectionColumns.COL_IP + " VARCHAR(40)," +
                ConnectionColumns.COL_USERNAME + " VARCHAR(256)," +
                ConnectionColumns.COL_PASSWORD + " VARCHAR(256)," +
                ConnectionColumns.COL_PORT + " INTEGER)"

        val createShareTable = "CREATE TABLE IF NOT EXISTS " + ShareColumns.TABLE_NAME + "(" +
                ShareColumns.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ShareColumns.COL_CONNECTION_TYPE + " INTEGER," +
                ShareColumns.COL_NAME + " VARCHAR(64)," +
                ShareColumns.COL_DIRECTORY + " VARCHAR(256)," +
                ShareColumns.COL_USERNAME + " VARCHAR(256)," +
                ShareColumns.COL_PASSWORD + " VARCHAR(256)," +
                ShareColumns.COL_PORT + " INTEGER)"

        val createSyncTable = "CREATE TABLE IF NOT EXISTS " + SyncColumns.TABLE_NAME + "(" +
                SyncColumns.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                SyncColumns.COL_CONNECTION_TYPE + " INTEGER," +
                SyncColumns.COL_NAME + " VARCHAR(64)," +
                SyncColumns.COL_IP + " VARCHAR(40)," +
                SyncColumns.COL_USERNAME + " VARCHAR(256)," +
                SyncColumns.COL_PASSWORD + " VARCHAR(256)," +
                SyncColumns.COL_PORT + " INTEGER)"

        db?.execSQL(createConnectTable)
        db?.execSQL(createShareTable)
        db?.execSQL(createSyncTable)
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")

    }
    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
        LoadedData.connections = loadConnections(db)
    }

    fun insertConnection(connection: Connection) {

        val db = this.writableDatabase
        var row = ContentValues()

        row.put(ConnectionColumns.COL_CONNECTION_TYPE, connection.type().value)
        row.put(ConnectionColumns.COL_NAME, connection.name)
        row.put(ConnectionColumns.COL_IP, connection.ip)
        row.put(ConnectionColumns.COL_USERNAME, connection.username)
        row.put(ConnectionColumns.COL_PASSWORD, connection.password)
        row.put(ConnectionColumns.COL_PORT, connection.port)

        var result = db.insert(ConnectionColumns.TABLE_NAME, null, row)
        reloadLists()

        if(result == (-1).toLong())
            Log.e("DatabaseHandler", "Failed to insert connection to database!")
        else
            Log.i("DatabaseHandler", "Added database record: " + connection.name)
    }
    fun insertShare(share: Share) {
        TODO()
    }
    fun insertSync(sync: Sync) {
        TODO()
    }

    fun loadConnections()  : MutableList<Connection> {
        return loadConnections(this.readableDatabase)
    }
    fun loadConnections(db: SQLiteDatabase?) : MutableList<Connection> {

        var list = mutableListOf<Connection>()
        if(db == null)
            return list

        val loadQuery = "SELECT * FROM " + ConnectionColumns.TABLE_NAME
        val result = db?.rawQuery(loadQuery, null)

        if(result.moveToFirst()) {
            do {
                when(result.getInt(1)) {
                    Connections.FTP.value -> list.add(FTP(
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6)
                    ))
                    Connections.SFTP.value -> list.add(SFTP(
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6)
                    ))
                    else -> continue
                }
            } while(result.moveToNext())
        }

        result.close()
        return list
    }
    fun reloadLists() {
        LoadedData.connections = loadConnections(this.readableDatabase)
    }
    fun deleteData() {
        val db = this.writableDatabase

        db.execSQL("DELETE * FROM " + ConnectionColumns.TABLE_NAME)
        db.execSQL("DELETE * FROM " + ShareColumns.TABLE_NAME)
        db.execSQL("DELETE * FROM " + SyncColumns.TABLE_NAME)
    }

    object ConnectionColumns : BaseColumns {

        const val TABLE_NAME = "ConnectionData"
        const val COL_ID = "ID"
        const val COL_CONNECTION_TYPE = "ConnectionType"
        const val COL_NAME = "Name"
        const val COL_IP = "IP"
        const val COL_USERNAME = "Username"
        const val COL_PASSWORD = "Password"
        const val COL_PORT = "Port"
    }
    object ShareColumns : BaseColumns {

        const val TABLE_NAME = "ShareData"
        const val COL_ID = "ID"
        const val COL_CONNECTION_TYPE = "ConnectionType"
        const val COL_NAME = "Name"
        const val COL_DIRECTORY = "Directory"
        const val COL_USERNAME = "Username"
        const val COL_PASSWORD = "Password"
        const val COL_PORT = "Port"
    }
    object SyncColumns : BaseColumns {

        const val TABLE_NAME = "SyncData"
        const val COL_ID = "ID"
        const val COL_CONNECTION_TYPE = "ConnectionType"
        const val COL_NAME = "Name"
        const val COL_IP = "IP"
        const val COL_USERNAME = "Username"
        const val COL_PASSWORD = "Password"
        const val COL_PORT = "Port"
    }
}