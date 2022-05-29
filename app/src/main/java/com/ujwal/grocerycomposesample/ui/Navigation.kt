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
    NavHost(navController = navController, startDestination = "splash", builder = {
        composable("splash"){
            SplashScreen(navController = navController)
        }
        composable("dashboard"){
            Dashboard()
        }
    })
}