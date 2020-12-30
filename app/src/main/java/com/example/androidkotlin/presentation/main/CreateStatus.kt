package com.example.androidkotlin.presentation.main

sealed class CreateStatus

data class CreateSuccess(val email: String, val password: String) : CreateStatus()
object CreateError : CreateStatus()
