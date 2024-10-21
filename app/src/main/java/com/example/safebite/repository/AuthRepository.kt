package com.example.safebite.repository
import com.example.safebite.service.AuthService
import com.example.safebite.service.AuthServiceImpl
import com.example.safebite.service.UserService
import com.example.safebite.service.UserServiceImpl

interface AuthRepository {
    suspend fun signup()
    suspend fun login()
}

class AuthRepositoryImpl(
    val authService: AuthService = AuthServiceImpl(),
    val userService: UserService = UserServiceImpl()
):AuthRepository{
    override suspend fun signup() {
        TODO("Not yet implemented")
    }

    override suspend fun login() {
        TODO("Not yet implemented")
    }

}