package com.example.products.adapter

import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide


class ViewPagerAdapter(
    context: android.content.Context,
    mImageIdsa: ArrayList<String>
) : PagerAdapter() {
    private val mContext: android.content.Context
    private val mImageIds: ArrayList<String> = mImageIdsa

    init {
        mContext = context
    }

    override fun instantiateItem(container: ViewGroup, position: kotlin.Int): kotlin.Any {
        val imageView: android.widget.ImageView = android.widget.ImageView(mContext)
        Glide.with(mContext).load(mImageIds.get(position)).into(imageView)
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(
        container: ViewGroup,
        position: kotlin.Int,
        `object`: kotlin.Any
    ) {
        container.removeView(`object` as android.widget.ImageView?)
    }

    override fun getCount(): kotlin.Int {
        return mImageIds.size
    }

    override fun isViewFromObject(
        view: android.view.View,
        `object`: kotlin.Any
    ): kotlin.Boolean {
        return view === `object`
    }
}
