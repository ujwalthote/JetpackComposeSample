package com.ujwal.grocerycomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ujwal.grocerycomposesample.ui.InitNavigation
import com.ujwal.grocerycomposesample.ui.theme.GroceryComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryComposeSampleTheme {
                InitNavigation()
            }
        }
    }
}
