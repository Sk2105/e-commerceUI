package com.composeapp.ecommerceapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composeapp.ecommerceapp.domain.states.ProductByIdUIState
import com.composeapp.ecommerceapp.domain.usecases.FetchProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val fetchProductByIdUseCase: FetchProductByIdUseCase
) : ViewModel() {
    private val _product =
        MutableStateFlow(ProductUiState(ProductByIdUIState.Loading))

    val product = _product.asSharedFlow()

    suspend fun fetchProductById(id: Int) {
        println("fetchProductById: $id")
        fetchProductByIdUseCase(id).onStart {
            println("fetchProductById: onStart")
            _product.value = ProductUiState(ProductByIdUIState.Loading)
        }.catch {
            println("fetchProductById: ${it.message}")
            _product.value = ProductUiState(ProductByIdUIState.Error(it.message ?: ""))
        }.collect {
            println("fetchProductById: collect")
            _product.value = ProductUiState(ProductByIdUIState.Success(it))
        }
    }


}

data class ProductUiState(
    val productByIdUIState: ProductByIdUIState
)