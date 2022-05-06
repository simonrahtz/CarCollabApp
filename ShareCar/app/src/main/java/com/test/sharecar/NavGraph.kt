package com.test.sharecar

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.presentation.*

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CreateTrip.route) {
        composable(route = Screen.CreateTrip.route) {
            EnterTripDetails(navController = navController)
        }
        composable(
            route = Screen.ConfirmTrip.route
        ) {
            ConfirmTripDetails()
        }
    }

}

