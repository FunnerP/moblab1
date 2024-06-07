package com.example.moblab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter
    private val products = listOf(
        Product("Молоко", 10, 100.0, "Залесский фермер", "01.01.2022"),
        Product("Мясо", 5, 200.0, "Мираторг", "02.02.2022"),
        Product("Хлеб", 15, 50.0, "Первый хлебзавод", "03.03.2022")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById((R.id.recyclerView))
        adapter = ProductAdapter(products)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val maxTotalPriceProduct = products.maxByOrNull { it.quantity * it.price }
        maxTotalPriceProduct?.let {
            println("Товар с максимальной общей стоимостью: ${it.name}")
        }
    }
}