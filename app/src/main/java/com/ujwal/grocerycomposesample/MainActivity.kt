package com.ujwal.grocerycomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ujwal.grocerycomposesample.ui.theme.LightGreen
import com.ujwal.grocerycomposesample.ui.theme.GroceryComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryComposeSampleTheme {
                SplashScreen()
            }
        }
    }
}

@Composable
fun SplashScreen() {
    val systemUiController  = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = LightGreen)
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
    GroceryComposeSampleTheme {
        SplashScreen()
    }
}