package com.composeapp.ecommerceapp.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BottomBar() {


    Row(
        modifier = Modifier
            .padding()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // price
        Text(
            text = "$22.00",
            modifier = Modifier.weight(1f),
            maxLines = 1,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFF0055ff)
        )

        // add to cart
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0055ff))
        ) {
            Text(text = "Add to Cart",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp))
        }

    }


}