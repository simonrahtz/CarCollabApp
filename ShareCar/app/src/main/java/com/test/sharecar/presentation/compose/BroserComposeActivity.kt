package com.test.sharecar.presentation.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.presentation.activities.ui.theme.ShareCarTheme
import com.test.sharecar.presentation.compose.BottomBarScreen
import com.test.sharecar.presentation.fragments.BrowserScreen
import com.test.sharecar.presentation.fragments.CarsScreen
import com.test.sharecar.presentation.fragments.UserScreen


class BroserComposeActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareCarTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        BottomBarScreen.Browser,
        BottomBarScreen.Cars,
        BottomBarScreen.User,
    )
    
    BottomNavigation(
        backgroundColor = Color.Cyan,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = item.icon), contentDescription = item.title)},
                label = { Text(text = item.title)},
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
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Browser.route
    ) {
        composable(BottomBarScreen.Browser.route) {
            BrowserScreen()
        }
        composable(BottomBarScreen.Cars.route) {
            CarsScreen()
        }
        composable(BottomBarScreen.User.route) {
            UserScreen()
        }
    }
}

