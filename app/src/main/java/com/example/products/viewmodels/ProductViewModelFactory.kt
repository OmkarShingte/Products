package com.example.products.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products.repository.ProductRepository

class ProductViewModelFactory(val productRepository: ProductRepository) : ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productRepository) as T  //super.create(modelClass)
    }
}