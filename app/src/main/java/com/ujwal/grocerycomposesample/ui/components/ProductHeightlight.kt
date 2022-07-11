package com.ujwal.grocerycomposesample.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import com.ujwal.grocerycomposesample.model.CategoryProducts
import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.model.Product

@Composable
fun ProductHeightlight(productCategory: CategoryProducts) {
    Column {
        Text(text = productCategory.title)
        productCategory.products?.let {
            LazyRow{
                items(it.size){index ->
                    ProductItem(product = it[index])
                }
            }
        }?: kotlin.run {
            Text(text = stringResource(R.string.content_not_found))
        }
    }
}



@Preview
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