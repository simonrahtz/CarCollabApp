package com.test.sharecar.navigation

sealed class Screen (val route: String) {

    object Map: Screen(route = "map")
    object ConfirmTrip: Screen(route = "confirm_trip")
    object CreateTrip: Screen(route = "create_trip")
    object UserProfile: Screen("user_profile")
    object LogIn: Screen("log_in")


}
