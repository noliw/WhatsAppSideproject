package com.example.whatsappsideproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatsappsideproject.screens.ChatScreen
import com.example.whatsappsideproject.screens.LoginScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.HomeChat.route
        ){
            ChatScreen()
        }
    }
}