package com.example.ftpmanager.domain

import kotlinx.coroutines.flow.Flow

interface Connection {

    public var name: String
    public var connectionStatus: ConnectionStatus
    public var ip: String
    public var username: String
    public var password: String
    public var port: Int

    public var currentPath: String
    public var nameList: List<FileData>

    public fun activate(): Flow<Unit>
    public fun deactivate()
    public fun listNames(): Flow<Boolean>
    public fun downloadFiles(localPath: String, fileNames: List<String>): Flow<Boolean>
    public fun uploadFiles(localPath: String, fileNames: List<String>): Flow<Boolean>

    public fun type(): Connections { return Connections.UNDEFINED }
    public fun status(): ConnectionStatus { return ConnectionStatus.DISCONNECTED }
    override fun toString(): String
}