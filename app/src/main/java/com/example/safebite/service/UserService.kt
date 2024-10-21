package com.example.safebite.service

import com.example.safebite.domain.model.User

interface UserService {
    suspend fun createUser(user:User)
    suspend fun getUserById(id:String):User?
}

class UserServiceImpl:UserService{
    override suspend fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById(id: String): User? {
        TODO("Not yet implemented")
    }

}