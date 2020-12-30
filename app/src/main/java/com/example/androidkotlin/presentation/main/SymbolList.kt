package com.example.androidkotlin.presentation.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkotlin.R
import com.example.androidkotlin.data.remote.SymbolAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.all_symbols.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import com.example.androidkotlin.data.local.models.models.Results
import com.example.androidkotlin.data.local.models.models.Symbol
import kotlinx.android.synthetic.main.account_creation.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.symbol_detail.*


class SymbolList : AppCompatActivity(), SymbolAdapter.OnSymbolItemClickListener {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_symbols)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.coinlore.net/")
            .build()

        val api = retrofit.create(SymbolAPI::class.java)
        api.getAllSymbol().enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                if (response.body()!!.data.isNotEmpty()) {
                    showData(response.body()!!.data as MutableList<Symbol>)
                }
                Toast.makeText(this@SymbolList, "response successful", Toast.LENGTH_LONG)
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                if (t is IOException) {
                    Toast.makeText(this@SymbolList, "network error", Toast.LENGTH_LONG)
                        .show()
                    Log.e("NETWORK ERROR", t.message)
                } else {
                    Toast.makeText(this@SymbolList, "conversion error", Toast.LENGTH_LONG)
                        .show()
                    Log.e("CONVERSION ERROR", t.message)

                }
            }
        })

        backButton3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showData(symbolList: MutableList<Symbol>) {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@SymbolList)
        recyclerView.adapter = SymbolAdapter(symbolList, this)
    }

    override fun onItemClick(symbol: Symbol, position: Int) {

        val intent = Intent(this, DetailSymbol::class.java)

        intent.putExtra("symbol", symbol.symbol)
        intent.putExtra("name", symbol.name)
        intent.putExtra("rank", symbol.rank.toString())
        intent.putExtra("price_usd", symbol.price_usd)

        startActivity(intent)
    }

}