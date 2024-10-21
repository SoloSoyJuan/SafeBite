package com.example.safebite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safebite.ui.theme.SafebiteTheme
import com.example.safebite.viewmodel.ProfileViewModel
import com.example.safebite.viewmodel.SignupViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SafebiteTheme {
                App()
            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){ LoginScreen(navController)}
        composable("profile"){ ProfileScreen(navController)}
        composable("signup"){ SignupScreen(navController)}
    }
}

@Composable
fun LoginScreen(navController: NavController, authViewModel:SignupViewModel = viewModel()){

}

@Composable
fun ProfileScreen(navController: NavController, profileViewModel: ProfileViewModel = viewModel()){

}

@Composable
fun SignupScreen(navController: NavController, authViewModel:SignupViewModel = viewModel()){

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SafebiteTheme {
        App()
    }
}