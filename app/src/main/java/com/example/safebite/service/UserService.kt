package com.example.safebite.service

import com.example.safebite.domain.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

interface UserService {
    suspend fun createUser(user:User)
    suspend fun getUserById(id:String):User?
}

class UserServiceImpl:UserService{
    override suspend fun createUser(user: User) {
       Firebase.firestore
           .collection("users")
           .document(user.id)
           .set(user)
           .await()
    }

    override suspend fun getUserById(id: String): User? {
        val user = Firebase.firestore
            .collection("users")
            .document(id)
            .get()
            .await()
        val userObj = user.toObject(User::class.java)
        return userObj
    }

}