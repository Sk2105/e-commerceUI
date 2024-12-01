
package com.composeapp.ecommerceapp.presentation.cart

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.composeapp.ecommerceapp.data.navigation.AppGraph


@Composable
fun CartScreen(navigation: NavHostController)
{
    Button(onClick = {
        navigation.popBackStack()
    }) {
        Text(
            text = "Cart Screen",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}