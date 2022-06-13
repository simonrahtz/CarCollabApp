package com.test.sharecar.navigation

import com.test.sharecar.R

sealed class BottomBarScreen(val route: String, val title: String, val icon: Int) {

    object Trip: BottomBarScreen("trip", "trip", R.drawable.ic_browse_nav)
    object Cars: BottomBarScreen("car", "car", R.drawable.ic_car_nav)
    object User: BottomBarScreen("user", "user", R.drawable.ic_user_nav)
}
