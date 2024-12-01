package com.composeapp.ecommerceapp.domain.usecases

import com.composeapp.ecommerceapp.data.models.ProductItem
import com.composeapp.ecommerceapp.domain.repo.ECommerceRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchAllProductUseCase @Inject constructor(private val repo: ECommerceRepo) {
    suspend operator fun invoke(): Flow<List<ProductItem>> = flow { emit(repo.getProducts())}
}