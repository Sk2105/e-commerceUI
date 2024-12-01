package com.composeapp.ecommerceapp.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.composeapp.ecommerceapp.R
import com.composeapp.ecommerceapp.data.models.ProductItem


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductList(
    productList: List<ProductItem>,
    onClick: (ProductItem) -> Unit
) {

    FlowRow(maxItemsInEachRow = 2, modifier = Modifier.fillMaxSize()) {
        productList.forEach { productItem ->
            ProductItemView(productItem){
                onClick(it)
            }
        }
    }


}

@Composable
fun ProductItemView(productItem: ProductItem,onClick:(ProductItem)->Unit={}) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(
        modifier = Modifier
            .width(screenWidth / 2)
            .padding(8.dp).clickable {
                onClick(productItem)
            }
    ) {

        Card(
            modifier = Modifier.padding(vertical = 4.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Gray)
        ) {
            AsyncImage(
                model = productItem.images[0], contentDescription = productItem.title, modifier = Modifier,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            )

        }

        Text(
            text = "$" + productItem.price.toString(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 2.dp),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = productItem.title,
            modifier = Modifier.padding(vertical = 2.dp),
            fontSize = 16.sp,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(0.8f)
        )


    }

}