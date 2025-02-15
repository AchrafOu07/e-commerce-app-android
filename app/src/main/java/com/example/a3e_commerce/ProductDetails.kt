package com.example.a3e_commerce

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)
        val title = intent.getStringExtra("title")
        product_name.text = title

        availability.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Sup, $title Kayna a DADA")
                .setPositiveButton("OK") { p0, p1 ->

                }
                .create()
                .show()
        }
    }
}