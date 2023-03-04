package com.example.products

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.products.adapter.ProductAdapter
import com.example.products.api.ProductService
import com.example.products.api.RetrofitHelper
import com.example.products.models.Product
import com.example.products.repository.ProductRepository
import com.example.products.viewmodels.ProductViewModel
import com.example.products.viewmodels.ProductViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductAdapter.OnItemClickListener, java.io.Serializable {

    private lateinit var productViewModel: ProductViewModel
    private var productAdapter: ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productService = RetrofitHelper.getInstance().create(ProductService::class.java)
        val productRepository = ProductRepository(productService)
        productViewModel = ViewModelProvider(
            this,
            ProductViewModelFactory(productRepository)
        )[ProductViewModel::class.java]

        productViewModel.products.observe(this) { users ->
            recProduct.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            productAdapter = ProductAdapter(this, users.products, this)
            recProduct.adapter = productAdapter
        }

//        textView10.setOnClickListener{
//            productViewModel.getUsers()
//
//        }
    }

    override fun onClickListener(data: Product, position: Int, from: String) {
        val intent = Intent(this, ProductDetail::class.java)
        intent.putExtra("prd", data)
        startActivity(intent)
    }

}