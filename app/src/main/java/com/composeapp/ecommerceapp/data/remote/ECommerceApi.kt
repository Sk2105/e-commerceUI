package com.composeapp.ecommerceapp.data.remote

import com.composeapp.ecommerceapp.data.models.ProductItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ECommerceApi {

    @GET("products")
    suspend fun getProducts(): Response<List<ProductItem>>

    companion object {
        const val BASE_URL = "https://api.escuelajs.co/api/v1/"
    }

    @GET("products/{id}")
    suspend fun getProduct(
        @Path("id") id: Int
    ): Response<ProductItem>

}