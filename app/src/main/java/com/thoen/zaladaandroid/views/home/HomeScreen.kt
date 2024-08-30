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
import com.thoen.zaladaandroid.router.Search

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
                    onClick = {}
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
                    onClick = {}
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

@Composable
fun ListProducts(
    end: Boolean = false,
    onClick: () -> Unit = {},
) {

    Box(
        modifier = Modifier
            .padding(end = if (end) 12.dp else 0.dp)
            .width(186.dp)
            .height(255.dp)
            .clip(RoundedCornerShape(16.dp))

            .background(Color.Transparent)

    ) {
        Box(
            modifier = Modifier
                .width(186.dp)
                .height(245.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable(
                    onClick = onClick
                )
                .background(Color.White)
                .padding(horizontal = 12.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mac),
                    contentDescription = "Mac",
                    modifier = Modifier
                        .height(120.dp)
                        .width(130.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Macbook Pro 2019 15” - Intel core i7",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.size(6.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$1,200",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = Color(0xFF1B5EC9)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "$1,500",
                        fontSize = 10.sp,
                        color = Color(0xFF7C7D82),
                        fontWeight = FontWeight.W400,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFFF9C44))
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = "NEW ARRIVAL",
                fontSize = 10.sp,
                fontWeight = FontWeight.W600,
                color = Color.White
            )
        }
    }
}


@Composable
fun CategoryItem(
    onClick: () -> Unit,
    icon: Int,
    title: String
) {
    Box(
        modifier = Modifier
            .padding(end = 12.dp)
            .size(80.dp, 80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .clickable(
                onClick = onClick
            )
            .padding(vertical = 4.dp, horizontal = 2.dp),


        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(Color(0xFF576F85).copy(alpha = 0.2f))
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "Mac",
                    modifier = Modifier
                        .size(26.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500
            )
        }
    }
}

@Composable
fun LabelAndAction(
    label: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "See All",
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            color = Color(0xFF1B5EC9),
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(
                    onClick = onClick,

                    )
                .clip(RoundedCornerShape(8.dp))
                .padding(4.dp)
        )
    }
}

@Composable
fun GirdItem(
    onClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(186.dp)
            .height(255.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Transparent)

    ) {
        Box(
            modifier = Modifier
                .width(186.dp)
                .height(245.dp)

                .clip(RoundedCornerShape(16.dp))
                .clickable(
                    onClick = onClick
                )
                .background(Color.White)
                .padding(horizontal = 12.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mac),
                    contentDescription = "Mac",
                    modifier = Modifier
                        .height(120.dp)
                        .width(130.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Macbook Pro 2019 15” - Intel core i7",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.size(6.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$1,200",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = Color(0xFF1B5EC9)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "$1,500",
                        fontSize = 10.sp,
                        color = Color(0xFF7C7D82),
                        fontWeight = FontWeight.W400,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(
                                Color(0xFF2D3C52),
                                shape = RoundedCornerShape(100)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = "Add",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )

                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFFF9C44))
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = "NEW ARRIVAL",
                fontSize = 10.sp,
                fontWeight = FontWeight.W600,
                color = Color.White
            )
        }
    }
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .width(410.dp)
            .height(200.dp)
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(16.dp))
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)

            )
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFC6AFF),
                        Color(0xFF759BFD)
                    ),
                )
            )

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Get 50% off on your first order.",
                        color = Color.White,
                        fontSize = 32.sp,
                        lineHeight = 36.sp,
                        fontWeight = FontWeight.W600
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(
                        onClick = { },
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White.copy(alpha = 0.2f))
                            .padding(horizontal = 6.dp)
                    ) {
                        Row {
                            Text(
                                text = "Shop Now",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W600
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                                contentDescription = "Notification",
                                tint = Color.Black
                            )
                        }

                    }
                }
            }
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Banner",
                modifier = Modifier
                    .height(280.dp),

                alignment = Alignment.CenterEnd
            )
        }
    }
}

@Composable
fun ShapeIcon(
    onClick: () -> Unit,
    icon: Int,
    count : Int = 0
) {
    Box (
        contentAlignment = Alignment.TopEnd
    ){
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(100))
                .background(Color.White.copy(alpha = 0.2f))
                .clickable(
                    onClick = onClick
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .height(280.dp),
                colorFilter = ColorFilter.tint(Color.White),

                alignment = Alignment.CenterEnd
            )
        }
        if (count > 0) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(100))
                    .background(Color(0xFFFF5944)),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = "3",
                    color = Color.White,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.W600
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}