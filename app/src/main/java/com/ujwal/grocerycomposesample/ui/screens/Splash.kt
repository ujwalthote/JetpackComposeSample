package com.ujwal.grocerycomposesample.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.ui.theme.LightGreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController : NavController) {
    val systemUiController  = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = LightGreen)
    LaunchedEffect(key1 = false, block = {
        delay(1000)
        navController.navigate("dashboard"){
            popUpTo("splash"){
                inclusive = true
            }
        }
    })
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = LightGreen
    ) {
        Image(
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 80.dp),
            painter = painterResource(id = R.drawable.ic_splash_logo),
            contentDescription = "Logo"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
        SplashScreen(rememberNavController())
}