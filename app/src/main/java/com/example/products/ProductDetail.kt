package com.example.products

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.products.adapter.ImagePagerAdapter
import com.example.products.models.Product
import kotlinx.android.synthetic.main.activity_product_detail.*


class ProductDetail : AppCompatActivity(), View.OnClickListener {

    private var mViewPagerAdapter: ImagePagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        button.setOnClickListener(this)

        val user = intent.getSerializableExtra("prd") as Product

        txtDescription.text = user.description
        txtCategory.text = user.category
        txtRating.text = user.rating.toString()
        txtPrice.text = "₹ "+user.price.toString()
        txtTitle.text = user.title

        mViewPagerAdapter = ImagePagerAdapter(this, user.images as ArrayList<String>);
        viewPager.adapter = mViewPagerAdapter
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.button->onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}