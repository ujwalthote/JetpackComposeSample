package com.ujwal.grocerycomposesample.ui.screens.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.ui.screens.tabs.shop.ShopViewModel
import com.ujwal.grocerycomposesample.ui.theme.Gray

@Composable
fun Shop(navController: NavHostController, shopViewModel: ShopViewModel = viewModel()) {
    val location by shopViewModel.location.observeAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(12.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_carrot),
            contentDescription = "Carrot icon in the top",
            modifier = Modifier
                .size(26.dp, 30.dp)
                .align(alignment = Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "Location icon",
                modifier = Modifier
                    .padding(end = 6.dp)
                    .size(15.dp, 17.dp)
            )
            Text(
                text = location ?: stringResource(id = R.string.label_select_location),
                color = Gray,
                fontSize = 18.sp
            )
        }
        Spacer(modifier = Modifier.height(12.dp))

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShopPreview() {
    Shop(navController = rememberNavController())
}
