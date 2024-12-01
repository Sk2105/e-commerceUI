package com.composeapp.ecommerceapp.presentation.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.composeapp.ecommerceapp.domain.states.ProductByIdUIState
import com.composeapp.ecommerceapp.presentation.detail.components.BottomBar
import com.composeapp.ecommerceapp.presentation.detail.components.DetailTopBar
import com.composeapp.ecommerceapp.presentation.detail.components.ProductDetails
import com.composeapp.ecommerceapp.presentation.viewmodels.DetailViewModel
import com.composeapp.ecommerceapp.presentation.viewmodels.ProductUiState


@Composable
fun DetailScreen(id: Int, navigation: NavHostController) {

    val detailViewModel: DetailViewModel = hiltViewModel()
    LaunchedEffect(detailViewModel) {
        detailViewModel.fetchProductById(id)
    }

    val product = detailViewModel.product.collectAsState(
        initial = ProductUiState(ProductByIdUIState.Loading)
    )


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DetailTopBar() {
                navigation.popBackStack()
            }
        },
        bottomBar = {
            BottomBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {


            val state = product.value.productByIdUIState

            when (state) {
                is ProductByIdUIState.Error -> {
                    val error = state.message
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = error,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

                ProductByIdUIState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is ProductByIdUIState.Success -> {
                    val product = state.product
                    ProductDetails(productItem = product)
                }
            }
        }

    }

}