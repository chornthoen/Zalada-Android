package com.thoen.zaladaandroid.views.home


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.data.Categories
import com.thoen.zaladaandroid.router.Cart
import com.thoen.zaladaandroid.router.DetailProduct
import com.thoen.zaladaandroid.router.ProductAll
import com.thoen.zaladaandroid.router.Search
import com.thoen.zaladaandroid.views.home.functions.Banner
import com.thoen.zaladaandroid.views.home.functions.CategoryItem
import com.thoen.zaladaandroid.views.home.functions.GirdItem
import com.thoen.zaladaandroid.views.home.functions.LabelAndAction
import com.thoen.zaladaandroid.views.home.functions.ListProducts
import com.thoen.zaladaandroid.views.home.functions.ShapeIcon

@Composable
fun HomeScreen(
    navController: NavController
) {
    val categories = listOf(
        Categories("Phone", R.drawable.mobile),
        Categories("Laptop", R.drawable.laptop),
        Categories("Monitor", R.drawable.desktop),
        Categories("Headphone", R.drawable.headphones),
        Categories("Mouse", R.drawable.mouse),
        Categories("Keyboard", R.drawable.keyboard),
        Categories("Speaker", R.drawable.speaker),
        Categories("Microphone", R.drawable.microphone),
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()

                .imePadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(340.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFFFD6C8A),
                                    Color(0xFFFDA56C)
                                ),
                            )
                        )
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.White.copy(alpha = 0.5f),
                                    Color.White
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY)
                            )
                        )
                ) {
                    Column {
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ShapeIcon(
                                onClick = {},
                                icon = R.drawable.location
                            )
                            Spacer(modifier = Modifier.size(12.dp))
                            Column {
                                Text(
                                    text = "Location",
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                                Text(
                                    text = "Phnom Penh",
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            ShapeIcon(
                                onClick = {
                                    navController.navigate(Cart.route)
                                },
                                icon = R.drawable.buy,
                                count = 3
                            )
                            Spacer(modifier = Modifier.size(12.dp))
                            ShapeIcon(
                                onClick = {
                                    navController.navigate(Search.route)

                                },
                                icon = R.drawable.search_bold,
                            )
                        }
                        Text(
                            text = "Find best device for your setup!",
                            color = Color.White,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.W600,
                            lineHeight = 25.sp,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        AutoScrollingLazyRow()
                        Spacer(modifier = Modifier.size(12.dp))
                    }
                }
                Spacer(modifier = Modifier.size(12.dp))
                LabelAndAction(
                    label = "Categories",
                    onClick = {}
                )
                Spacer(modifier = Modifier.size(12.dp))
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp),
                ) {
                    for (i in categories) {
                        CategoryItem(
                            onClick = {},
                            icon = i.icon,
                            title = i.title
                        )
                    }
                }
                Spacer(modifier = Modifier.size(12.dp))
                LabelAndAction(
                    label = "New Arrival",
                    onClick = {
                        navController.navigate(ProductAll.route)
                    }
                )
                Spacer(modifier = Modifier.size(12.dp))
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp),
                ) {
                    for (i in 1..5) {
                        GirdItem(
                            onClick = {
                                navController.navigate(DetailProduct.route)
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(12.dp))
                LabelAndAction(
                    label = "Popular Products",
                    onClick = {
                        navController.navigate(ProductAll.route)
                    }
                )
                Spacer(modifier = Modifier.size(12.dp))
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp),
                ) {
                    for (i in 1..5) {
                        ListProducts(
                            end = true,
                            onClick = {
                                navController.navigate(DetailProduct.route)
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(100.dp))
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoScrollingLazyRow(
    modifier: Modifier = Modifier
) {
    var pageState = rememberPagerState (pageCount = { 5 })

    Box(
        modifier = modifier
            .wrapContentSize()
    ) {
        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Banner()
            }
        }

    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}