package com.ujwal.grocerycomposesample.repository

import com.ujwal.grocerycomposesample.api.ShopAPI
import com.ujwal.grocerycomposesample.model.Product
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopRepository @Inject constructor(private val shopAPI: ShopAPI) {

    suspend fun getCategories(): Response<List<String>> = shopAPI.getCategories()

    suspend fun getProductsByCategory(category: String): Response<List<Product>> =
        shopAPI.getProductsByCategory(category)

}