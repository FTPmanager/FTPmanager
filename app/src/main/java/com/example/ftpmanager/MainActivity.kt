package com.example.ftpmanager

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ftpmanager.data.DatabaseHandler
import com.example.ftpmanager.data.LoadedData
import com.example.ftpmanager.domain.FTP
import com.example.ftpmanager.ui.theme.FTPmanagerTheme
import org.apache.commons.net.ftp.FTPClient
import org.apache.commons.net.ftp.FTPClientConfig
import java.net.InetAddress


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FTPmanagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var db = DatabaseHandler(this)

        val ftp = FTP("HAHA FUNNY", "ftp.dlptest.com", "dlpuser", "rNrKYTX9g7z3RgJRmxWuGHbeu")

        var ftpClient = FTPClient()
        var ftpConfig = FTPClientConfig()
        ftpClient.setUn

        //db.insertConnection(ftp)

        ftpClient.connect(ftp.ip)
        ftpClient.enterLocalActiveMode()
        ftpClient.enterRemoteActiveMode(InetAddress.getByName(ftp.ip), ftp.port)
        ftpClient.login(ftp.username, ftp.password)

        var list = ftpClient.listNames()

        ftpClient.disconnect()

        db.loadConnections()
        for (element in list) {
            Log.e("MAIN", element)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FTPmanagerTheme {
        Greeting("Android")
    }
}