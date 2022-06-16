package com.ujwal.grocerycomposesample.api

import com.ujwal.grocerycomposesample.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ShopAPI {

    @GET("/products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("/products/category/{category}")
    suspend fun getProductsByCategory(@Path("category") category: String): Response<List<Product>>

}