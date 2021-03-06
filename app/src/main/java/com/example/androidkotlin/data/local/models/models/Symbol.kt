package com.example.androidkotlin.data.local.models.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Symbol(
    @Json(name = "symbol") val symbol: String,
    @Json(name = "name") val name: String,
    @Json(name = "rank") val rank: Int,
    @Json(name = "price_usd") val price_usd: String
) : Parcelable