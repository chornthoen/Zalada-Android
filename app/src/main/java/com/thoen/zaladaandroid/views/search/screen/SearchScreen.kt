package com.thoen.zaladaandroid.views.search.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.component.ButtonBack
import com.thoen.zaladaandroid.data.TabSearch
import com.thoen.zaladaandroid.views.home.ListProducts

@Composable
fun SearchScreen(
    navController: NavController
) {
    var search by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    val tabs = listOf(
        TabSearch("All", R.drawable.circles),
        TabSearch("Phone", R.drawable.mobile),
        TabSearch("Computer", R.drawable.laptop),
        TabSearch("Headphone", R.drawable.headphones),
        TabSearch("Keyboard", R.drawable.keyboard),
        TabSearch("Mouse", R.drawable.mouse),
        TabSearch("Speaker", R.drawable.speaker),
        TabSearch("Microphone", R.drawable.microphone),
        TabSearch("Monitor", R.drawable.monitor),
    )

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp)
            ) {
                ButtonBack(
                    onClick = {
                        navController.popBackStack()
                    }
                )
                TextField(
                    value = search,
                    onValueChange = { search = it },
                    label = { Text(text = "Search") },
                    placeholder = { Text(text = "Search Product") },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedSuffixColor = Color.Blue,
                        focusedLabelColor = Color.Gray,
                    ),
                    trailingIcon = {
                        IconButton(
                            onClick = {}
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.search_light),
                                contentDescription = ""
                            )
                        }
                    },
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color(0xFF495E57),
                            shape = RoundedCornerShape(18.dp)
                        )
                        .background(Color(0xFFFFFFFF))
                        .onFocusChanged { focusState ->
                            if (focusState.isFocused) {
                                keyboardController?.show()
                            }
                        }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .background(Color.Red),
                edgePadding = 12.dp,
                divider = {
                    HorizontalDivider(
                        color = Color.Transparent
                    )
                },

                indicator = { tabPositions ->
                    SecondaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = Color.Transparent,
                    )
                }
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = {
                            Row(
                                verticalAlignment = CenterVertically,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = title.icon),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(RoundedCornerShape(100))
                                        .background(
                                            color = if (selectedTabIndex == index)
                                                Color.White else Color(0xFFF3F6FB)
                                        )
                                        .padding(4.dp)
                                )
                                Spacer(modifier = Modifier.size(8.dp))
                                Text(
                                    text = title.title,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (selectedTabIndex == index)
                                        Color.Black else Color(0xFF495E57)
                                )
                            }
                        },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                brush = Brush.linearGradient(
                                    colors = if (selectedTabIndex == index)
                                        listOf(
                                            Color(0xFF2D3C52),
                                            Color(0xFF2D3C52).copy(alpha = 0.5f)
                                        )
                                    else listOf(Color(0xFFFFFFFF), Color(0xFFFFFFFF))
                                )
                            )
                            .border(
                                width = 1.dp,
                                color = if (selectedTabIndex == index)
                                    Color.Transparent
                                else Color(0xFF495E57),
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }
            }
            when (selectedTabIndex) {
                0 -> ListAllItems()
                1 -> ListAllItems()
                2 -> ListAllItems()
                3 -> ListAllItems()
                4 -> ListAllItems()
            }
        }
    }
}

@Composable
fun ListAllItems() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(10) {
            ListProducts(
                end = false,
            )
        }
    }
}

@Composable
fun ListPhoneItems() {
    LazyColumn {
        items(20) { index -> // Replace 20 with the actual number of items
            Text("Phone Item $index")
        }
    }
}

@Composable
fun ListComputerItems() {
    LazyColumn {
        items(20) { index -> // Replace 20 with the actual number of items
            Text("Computer Item $index")
        }
    }
}

@Composable
fun ListHeadphoneItems() {
    LazyColumn {
        items(20) { index -> // Replace 20 with the actual number of items
            Text("Headphone Item $index")
        }
    }
}

@Composable
fun ListKeyboardItems() {
    LazyColumn {
        items(20) { index -> // Replace 20 with the actual number of items
            Text("Keyboard Item $index")
        }
    }
}

@Preview
@Composable
fun PreviewSearchScreen() {
    SearchScreen(navController = rememberNavController())
}