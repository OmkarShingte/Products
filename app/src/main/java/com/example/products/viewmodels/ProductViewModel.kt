package com.example.products.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products.models.ProductModel
import com.example.products.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(val productRepository: ProductRepository) : ViewModel() {

    init {
        viewModelScope.launch( Dispatchers.IO ) {
            productRepository.getProduct()
        }
    }

    fun getUsers() {
        viewModelScope.launch( Dispatchers.IO ) {
            productRepository.getProduct()
        }
    }

    val products:LiveData<ProductModel>
    get()=productRepository.products
}