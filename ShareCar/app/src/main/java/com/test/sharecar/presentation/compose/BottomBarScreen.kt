package com.test.sharecar.presentation.compose

import com.test.sharecar.R

sealed class BottomBarScreen(val route: String, val title: String, val icon: Int) {

    object Browser: BottomBarScreen("browser", "browse", R.drawable.ic_browse_nav)
    object Cars: BottomBarScreen("cars", "cars", R.drawable.ic_car_nav)
    object User: BottomBarScreen("user", "user", R.drawable.ic_user_nav)
}
