package com.example.safebite.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safebite.domain.model.User
import com.example.safebite.repository.AuthRepository
import com.example.safebite.repository.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupViewModel (
    val repo: AuthRepository = AuthRepositoryImpl()
): ViewModel() {

    val authState = MutableLiveData(0)
    // 0. Idle
    // 1. Loading
    // 2. Error
    // 3. Success

    fun signup(user:User, password:String){
        viewModelScope.launch(Dispatchers.IO){
            withContext(Dispatchers.Main){ authState.value = 1}
            try {
                repo.signup(user, password)
                withContext(Dispatchers.Main){authState.value = 3}
            }catch (ex:FirebaseAuthException){
                withContext(Dispatchers.Main){ authState.value = 2}
                ex.printStackTrace()
            }
        }
    }

    fun login(email:String, password:String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                withContext(Dispatchers.Main){authState.value = 1}
                repo.login(email, password)
                withContext(Dispatchers.Main){authState. value = 3}
            }catch (ex:FirebaseAuthException){
                ex.printStackTrace()
            }
        }
    }

}