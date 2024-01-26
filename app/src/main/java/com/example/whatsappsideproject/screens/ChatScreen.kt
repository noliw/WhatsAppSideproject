package com.example.whatsappsideproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.mandatorySystemGesturesPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsappsideproject.R
import com.example.whatsappsideproject.ui.theme.textColor
import com.example.whatsappsideproject.ui.theme.whatsApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "WhatsApp",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                },
                actions = {
                    Row(
                        modifier = Modifier.width(100.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Icon(imageVector = Icons.Outlined.CameraAlt, contentDescription = "")
                        Icon(imageVector = Icons.Outlined.Search, contentDescription = "")
                        Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "")

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = whatsApp,
                    actionIconContentColor = Color.White
                ),
                scrollBehavior = scrollBehavior


            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "I AM HERE")
        }
    }
}

@Composable
fun ItemList() {
    
}



@Preview(showSystemUi = true)
@Composable
fun ItemListPrev() {
    ItemList()
}
//@Preview(showSystemUi = true)
//@Composable
//fun ChatScreenPrev() {
//    ChatScreen()
//}

data class Person(
    val picture: Int = R.drawable.dummy_pp,
    val name: String,
    val time: Int
)