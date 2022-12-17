package com.example.ftpmanager.domain

interface Connection {

    public val name: String
    public var connectionStatus: ConnectionStatus
    public var ip: String
    public var username: String
    public var password: String
    public var port: Int

    public fun type(): Int {
        when(this) {
            is FTP -> return 1
            is SFTP -> return 2
            else -> return 0
        }
    }
    public fun connect()
    public fun disconnect()
    public fun status(): ConnectionStatus

}