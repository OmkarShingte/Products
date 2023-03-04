package com.example.products.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.products.api.ProductService
import com.example.products.models.ProductModel

class ProductRepository(private val productService: ProductService) {

//    private var productData = MutableLiveData<List<ProductModel>>()
    private var productData = MutableLiveData<ProductModel>()
    val products: LiveData<ProductModel>
        get() = productData

    suspend fun getProduct() {
        val result = productService.getProductsService()
        if (result?.body() != null)
            productData.postValue(result.body())
//        productData.postValue(result.body())
    }
}