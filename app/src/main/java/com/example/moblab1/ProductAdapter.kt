package com.example.moblab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        private val quantityTextView: TextView = itemView.findViewById(R.id.product_quantity)
        private val priceTextView: TextView = itemView.findViewById(R.id.product_price)
        private val manufacturerTextView: TextView = itemView.findViewById(R.id.product_manufacturer)
        private val releaseDateTextView: TextView = itemView.findViewById(R.id.product_releasedate)

        fun bind(product: Product) {
            nameTextView.text = product.name
            quantityTextView.text = "Количество: ${product.quantity}"
            priceTextView.text = "Цена: ${product.price}"
            manufacturerTextView.text = "Производитель: ${product.manufacturer}"
            releaseDateTextView.text = "Дата выпуска: ${product.releaseDate}"
        }
    }
}