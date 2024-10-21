package com.example.safebite.repository

import com.example.safebite.domain.model.User
import com.example.safebite.service.AuthService
import com.example.safebite.service.AuthServiceImpl
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

interface AuthRepository {
    suspend fun signup(user:User, password:String)
    suspend fun login(email:String, password:String)
}

class AuthRepositoryImpl(
    val authService: AuthService = AuthServiceImpl(),
    val userRepository: UserRepository = UserReposotoryImpl()
):AuthRepository{
    override suspend fun signup(user:User, password:String) {
        authService.createUser(user.email, password)
        val uid=Firebase.auth.currentUser?.uid
        uid?.let{
            user.id = it
            userRepository.createUser(user)
        }
    }

    override suspend fun login(email: String, password: String) {
        authService.loginWithEmailandPassword(email, password)
    }

}