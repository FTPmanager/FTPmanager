package com.example.ftpmanager.ui

import androidx.lifecycle.ViewModel
import com.example.ftpmanager.domain.Connection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FileBrowserMenuViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FileBrowserMenuUIState(selectedConnection = null))
    val uiState: StateFlow<FileBrowserMenuUIState> = _uiState.asStateFlow()

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

}