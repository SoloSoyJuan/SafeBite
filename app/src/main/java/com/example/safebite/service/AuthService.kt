package com.example.safebite.service

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

interface AuthService {
    suspend fun createUser(email:String, password:String)
    suspend fun loginWithEmailandPassword(email:String, password:String)
}

class AuthServiceImpl:AuthService{

    override suspend fun createUser(email:String, password:String) {
        Firebase.auth.createUserWithEmailAndPassword(email, password).await()
    }

    override suspend fun loginWithEmailandPassword(email:String, password:String) {
        Firebase.auth.signInWithEmailAndPassword(email, password).await()
    }

}