package com.example.odev6

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odev6.ui.theme.archiveblack
import com.example.odev6.ui.theme.orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa() {

    val searchQuery = remember { mutableStateOf("") }

    val menuler = remember { mutableStateListOf<DataClass>() }

    LaunchedEffect(key1 = true) {
        val menu1 = DataClass(1, "sanalmarkett")
        val menu2 = DataClass(2, "migroshemen")
        val menu3 = DataClass(3, "migorsyemek")
        val menu4 = DataClass(4, "tazedirekt")
        val menu5 = DataClass(5, "macro")
        val menu6 = DataClass(6, "extra")
        menuler.add(menu1)
        menuler.add(menu2)
        menuler.add(menu3)
        menuler.add(menu4)
        menuler.add(menu5)
        menuler.add(menu6)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "MİGROS",
                        fontFamily = archiveblack,
                        fontSize = 26.sp
                    )
                },
                actions = {
                    IconButton(
                        onClick = { /* TODO: Handle click */ },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.notifications),
                            contentDescription = "Notifications"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = orange
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp), 
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = searchQuery.value,
                onValueChange = { newText -> searchQuery.value = newText },
                label = { Text("Ürün, yemek veya hizmet ara") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search Icon"
                    )
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.mic),
                        contentDescription = "Mic Icon"
                    )
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )

            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(end = 8.dp, start = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kampanya),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                            .background(Color.Gray.copy(alpha = 0.7f))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "1/14",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    items(
                        count = menuler.count(),
                        itemContent = {
                            val menu = menuler[it]
                            Card(
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                                    .height(110.dp)
                                    .background(Color.White)
                            ) {
                                val activity = (LocalContext.current as Activity)
                                Image(
                                    painter = painterResource(
                                        id = activity.resources.getIdentifier(
                                            menu.resim,
                                            "drawable",
                                            activity.packageName
                                        )
                                    ),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    )
                }
            }

            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(end = 8.dp, start = 8.dp)
                    .height(100.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mion),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

