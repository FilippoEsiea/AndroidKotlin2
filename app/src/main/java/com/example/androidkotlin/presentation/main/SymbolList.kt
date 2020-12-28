package com.example.androidkotlin.presentation.main

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


class SymbolList : AppCompatActivity() {
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
                    showData(response.body()!!.data)
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
    }

    private fun showData(symbolList: List<Symbol>) {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@SymbolList)
        recyclerView.adapter = SymbolAdapter(symbolList)
    }
}