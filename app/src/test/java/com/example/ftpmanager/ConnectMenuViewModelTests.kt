package com.example.ftpmanager

import com.example.ftpmanager.data.DatabaseHandler
import com.example.ftpmanager.domain.ConnectionFactory
import com.example.ftpmanager.ui.ConnectMenuViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ConnectMenuViewModelTests {
    @Test
    fun connectionBeingAdded() {
        val db: DatabaseHandler = DatabaseHandler
        val connectMenuViewModel: ConnectMenuViewModel = ConnectMenuViewModel()

        val initialLength: Int = db.loadConnections().size
        connectMenuViewModel.createConnection()
        val postLength: Int = db.loadConnections().size
        assertEquals(initialLength + 1, postLength)
    }
}