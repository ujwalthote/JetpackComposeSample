package com.ujwal.grocerycomposesample.ui.screens.tabs.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.ui.components.HorizontalBanner
import com.ujwal.grocerycomposesample.ui.components.SearchBox
import com.ujwal.grocerycomposesample.ui.theme.Gray

@Composable
fun Shop(navController: NavHostController, shopViewModel: ShopViewModel = viewModel()) {
    val location by shopViewModel.location.observeAsState()
    val searchTerm by shopViewModel.searchTerm.observeAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        //top icon
        Spacer(modifier = Modifier.height(12.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_carrot),
            contentDescription = "Carrot icon in the top",
            modifier = Modifier
                .size(26.dp, 30.dp)
                .align(alignment = Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(4.dp))

        //location
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 20.dp),
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

        //search box
        SearchBox(
            onTextChanged = {
                shopViewModel.onSearchTermChanged(it)
            },
            searchText = searchTerm ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 20.dp)
        )

        //banner
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalBanner()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShopPreview() {
    Shop(navController = rememberNavController())
}