package com.example.androidkotlin.data.local.models.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidkotlin.domain.entity.User

@Entity
data class UserLocal(
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null
}

fun User.toData(): UserLocal {
    return UserLocal(
        email = email,
        password = password
    )
}

fun UserLocal.toEntity(): User {
    return User(
        email = email,
        password = password
    )
}