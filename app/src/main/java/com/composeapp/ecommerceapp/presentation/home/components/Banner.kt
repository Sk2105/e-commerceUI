package com.composeapp.ecommerceapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
@Preview(showBackground = true)
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(16.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(24.dp)
            )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            AsyncImage(
                model = "https://th.bing.com/th/id/OIP.K--7GuaoEhLA_TNdO_s22AHaEK?rs=1&pid=ImgDetMain",
                contentDescription = "banner",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(24.dp)
                    ),
                contentScale = ContentScale.FillBounds
            )

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart
        )
        {

            Text(
                text = "Get upto \n50% \noff on \nselected \nitems",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.surface,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(16.dp)
            )


        }


    }
}