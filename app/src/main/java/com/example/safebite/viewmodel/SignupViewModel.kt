package com.example.safebite.viewmodel

import androidx.lifecycle.ViewModel
import com.example.safebite.repository.AuthRepository
import com.example.safebite.repository.AuthRepositoryImpl

class SignupViewModel (
    val repo: AuthRepository = AuthRepositoryImpl()
): ViewModel() {

    fun signup(){
        TODO("Not yet implemented")
    }

    fun login(){
        TODO("Not yet implemented")
    }

}