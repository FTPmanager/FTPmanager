package com.example.ftpmanager.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ftpmanager.data.LoadedData
import com.example.ftpmanager.domain.Connection
import com.example.ftpmanager.domain.FTP
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class FileBrowserMenuViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FileBrowserMenuUIState(selectedConnection = null))
    val uiState: StateFlow<FileBrowserMenuUIState> = _uiState.asStateFlow()

    //var ftp = LoadedData.connections[0]

    init {
        //select
    }

    fun selectDifferentConnection(con: Connection) {

    }

    fun downloadFile() {

    }

    fun downloadFiles() {

    }

    fun selectFile() {

    }

    fun clearSelectedFiles() {

    }

    fun text() {
        viewModelScope.launch {
            val ftp = FTP("HAHA FUNNY", "ftp.dlptest.com", "dlpuser", "rNrKYTX9g7z3RgJRmxWuGHbeu", 21)
            ftp.activate()
//            val result = ftp.listNames().firstOrNull()

//            if (result == true) {
//                _uiState.value.nameList = ftp.nameList
//            }
            Log.e("FTP", ftp.status().toString())
        }
    }
}