package com.ujwal.grocerycomposesample.ui.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun Shop(navController: NavHostController) {
    Box(modifier = Modifier
        .background(Color.Magenta)
        .fillMaxSize())
}