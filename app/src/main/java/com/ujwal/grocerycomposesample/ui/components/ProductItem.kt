package com.ujwal.grocerycomposesample.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.model.Product

@Composable
fun ProductItem(product: Product) {
    ConstraintLayout(
        modifier = Modifier
            .width(174.dp)
            .height(248.dp)
            .padding(15.dp)
    ) {
        val (image, title, quantity, price, addButton) = createRefs()
        AsyncImage(
            model = product.image,
            contentDescription = stringResource(R.string.content_desc_product_image),
            modifier = Modifier.constrainAs(image){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = product.title ?: "",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .constrainAs(price) {
                    top.linkTo(image.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(quantity.top)
                },
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(product = Product(1, title = "title", description = "description"))
}