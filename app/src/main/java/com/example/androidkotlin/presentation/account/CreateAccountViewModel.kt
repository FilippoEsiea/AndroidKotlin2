package com.example.androidkotlin.presentation.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkotlin.domain.entity.User
import com.example.androidkotlin.domain.usecase.CreateUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountViewModel(
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {
    val createLiveData: MutableLiveData<CreateStatus> = MutableLiveData()

    fun onClickedCreate(emailNewUser: String, passwordNewUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val newUser = createUserUseCase.invoke(User(emailNewUser, passwordNewUser))
            val createStatus = if (newUser != null) {
                CreateSuccess(emailNewUser, passwordNewUser)
            } else {
                CreateError
            }
            withContext(Dispatchers.Main) {
                createLiveData.value = createStatus
            }
        }
    }
}