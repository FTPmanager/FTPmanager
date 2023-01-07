package com.example.ftpmanager.domain

interface Connection {

    public val name: String
    public var connectionStatus: ConnectionStatus
    public var ip: String
    public var username: String
    public var password: String
    public var port: Int

    public var currentPath: String
    public var nameList: List<FileData>

    public fun activate()
    public fun deactivate()
    public fun listNames(): Boolean
    public fun downloadFiles(localPath: String, fileNames: List<String>): Boolean
    public fun uploadFiles(localPath: String, fileNames: List<String>): Boolean

    public fun type(): Connections { return Connections.UNDEFINED }
    public fun status(): ConnectionStatus { return ConnectionStatus.DISCONNECT }
    override fun toString(): String
}