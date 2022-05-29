package com.ujwal.grocerycomposesample.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ujwal.grocerycomposesample.ui.InitNavigation
import com.ujwal.grocerycomposesample.ui.components.GroceryBottomNavigation

@Composable
fun Dashboard() {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = Color.White)
    Scaffold(bottomBar = {
        GroceryBottomNavigation(navController = navController)
    }) {
        InitNavigation(navController = navController)
    }
}

@Preview(showSystemUi = true)
@Composable
fun DashboardPreview() {
    Dashboard()
}