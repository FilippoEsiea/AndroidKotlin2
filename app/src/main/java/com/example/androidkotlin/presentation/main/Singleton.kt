package com.example.androidkotlin.presentation.main

import android.content.Context
import android.content.SharedPreferences
import com.example.androidkotlin.data.remote.SymbolAPI
import com.example.androidkotlin.data.local.models.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singleton {

    object Singletons {
        private var gsonInstance: Gson? = null
        private var symbolAPIInstance: SymbolAPI? = null
        private var sharedPreferencesInstance: SharedPreferences? = null
        val gson: Gson?
            get() {
                if (gsonInstance == null) {
                    gsonInstance = GsonBuilder()
                        .setLenient()
                        .create()
                }
                return gsonInstance
            }

        fun getSharedPreferences(context: Context): SharedPreferences? {
            if (sharedPreferencesInstance == null) {
                sharedPreferencesInstance =
                    context.getSharedPreferences("Esiea_3A", Context.MODE_PRIVATE)
            }
            return sharedPreferencesInstance
        }

        val symbolAPI: SymbolAPI?
            get() {
                if (symbolAPIInstance == null) {
                    val retrofit: Retrofit = Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                    symbolAPIInstance = retrofit.create(SymbolAPI::class.java)
                }
                return symbolAPIInstance
            }
    }
}