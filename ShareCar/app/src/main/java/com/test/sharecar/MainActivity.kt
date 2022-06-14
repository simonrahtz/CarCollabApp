package com.test.sharecar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.navigation.HomeScreen
import com.test.sharecar.navigation.Navigation

import com.test.sharecar.presentation.activities.LogInActivity
import com.test.sharecar.presentation.activities.user.LoginScreen
import com.test.sharecar.presentation.bottomnavigation.TripScreen
import com.test.sharecar.ui.theme.ShareCarTheme


class MainActivity : ComponentActivity() {
    private val userState by viewModels<UserStateViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CompositionLocalProvider(UserState provides userState) {
                    ApplicationSwitcher()
                }
            }
        }

    }
}

@Composable
fun ApplicationSwitcher() {
    val vm = UserState.current
    if (vm.isLoggedIn) {
        HomeScreen()
    } else {
        Navigation()
    }
}



