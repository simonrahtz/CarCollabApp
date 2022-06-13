package com.test.sharecar.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.ui.theme.ShareCarTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.test.sharecar.presentation.ConfirmTripDetails
import com.test.sharecar.presentation.MapScreen
import com.test.sharecar.presentation.UserProfile
import com.test.sharecar.presentation.activities.user.LoginScreen
import com.test.sharecar.presentation.bottomnavigation.CarScreen
import com.test.sharecar.presentation.bottomnavigation.TripScreen
import com.test.sharecar.presentation.bottomnavigation.UserScreen

class BrowserComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareCarTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        BottomNavigation(navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        BottomBarScreen.Trip,
        BottomBarScreen.Cars,
        BottomBarScreen.User,
    )

    BottomNavigation(
        backgroundColor = Color.LightGray,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route = route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Trip.route
    ) {
        composable(BottomBarScreen.Trip.route) {
            TripScreen(navController = navController)
        }
        composable(BottomBarScreen.Cars.route) {
            CarScreen()
        }
        composable(BottomBarScreen.User.route) {
            UserScreen(navController = navController)
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

@Preview
@Composable
fun Preview() {
    BottomNavigationBar(navController = rememberNavController())

}