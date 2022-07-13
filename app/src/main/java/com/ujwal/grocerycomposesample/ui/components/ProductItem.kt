package com.ujwal.grocerycomposesample.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.model.Product
import com.ujwal.grocerycomposesample.ui.theme.GrayBorder

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .width(174.dp)
            .height(248.dp)
            .padding(end = 15.dp)
            .border(1.dp, GrayBorder, RoundedCornerShape(20.dp))
            .padding(15.dp)
    ) {
        AsyncImage(
            model = product.image,
            contentDescription = stringResource(R.string.content_desc_product_image),
            modifier = Modifier.height(124.dp).fillMaxWidth(),
        )
        Text(
            text = product.title ?: "",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(product = Product(1, title = "title", description = "description"))
}