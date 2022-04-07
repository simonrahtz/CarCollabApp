package com.test.sharecar

sealed class Screen (val route: String) {

    object FuelPrice: Screen (route = "fuel_price")
    object Map: Screen(route = "map")
    object EnterDestination: Screen( route = "enter_destination")

}
