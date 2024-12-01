package com.composeapp.ecommerceapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composeapp.ecommerceapp.data.models.ProductItem
import com.composeapp.ecommerceapp.domain.states.ProductByIdUIState
import com.composeapp.ecommerceapp.domain.states.ProductsUIState
import com.composeapp.ecommerceapp.domain.usecases.FetchAllProductUseCase
import com.composeapp.ecommerceapp.domain.usecases.FetchProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchProductByIdUseCase: FetchProductByIdUseCase,
    private val fetchProductsUseCase: FetchAllProductUseCase
) :ViewModel()
{
    private val _product = MutableStateFlow(HomeUiState(ProductsUIState.Loading))

    val product = _product.onStart {
         fetchProductsUseCase().catch { error->
             _product.update {
                 HomeUiState(ProductsUIState.Error(error.message ?: "Something went wrong"))
             }
         }.collect{ products ->
             _product.update {
                 HomeUiState(ProductsUIState.Success(products))
             }
         }

    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState(ProductsUIState.Loading)

    )

}


data class HomeUiState(val productsUIState: ProductsUIState)