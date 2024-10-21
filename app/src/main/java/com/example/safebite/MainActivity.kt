package com.example.safebite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safebite.domain.model.User
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
    NavHost(navController = navController, startDestination = "signup"){
        composable("login"){ LoginScreen(navController)}
        composable("profile"){ ProfileScreen(navController)}
        composable("signup"){ SignupScreen(navController)}
    }
}

@Composable
fun LoginScreen(navController: NavController, authViewModel:SignupViewModel = viewModel()){
    val authState by authViewModel.authState.observeAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        TextField(value=email, onValueChange={email=it})
        TextField(value=password, onValueChange={password=it})

        if(authState == 1){
            Text(text="Hubo un error")
        }else if(authState == 3){
            navController.navigate("profile")
        }
        Button(onClick = {
            authViewModel.login(email,password)
        }) {
            Text(text="Iniciar sesión")
        }
    }
}

@Composable
fun SignupScreen(navController: NavController, signupViewModel:SignupViewModel = viewModel()){

    val authState = signupViewModel.authState.observeAsState()

    var name by remember { mutableStateOf("")}
    var username by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var heightInput by remember { mutableStateOf("") }
    var height by remember { mutableStateOf<Int?>(null)}
    var weightInput by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf<Int?>(null)}

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            TextField(value = name, onValueChange = { name = it } )
            TextField(value = username, onValueChange = { username = it } )
            TextField(value = email, onValueChange = { email = it } )
            TextField(value = password, onValueChange = { password = it } )
            TextField(value = heightInput, onValueChange = { heightInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number) )
            TextField(value = weightInput, onValueChange = { weightInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number) )

            if (authState.value == 1){
                CircularProgressIndicator()
            }else if(authState.value == 2) {
                Text("Hubo un error", color= Color.Red)
            }else if(authState.value == 3){
                navController.navigate("profile")
            }
            Button(onClick = {
                weight = weightInput.toIntOrNull()
                height = heightInput.toIntOrNull()

                signupViewModel.signup(
                    User("", name, username, email, height, weight), password)
            }){
                Text(text = "Registrarse")
            }
        }

    }

}


@Composable
fun ProfileScreen(navController: NavController, profileViewModel: ProfileViewModel = viewModel()){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SafebiteTheme {
        App()
    }
}