package com.example.a3e_commerce

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3e_commerce.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter (private val products:List<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val product = products[position]
        Picasso.get().load(product.photoUrl).into(holder.image)
        holder.title.text = product.title
        holder.price.text = product.price.toString()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row,parent,false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context,ProductDetails::class.java)
            intent.putExtra("title",products[holder.adapterPosition].title)
            parent.context.startActivity(intent)
        }
        return holder

    }

    override fun getItemCount()=products.size

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.photo)
        val title:TextView = itemView.findViewById(R.id.title)
        val price:TextView = itemView.findViewById(R.id.price)

    }

}