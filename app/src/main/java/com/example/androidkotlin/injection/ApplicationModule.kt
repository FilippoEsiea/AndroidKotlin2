package com.example.androidkotlin.injection

import android.content.Context
import androidx.room.Room
import com.example.androidkotlin.data.local.models.AppDatabase
import com.example.androidkotlin.data.local.models.DatabaseDao
import com.example.androidkotlin.data.repository.UserRepository
import com.example.androidkotlin.domain.usecase.CreateUserUseCase
import com.example.androidkotlin.domain.usecase.GetUserUseCase
import com.example.androidkotlin.presentation.account.CreateAccountViewModel
import com.example.androidkotlin.presentation.login.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get()) }
    factory { CreateAccountViewModel(get()) }
}

val domainModule: Module = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule: Module = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}
