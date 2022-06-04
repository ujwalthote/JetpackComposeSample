package com.ujwal.grocerycomposesample.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ujwal.grocerycomposesample.ui.theme.Black
import com.ujwal.grocerycomposesample.ui.theme.LightGreen

@Composable
fun GroceryBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Shop,
        BottomNavItem.Explore,
        BottomNavItem.Cart,
        BottomNavItem.Favorite,
        BottomNavItem.Account
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Black,
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(topStartPercent = 30, topEndPercent = 30)
                shadowElevation = 20.dp.toPx()
            },
        elevation = 12.dp,

        ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(alignment = Alignment.CenterVertically)
                    .offset(y = (-7).dp)
                    .weight(1f),
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(
                            id = item.title
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.title),
                        fontSize = 12.sp
                    )
                },
                selectedContentColor = LightGreen,
                unselectedContentColor = Black,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
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

@Preview
@Composable
fun PreviewBottomNav() {
    GroceryBottomNavigation(navController = rememberNavController())
}