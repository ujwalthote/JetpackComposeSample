package com.ujwal.grocerycomposesample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ujwal.grocerycomposesample.ui.theme.LightGray
import com.ujwal.grocerycomposesample.ui.theme.LightGreen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalBanner() {
    val state = rememberPagerState()
    Box(modifier = Modifier
        .padding(horizontal = 20.dp)
        .fillMaxWidth()
        .graphicsLayer {
            clip = true
            shape = RoundedCornerShape(12.dp)
        }
        .height(114.dp)) {
        HorizontalPager(
            count = 3, state = state
        ) {
            Box(
                modifier = Modifier
                    .background(
                        when (currentPage) {
                            1 -> Color.Gray
                            2 -> Color.LightGray
                            else -> Color.DarkGray
                        }
                    )
                    .fillMaxSize()
            )
        }
        DotsIndicator(
            totalDots = 3,
            selectedIndex = state.currentPage,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
        )
    }
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int
) {

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(), horizontalArrangement = Arrangement.Center
    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(color = LightGreen)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(color = LightGray)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Preview
@Composable
fun HorizontalBannerPreview() {
    HorizontalBanner()
}