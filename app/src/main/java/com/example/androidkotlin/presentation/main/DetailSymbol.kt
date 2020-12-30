package com.example.androidkotlin.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlin.R
import com.example.androidkotlin.presentation.login.recyclerview.SymbolList
import kotlinx.android.synthetic.main.symbol_detail.*

class DetailSymbol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.symbol_detail)

        val symbolText: TextView = findViewById(R.id.Details)
        val nameText: TextView = findViewById(R.id.Name)
        val rankText: TextView = findViewById(R.id.Rank)
        val priceText: TextView = findViewById(R.id.Price)

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

        backButton4.setOnClickListener {
            val intent = Intent(this, SymbolList::class.java)
            startActivity(intent)
        }
    }
}