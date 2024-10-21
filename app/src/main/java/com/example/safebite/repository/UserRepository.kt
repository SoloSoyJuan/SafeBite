package com.example.safebite.repository

import com.example.safebite.domain.model.User
import com.example.safebite.service.UserService
import com.example.safebite.service.UserServiceImpl

interface UserRepository {
    suspend fun createUser(user: User)
    suspend fun getCurrentUser(): User?
}

class UserReposotoryImpl(
val userService: UserService = UserServiceImpl()
): UserRepository{
    override suspend fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentUser(): User? {
        TODO("Not yet implemented")
    }

}