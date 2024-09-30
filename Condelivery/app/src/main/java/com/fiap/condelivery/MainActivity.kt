package com.fiap.condelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fiap.condelivery.screens.LoginScreen
import com.fiap.condelivery.screens.UserProfileScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable(route = "home") {
                    UserProfileScreen(navController)
                }
                composable(route = "login") {
                    LoginScreen(navController)
                }

            }
        }
    }
}

