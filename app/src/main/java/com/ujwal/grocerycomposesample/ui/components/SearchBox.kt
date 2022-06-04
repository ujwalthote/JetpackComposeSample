package com.ujwal.grocerycomposesample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ujwal.grocerycomposesample.R
import com.ujwal.grocerycomposesample.ui.theme.LightGray
import com.ujwal.grocerycomposesample.ui.theme.TextGray

@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    searchText: String = "",
    onTextChanged: (String) -> Unit
) {
    TextField(
        modifier = modifier.graphicsLayer {
            clip = true
            shape = RoundedCornerShape(12.dp)
        },
        value = searchText,
        onValueChange = onTextChanged,
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 14.sp,
            color = TextGray
        ),
        leadingIcon = {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search icon"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = LightGray,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Preview
@Composable
private fun SearchBoxPreview() {
    SearchBox(
        modifier = Modifier,
        searchText = "Demo text",
        onTextChanged = {

        }
    )
}