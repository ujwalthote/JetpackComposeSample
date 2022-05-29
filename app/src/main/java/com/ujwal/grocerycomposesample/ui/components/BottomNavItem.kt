package com.ujwal.grocerycomposesample.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.ui.RouteHelper

sealed class BottomNavItem(
    @StringRes var title: Int,
    @DrawableRes var icon: Int,
    var screen_route: String
) {
    object Shop : BottomNavItem(
        title = R.string.tab_title_shop,
        icon = R.drawable.ic_shop,
        screen_route = RouteHelper.Shop.route
    )

    object Explore : BottomNavItem(
        title = R.string.tab_title_explore,
        icon = R.drawable.ic_explore,
        screen_route = RouteHelper.Explore.route
    )

    object Cart : BottomNavItem(
        title = R.string.tab_title_cart,
        icon = R.drawable.ic_cart,
        screen_route = RouteHelper.Cart.route
    )

    object Favorite : BottomNavItem(
        title = R.string.tab_title_favorite,
        icon = R.drawable.ic_fav,
        screen_route = RouteHelper.Favorite.route
    )

    object Account : BottomNavItem(
        title = R.string.tab_title_account,
        icon = R.drawable.ic_account,
        screen_route = RouteHelper.Account.route
    )
}