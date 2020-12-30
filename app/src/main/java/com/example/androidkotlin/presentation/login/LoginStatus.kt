package com.example.androidkotlin.presentation.login

sealed class LoginStatus

data class LoginSuccess(val email: String, val password: String) : LoginStatus()
object LoginError : LoginStatus()
