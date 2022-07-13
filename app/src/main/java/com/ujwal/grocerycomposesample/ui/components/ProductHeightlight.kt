package com.ujwal.grocerycomposesample.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.model.CategoryProducts
import com.ujwal.grocerycomposesample.model.Product
import com.ujwal.grocerycomposesample.ui.theme.Black

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductHeightlight(productCategory: CategoryProducts) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = productCategory.title.replaceFirstChar { it.uppercase() },
            fontSize = 24.sp,
            color = Black,
            modifier = Modifier.padding(top = 30.dp, bottom = 20.dp),
            fontWeight = FontWeight.SemiBold
        )
        productCategory.products?.let {
            CompositionLocalProvider(
                LocalOverScrollConfiguration provides  null
            ) {
                LazyRow {
                    items(it.size) { index ->
                        ProductItem(product = it[index])
                    }
                }
            }

        } ?: kotlin.run {
            Text(text = stringResource(R.string.content_not_found))
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewHighlightItem() {
    ProductHeightlight(productCategory = CategoryProducts(
        title = "Fruit",
        products = arrayListOf<Product>().apply {
            repeat(10) {
                add(
                    Product(
                        1,
                        title = "Title",
                        description = "Description description description"
                    )
                )
            }
        }
    ))
}