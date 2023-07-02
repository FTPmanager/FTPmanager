package com.example.ftpmanager

import com.example.ftpmanager.domain.ConnectionFactory
import com.example.ftpmanager.domain.FTP
import junit.framework.Assert.assertEquals
import org.junit.Test

class ConnectionFactoryTests {
    @Test
    fun connectionCreatedWithoutPort() {
        val ftp1 = FTP("HAHA FUNNY", "ftp.dlptest.com", username = "dlpuser", password = "rNrKYTX9g7z3RgJRmxWuGHbeu")
        val ftp2 = ConnectionFactory.getConnection("HAHA FUNNY", "ftp.dlptest.com", username = "dlpuser", password = "rNrKYTX9g7z3RgJRmxWuGHbeu")
        assertEquals(ftp1, ftp2)
    }
    @Test
    fun connectionCreatedForAnonymousWithPort() {
        val ftp1 = FTP("HAHA FUNNY", "ftp.dlptest.com", port = 21)
        val ftp2 = ConnectionFactory.getConnection("HAHA FUNNY", "ftp.dlptest.com", port = 21)
        assertEquals(ftp1, ftp2)
    }
    @Test
    fun connectionCreatedForAnonymousWithoutPort() {
        val ftp1 = FTP("HAHA FUNNY", "ftp.dlptest.com")
        val ftp2 = ConnectionFactory.getConnection("HAHA FUNNY", "ftp.dlptest.com")
        assertEquals(ftp1, ftp2)
    }
}