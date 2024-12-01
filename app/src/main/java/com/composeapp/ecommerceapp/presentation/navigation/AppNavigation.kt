package com.composeapp.ecommerceapp.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.composeapp.ecommerceapp.data.navigation.AppGraph
import com.composeapp.ecommerceapp.presentation.cart.CartScreen
import com.composeapp.ecommerceapp.presentation.detail.DetailScreen
import com.composeapp.ecommerceapp.presentation.home.HomeScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppGraph.Home
    ,
        popExitTransition = {
            slideOut(
                targetOffset = { fullSize -> IntOffset(fullSize.width, 0) },
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {
            slideIn(
                initialOffset = { IntOffset(0, 0) },
                animationSpec = tween(500)
            )
        },
        enterTransition = {
            slideIn(
                initialOffset = { IntOffset(it.width, 0) },
                animationSpec = tween(500)
            )
        },
        exitTransition = {
            slideOut(
                targetOffset = { IntOffset(0, 0) },
                animationSpec = tween(500)
            )
        }

    ){

        composable<AppGraph.Home> {
            HomeScreen(navController)
        }

        composable<AppGraph.Detail> {
            val id = it.toRoute<AppGraph.Detail>().id
            println("productId: $id")

            DetailScreen(id,navController)
        }

        composable<AppGraph.Cart> {
            CartScreen(navController)
        }



    }
}