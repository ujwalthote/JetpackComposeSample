package com.ujwal.grocerycomposesample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Dashboard() {
    val systemUiController  = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = Color.White)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    )
}

@Preview(showSystemUi = true)
@Composable
fun DashboardPreview() {
    Dashboard()
}