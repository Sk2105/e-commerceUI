package com.composeapp.ecommerceapp.di

import com.composeapp.ecommerceapp.data.remote.ECommerceApi
import com.composeapp.ecommerceapp.data.repo.ECommerceRepoImpl
import com.composeapp.ecommerceapp.domain.repo.ECommerceRepo
import com.composeapp.ecommerceapp.domain.usecases.FetchAllProductUseCase
import com.composeapp.ecommerceapp.domain.usecases.FetchProductByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ECommerceApi {
        return Retrofit.Builder()
            .baseUrl(ECommerceApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ECommerceApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepo(api: ECommerceApi): ECommerceRepo {
        return ECommerceRepoImpl(api)
    }

    @Provides
    fun fetchAllProductUseCase(repo: ECommerceRepo): FetchAllProductUseCase {
        return FetchAllProductUseCase(repo)
    }

    @Provides
    fun fetchProductByIdUseCase(repo: ECommerceRepo): FetchProductByIdUseCase {
        return FetchProductByIdUseCase(repo)
    }


}