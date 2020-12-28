package com.example.androidkotlin.data.local.models.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

data class Results( 
    val data: List<Symbol>
)