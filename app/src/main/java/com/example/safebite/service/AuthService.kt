package com.example.safebite.service

import com.example.safebite.repository.AuthRepository

interface AuthService {
    suspend fun createUser(email:String, password:String)
    suspend fun loginWithEmailandPassword(email:String, password:String)
}

class AuthServiceImpl:AuthService{

    override suspend fun createUser(email:String, password:String) {
        TODO("Not yet implemented")
    }

    override suspend fun loginWithEmailandPassword(email:String, password:String) {
        TODO("Not yet implemented")
    }

}