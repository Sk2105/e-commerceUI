package com.composeapp.ecommerceapp.domain.repo

import com.composeapp.ecommerceapp.data.models.ProductItem

interface ECommerceRepo {
    suspend fun getProducts(): List<ProductItem>
    suspend fun getProduct(id: Int): ProductItem
}