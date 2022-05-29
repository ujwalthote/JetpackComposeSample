package com.ujwal.grocerycomposesample.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ujwal.grocerycomposesample.ui.screens.Dashboard
import com.ujwal.grocerycomposesample.ui.screens.SplashScreen

@Composable
fun InitNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenNavHelper.Splash.route, builder = {
        composable(ScreenNavHelper.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(ScreenNavHelper.Dashboard.route) {
            Dashboard()
        }
    })
}

sealed class ScreenNavHelper(val route: String) {
    object Splash : ScreenNavHelper("splash")
    object Dashboard : ScreenNavHelper("dashboard")
}