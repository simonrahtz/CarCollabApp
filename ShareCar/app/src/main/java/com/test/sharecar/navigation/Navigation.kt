package com.test.sharecar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.navigation.Screen
import com.test.sharecar.presentation.*

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CreateTrip.route) {

        composable(
            route = Screen.ConfirmTrip.route
        ) {
            ConfirmTripDetails(navController = navController)
        }
        composable(route = Screen.Map.route){
            MapScreen()
        }

    }

}

