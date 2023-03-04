package com.example.products

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.products.adapter.ViewPagerAdapter
import com.example.products.models.Product
import kotlinx.android.synthetic.main.activity_product_detail.*


class ProductDetail : AppCompatActivity() {

    private var mViewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val user = intent.getSerializableExtra("prd") as Product


        textView9.text = user.description
        textView8.text = user.category
        textView7.text = user.rating.toString()
        textView6.text = "₹ "+user.price.toString()
        textView5.text = user.title


        mViewPagerAdapter = ViewPagerAdapter(this, user.images as ArrayList<String>);
        viewPager.adapter = mViewPagerAdapter
    }
}