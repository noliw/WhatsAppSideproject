package com.example.whatsappsideproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
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
import com.example.whatsappsideproject.ui.theme.textColor
import com.example.whatsappsideproject.ui.theme.whatsApp
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(
            count = 50,
            key = {
                val person = generatePerson(it)
                person.id
            }
            ) { index ->
            val person = remember { generatePerson(index) }
            ItemList(person = person)
        }
    }
}


fun generatePerson(index: Int): Person {
    val hours = index * 2
    val minutes = index * 10
    val timeString = String.format("%02d:%02d", hours, minutes)
    return Person(
        name = "Lionel Messi ${index + 1}",
        time = timeString,
        messageCount = index + 2 * 3
    )
}

@Composable
fun ItemList(
    modifier: Modifier = Modifier,
    person: Person
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(White)
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
                    .size(50.dp)
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
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 16.sp,
                        color = textColor
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
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        modifier = Modifier.weight(1f),
                        text = person.lastMessage,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Gray
                    )
                    Box(
                        modifier = Modifier
                            .background(whatsApp, CircleShape)
                            .wrapContentSize()
                            .padding(horizontal = 7.dp, vertical = 5.dp)
                            .sizeIn(minWidth = 12.dp, minHeight = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = person.messageCount.toString(),
                            color = Color.White,
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
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

@Immutable
data class Person(
    val picture: Int = R.drawable.dummy_pic,
    val name: String,
    val lastMessage: String = LoremIpsum(10).values.first(),
    val time: String,
    var messageCount: Int = 1,
    var id: String = UUID.randomUUID().toString()
)