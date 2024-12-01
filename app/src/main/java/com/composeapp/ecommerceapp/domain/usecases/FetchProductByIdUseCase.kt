package com.composeapp.ecommerceapp.domain.usecases

import com.composeapp.ecommerceapp.data.models.ProductItem
import com.composeapp.ecommerceapp.domain.repo.ECommerceRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchProductByIdUseCase @Inject constructor(private val repository: ECommerceRepo){
    suspend operator fun invoke(id: Int): Flow<ProductItem> = flow {
        emit(repository.getProduct(id))
    }
}