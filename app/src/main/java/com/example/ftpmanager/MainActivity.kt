package com.example.ftpmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ftpmanager.data.DatabaseHandler
import com.example.ftpmanager.domain.FTP
import com.example.ftpmanager.ui.FTPmanagerApp
import com.example.ftpmanager.ui.components.complex_components.ConnectMenu
import com.example.ftpmanager.ui.theme.FTPmanagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val ftp = FTP("HAHA FUNNY", "ftp.dlptest.com", "dlpuser", "rNrKYTX9g7z3RgJRmxWuGHbeu", 21)
        setContent {
            FTPmanagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   FTPmanagerApp()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
