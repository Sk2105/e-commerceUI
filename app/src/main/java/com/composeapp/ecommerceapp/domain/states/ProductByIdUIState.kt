package com.composeapp.ecommerceapp.domain.states

import com.composeapp.ecommerceapp.data.models.ProductItem


sealed interface ProductByIdUIState {
    data object Loading : ProductByIdUIState
    data class Success(val product: ProductItem) : ProductByIdUIState
    data class Error(val message: String) : ProductByIdUIState
}