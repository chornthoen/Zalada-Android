package com.thoen.zaladaandroid.views.favorite.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.views.home.ListProducts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Favorite",
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    ShapeIcons(
                        onClick = {},
                        icon = R.drawable.search_light
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                }
            )

        },
        bottomBar = {
            BottomAppBar(
                actions = {

                }
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .imePadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                ListProduct()

            }
        }
    }
}

@Composable
fun ListProduct() {
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
fun ShapeIcons(
    onClick: () -> Unit,
    icon: Int
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(100))
            .background(Color.Gray.copy(alpha = 0.1f))
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Icon",
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(Color.Black),

            alignment = Alignment.CenterEnd
        )
    }
}

@Preview
@Composable
fun PreviewFavoriteScreen() {
    FavoriteScreen(navController = rememberNavController())
}