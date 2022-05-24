package com.test.sharecar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.navigation.compose.rememberNavController

import com.test.sharecar.presentation.activities.LogInActivity
import com.test.sharecar.presentation.activities.user.LoginScreen
import com.test.sharecar.ui.theme.ShareCarTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            MaterialTheme {
                LoginScreen()
            }
        }
    }

}


