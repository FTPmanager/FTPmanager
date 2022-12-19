package com.example.ftpmanager.domain

interface Connection {
    public val name: String
    public var connectionStatus: ConnectionStatus
    public var ip: String
    public var username: String
    public var password: String
    public var port: Int

    public fun getType(): Connections { return Connections.UNDEFINED }
    public fun connect()
    public fun disconnect()
    public fun status(): ConnectionStatus
    override fun toString(): String
}