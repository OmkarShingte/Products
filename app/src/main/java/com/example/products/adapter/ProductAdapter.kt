package com.example.products.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.products.R
import com.example.products.models.Product
import kotlinx.android.synthetic.main.row_product.view.*


//class ProductAdapter : RecyclerView.Adapter<MyViewHolder>() {
//    private var userList = emptyList<Product>()
//
//    fun setUsers(users: List<Product>) {
//        userList = users
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)
//        return MyViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return userList.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.bind(userList[position])
//    }
//}
//
//class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    fun bind(user: Product) {
//        itemView.textView.text = user.title
//
//        // set other user data to UI elements
//    }
//}
//


class ProductAdapter(
    private val mContext: Context,
    private var groupList: List<Product>,
    private var listener: OnItemClickListener,
) : RecyclerView.Adapter<ProductAdapter.MViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MViewHolder {
        val view: View =
            LayoutInflater.from(mContext).inflate(R.layout.row_product, parent, false)
        return MViewHolder(view)
    }

    override fun onBindViewHolder(mViewHolder: MViewHolder, position: Int) {
        val product = groupList[mViewHolder.adapterPosition]
        val item = mViewHolder.itemView

        item.textView.text = product.title
        item.textView2.text = "₹ "+product.price.toString()
        item.textView3.text = product.brand
        item.textView4.text = product.category
        Glide.with(mContext).load(product.thumbnail).into(item.imageView)
        item.conProduct.setOnClickListener {
            listener.onClickListener(product, position, "detail")
        }

    }

    interface OnItemClickListener {
        fun onClickListener(data: Product, position: Int, from: String)
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

    class MViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}