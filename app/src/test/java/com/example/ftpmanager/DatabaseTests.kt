package com.example.ftpmanager

import android.provider.ContactsContract.Data
import com.example.ftpmanager.data.DatabaseHandler
import com.example.ftpmanager.domain.FTP
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class DatabaseTests {
    @Test
    fun connectionAdded() {

        val ftp = FTP( "TestRandomName" + Random(Long.MAX_VALUE).toString(), "ftp.dlptest.com", username = "dlpuser", password = "rNrKYTX9g7z3RgJRmxWuGHbeu", port = 21)

        val oldLength: Int = DatabaseHandler.loadConnections().size
        DatabaseHandler.insertConnection(ftp)
        val newLength: Int = DatabaseHandler.loadConnections().size

        assertEquals(oldLength + 1, newLength)
    }
    @Test
    fun connectionRemoved() {

        val ftp = FTP( "TestRandomName" + Random(Long.MAX_VALUE).toString(), "ftp.dlptest.com", username = "dlpuser", password = "rNrKYTX9g7z3RgJRmxWuGHbeu", port = 21)
        var inserted = false

        var oldLength: Int = DatabaseHandler.loadConnections().size
        DatabaseHandler.insertConnection(ftp)
        var newLength: Int = DatabaseHandler.loadConnections().size

        assertEquals(oldLength + 1, newLength)

        oldLength = newLength
        DatabaseHandler.deleteConnection(ftp)
        newLength = DatabaseHandler.loadConnections().size

        assertEquals(oldLength - 1, newLength)
    }
    @Test
    fun connectionUpdated() {

        val ftp = FTP( "TestRandomName" + Random(Long.MAX_VALUE).toString(), "ftp.dlptest.com", username = "dlpuser", password = "rNrKYTX9g7z3RgJRmxWuGHbeu", port = 21)
        val ftpNewer = FTP( ftp.name, "ftp.dlptest2.com", username = "dlpuser2", password = "rNrKYTX9g7z3RgJRmxWuGHbeu2", port = 22)
        var inserted = false

        var result = false
        DatabaseHandler.insertConnection(ftp)
        var list = DatabaseHandler.loadConnections()
        for (element in list) {
            if (element.equals(ftp))
                result = true
        }
        assertTrue(result)

        result = false
        DatabaseHandler.editConnection(ftp, ftpNewer)
        list = DatabaseHandler.loadConnections()
        for (element in list) {
            if (element.equals(ftpNewer))
                result = true
        }
        assertTrue(result)
    }
}