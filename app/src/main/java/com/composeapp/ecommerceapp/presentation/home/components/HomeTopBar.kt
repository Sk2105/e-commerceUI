package com.composeapp.ecommerceapp.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeTopBar(scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "Discover",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                maxLines = 1,
                minLines = 1,
                softWrap = true
            )
        },

        actions = {

            BadgedBox(modifier = Modifier
                .padding(end = 8.dp)
                .size(50.dp), badge = {
                Badge(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .align(Alignment.TopEnd),
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Text(text = "2", color = Color.White)
                }
            }
            ) {
                ElevatedCard(
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(50.dp)
                    ),

                    onClick = {},
                    shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),

                    ) {


                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = "Search",
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }


        }
    )
}