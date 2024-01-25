package com.example.whatsappsideproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whatsappsideproject.navigation.SetupNavGraph
import com.example.whatsappsideproject.screens.ChatScreen
import com.example.whatsappsideproject.screens.LoginScreen
import com.example.whatsappsideproject.ui.theme.WhatsAppSideprojectTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsAppSideprojectTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)

            }
        }
    }
}

