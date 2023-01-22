package com.example.ftpmanager

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ftpmanager.ui.FTPmanagerApp

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ConnectMenuNavigationTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupFTPmanagerNavHost() {
        composeTestRule.setContent {
            navController =
                TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(
                ComposeNavigator()
            )
            FTPmanagerApp()
        }
    }


    @Test
    fun addConnection() {
        val plusFloatingButtonDescription = composeTestRule.activity.getString(R.string.add_connection)
        val presetNameTextFieldLabel = composeTestRule.activity.getString(R.string.con_name_text_field)
        val testConnectionName = "Test connection"
        val addButtonText = composeTestRule.activity.getString(R.string.add)
        composeTestRule.onNodeWithContentDescription(plusFloatingButtonDescription).performClick()
        composeTestRule.onNodeWithText(presetNameTextFieldLabel).performTextInput(testConnectionName)
        composeTestRule.onNodeWithText(addButtonText).performClick()
        composeTestRule.onNodeWithText(testConnectionName).assertExists()

    }
}