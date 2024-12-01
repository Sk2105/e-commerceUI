package com.composeapp.ecommerceapp.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.composeapp.ecommerceapp.data.models.ProductItem


@Composable
fun HorizontalImageView(productItem: ProductItem) {


    val images = productItem.images

    val pagerState = rememberPagerState(
        initialPage = 0, pageCount = { images.size }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {


        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
        ) { page ->
            PagerItem(images[page])

        }


        HorizontalIndicator(pagerState = pagerState, images = images)

    }


}


@Composable
fun HorizontalIndicator(pagerState: PagerState, images: List<String>) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()

            .padding(vertical = 16.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center

    ) {
        items(pagerState.pageCount) { index ->

            Box(
                modifier = Modifier
                    .border(
                        width = (index == pagerState.currentPage).let { if (it) 2.dp else 0.dp },
                        color = (index == pagerState.currentPage).let { if (it) Color.Black else Color.Transparent },
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(4.dp)
                    .size(50.dp)
            ) {
                PagerItem(

                    image = images[index]
                )
            }

        }

    }

}

@Composable
fun PagerItem(image: String) {

    AsyncImage(
        model = image,
        contentDescription = image,
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray),
        contentScale = ContentScale.FillBounds

    )

}