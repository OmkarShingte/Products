package com.example.products.api

import com.example.products.models.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("/products")
    suspend fun getProductsService(): Response<ProductModel>
}