package com.example.whatsappsideproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappsideproject.R
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
            LazyColumn(){
                item {
                    (1..100).forEach{
                        val hours = it + 1
                        val minutes = it + 15
                        val timeString = String.format("%02d:%02d AM", hours, minutes)
                        val message = it * 50
                        ItemList(person = Person(
                            name = "Lionel Messi",
                            time = timeString,
                            messageCount = message
                        ))
                    }
                }
            }
        }
    }
}


@Composable
fun ItemList(
    modifier: Modifier = Modifier,
    person: Person
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = person.picture),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape),
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = person.name,
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = person.time,
                        style = MaterialTheme.typography.bodySmall,
                        color = whatsApp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {

                    Text(
                        modifier = Modifier.weight(1f),
                        text = person.lastMessage,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Gray
                    )
                    Box(
                        modifier = Modifier
                            .background(whatsApp, CircleShape)
                            .size(20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${person.messageCount++}",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }

}


@Preview
@Composable
fun ItemListPrev() {
    Surface(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        ItemList(
            person = Person(
                name = "John Doe",
                time = "13:57 AM",
                lastMessage = LoremIpsum(10).values.first()
            )
        )
    }
}
@Preview(showSystemUi = true)
@Composable
fun ChatScreenPrev() {
    ChatScreen()
}

data class Person(
    val picture: Int = R.drawable.dummy_pic,
    val name: String,
    val lastMessage: String = LoremIpsum(10).values.first(),
    val time: String,
    var messageCount : Int = 1
)