package com.composeapp.ecommerceapp.domain.states

import com.composeapp.ecommerceapp.data.models.ProductItem

sealed interface ProductsUIState {
    data object Loading : ProductsUIState
    data class Success(val products: List<ProductItem>) : ProductsUIState
    data class Error(val message: String) : ProductsUIState
}