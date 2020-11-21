package com.example.androidkotlin.data.repository

import com.example.androidkotlin.data.local.models.DatabaseDao
import com.example.androidkotlin.data.local.models.models.toData
import com.example.androidkotlin.data.local.models.models.toEntity
import com.example.androidkotlin.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {
    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User? {
        val userLocal = databaseDao.findByName(email)
        return userLocal.toEntity()
    }
}