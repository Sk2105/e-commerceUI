package com.composeapp.ecommerceapp.data.repo

import com.composeapp.ecommerceapp.data.models.ProductItem
import com.composeapp.ecommerceapp.data.remote.ECommerceApi
import com.composeapp.ecommerceapp.domain.repo.ECommerceRepo
import javax.inject.Inject


class ECommerceRepoImpl @Inject constructor(private val api: ECommerceApi): ECommerceRepo {
    override suspend fun getProducts(): List<ProductItem> {
        val response = api.getProducts()
        if (!response.isSuccessful) {
            throw Exception("Failed to fetch products")
        }
        return response.body()!!
    }

    override suspend fun getProduct(id: Int): ProductItem {
        val response = api.getProduct(id)
        if (!response.isSuccessful) {
            throw Exception("Failed to fetch product ${response.message()}")
        }
        return response.body()!!
    }
}