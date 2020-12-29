package com.example.androidkotlin.presentation.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlin.R
import com.example.androidkotlin.data.local.models.models.Symbol
import kotlinx.android.synthetic.main.account_creation.*
import kotlinx.android.synthetic.main.symbol_detail.view.*
import kotlinx.android.synthetic.main.activity_main.*


class DetailSymbol : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.symbol_detail)

        val symbolView: TextView = findViewById(R.id.symbol)
        val nameView: TextView = findViewById(R.id.name)
        val rankView: TextView = findViewById(R.id.rank)
        val priceView: TextView = findViewById(R.id.price)

        val symbol = getIntent().getStringExtra("symbol")
        val name = getIntent().getStringExtra("name")
        val rank = getIntent().getStringExtra("rank")
        val price = getIntent().getStringExtra("price_usd")

        symbolView.setText(symbol)
        nameView.setText(name)
        rankView.setText(rank)
        priceView.setText(price)
    }
}