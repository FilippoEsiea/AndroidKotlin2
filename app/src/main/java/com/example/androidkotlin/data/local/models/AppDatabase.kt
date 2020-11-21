package com.example.androidkotlin.data.local.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidkotlin.data.local.models.models.UserLocal

@Database(
    entities = arrayOf(
        UserLocal::class
    ), version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}