package com.example.safebite.repository

import com.example.safebite.domain.model.User
import com.example.safebite.service.UserService
import com.example.safebite.service.UserServiceImpl
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

interface UserRepository {
    suspend fun createUser(user: User)
    suspend fun getCurrentUser(): User?
}

class UserReposotoryImpl(
val userService: UserService = UserServiceImpl()
): UserRepository{
    override suspend fun createUser(user: User) {
        userService.createUser(user)
    }

    override suspend fun getCurrentUser(): User? {
        Firebase.auth.currentUser?.let{
            return userService.getUserById(it.uid)
        }?:run {
            return null
        }
    }

}