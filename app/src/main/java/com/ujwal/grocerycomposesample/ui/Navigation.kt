package com.ujwal.grocerycomposesample.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ujwal.grocerycomposesample.ui.screens.tabs.*

@Composable
fun InitNavigation(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = RouteHelper.Shop.route,
        builder = {
            composable(RouteHelper.Shop.route) {
                Shop(navController)
            }
            composable(RouteHelper.Explore.route) {
                Explore(navController)
            }
            composable(RouteHelper.Cart.route) {
                Cart(navController)
            }
            composable(RouteHelper.Favorite.route) {
                Favorite(navController)
            }
            composable(RouteHelper.Account.route) {
                Account(navController)
            }
        })
}

sealed class RouteHelper(val route: String) {
    object Shop : RouteHelper("shop")
    object Explore : RouteHelper("explore")
    object Cart : RouteHelper("cart")
    object Favorite : RouteHelper("favorite")
    object Account : RouteHelper("account")
}