package com.test.sharecar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.navigation.Screen
import com.test.sharecar.presentation.*
import com.test.sharecar.presentation.activities.user.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LogIn.route) {

        composable(Screen.UserProfile.route) {
            UserProfile(navController = navController)
        }
        composable(
            Screen.ConfirmTrip.route
        ) {
            ConfirmTripDetails(navController = navController)
        }
        composable(Screen.Map.route) {
            MapScreen()
        }
        composable(Screen.UserProfile.route) {
            UserProfile(navController = navController)
        }
        composable(Screen.LogIn.route) {
            LoginScreen()
        }

    }

}

