package com.example.whatsappsideproject.navigation

sealed class Screen(val route: String){
    object Login: Screen("login_screen")
    object HomeChat: Screen("chat_screen")
}
