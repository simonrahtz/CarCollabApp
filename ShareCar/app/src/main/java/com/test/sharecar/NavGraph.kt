package com.test.sharecar

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.presentation.ConfirmTripDetails
import com.test.sharecar.presentation.EnterDestination
import com.test.sharecar.presentation.FuelPriceScreen
import com.test.sharecar.presentation.MapScreen


@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.EnterDestination.route
    ){
        composable(
            route = Screen.FuelPrice.route
        ) {
            FuelPriceScreen()
        }
        composable(
            route = Screen.Map.route
        ) {
            MapScreen()
        }
        composable(
            route = Screen.EnterDestination.route
        ) {
            EnterDestination(navController = navController)
        }
        composable(
            route = Screen.ConfirmTrip.route
        ) {
            ConfirmTripDetails()
        }

    }



}