package com.example.androidkotlin.data.remote

import com.example.androidkotlin.data.local.models.models.Results
import retrofit2.Call
import retrofit2.http.GET

interface SymbolAPI{
    @GET("api/tickers/")
    fun getAllSymbol(): Call<Results>
}