package com.composeapp.ecommerceapp.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.composeapp.ecommerceapp.data.navigation.AppGraph
import com.composeapp.ecommerceapp.domain.states.ProductsUIState
import com.composeapp.ecommerceapp.presentation.home.components.Banner
import com.composeapp.ecommerceapp.presentation.home.components.CategorySection
import com.composeapp.ecommerceapp.presentation.home.components.HomeSearchBox
import com.composeapp.ecommerceapp.presentation.home.components.HomeTopBar
import com.composeapp.ecommerceapp.presentation.home.components.ProductList
import com.composeapp.ecommerceapp.presentation.viewmodels.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController) {

    val mainViewModel: MainViewModel = hiltViewModel()

    val productState = mainViewModel.product.collectAsState()

    val topAppBarState = rememberTopAppBarState()

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(
                scrollBehavior.nestedScrollConnection
            ),
        topBar = {
            HomeTopBar(scrollBehavior = scrollBehavior)
        },
    ) { it ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it)
        ) {

            HomeSearchBox()

            Banner()

            CategorySection()

            when (productState.value.productsUIState) {

                is ProductsUIState.Success -> {
                    val productList =
                        (productState.value.productsUIState as ProductsUIState.Success).products
                    ProductList(productList) { product ->
                        navHostController.navigate(AppGraph.Detail(product.id))

                    }
                }

                is ProductsUIState.Error -> {

                    Text(text = productState.value.productsUIState.toString())
                }

                is ProductsUIState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                    }

                }

            }

        }

    }


}