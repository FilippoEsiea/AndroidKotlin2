package com.example.androidkotlin.presentation.account

sealed class CreateStatus

data class CreateSuccess(val email: String, val password: String) : CreateStatus()
object CreateError : CreateStatus()
