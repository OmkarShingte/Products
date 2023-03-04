package com.example.products.models

data class ProductModel(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)