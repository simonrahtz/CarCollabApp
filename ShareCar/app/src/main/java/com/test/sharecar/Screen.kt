package com.test.sharecar

sealed class Screen (val route: String) {

    object Map: Screen(route = "map")
    object ConfirmTrip: Screen(route = "confirm_trip")
    object CreateTrip: Screen(route = "create_trip")
    object UserProfile: Screen(route = "user_profile")

}
