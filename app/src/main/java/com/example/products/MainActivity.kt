package com.example.products

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity(), ProductAdapter.OnItemClickListener, java.io.Serializable {

    lateinit var productViewModel: ProductViewModel

        private var productAdapter: ProductAdapter? = null
//    private val adapter = ProductAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productService = RetrofitHelper.getInstance().create(ProductService::class.java)
        val productRepository = ProductRepository(productService)
        productViewModel = ViewModelProvider(
            this,
            ProductViewModelFactory(productRepository)
        ).get(ProductViewModel::class.java)


//        productViewModel.products.observe(this) {
//            adapter.setUsers(products)
//            Log.d(">>>>>>>>", "???????  ${it.products.toString()}")
//        }
        productViewModel.products.observe(this) { users ->
            Log.d(">>>>>>>>", "???????  ${users.products.toString()}")
            recProduct.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            productAdapter = ProductAdapter(this, users.products, this)
            recProduct.adapter = productAdapter
        }
//        recProduct.adapter = adapter

        textView10.setOnClickListener{
            productViewModel.getUsers()

        }
    }

    override fun onClickListener(data: Product, position: Int, from: String) {

        Toast.makeText(this,"vvvv", Toast.LENGTH_LONG).show()
        val intent = Intent(this, ProductDetail::class.java)
        intent.putExtra("prd",data)
        startActivity(intent)
    }

}