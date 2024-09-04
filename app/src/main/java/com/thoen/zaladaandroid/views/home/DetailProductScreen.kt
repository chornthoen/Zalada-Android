package com.thoen.zaladaandroid.views.home


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.component.ButtonBack
import com.thoen.zaladaandroid.router.DetailProduct
import com.thoen.zaladaandroid.views.favorite.screen.ShapeIcons


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsProductScreen(
    navController: NavController
) {

    val listColors = listOf(
        Color(0xFF2D3C52),
        Color(0xFFA6A5AA),
        Color(0xFFF2E0CC),
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "",
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)

                    ) {
                        ButtonBack(
                            onClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                },
                actions = {
                    ShapeIcons(
                        onClick = {},
                        icon = R.drawable.bag_light
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    ShapeIcons(
                        onClick = {},
                        icon = R.drawable.heart_light
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                }
            )

        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box (
                        contentAlignment = Alignment.TopEnd
                    ){
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(100))
                                .background(Color.White.copy(alpha = 0.1f))
                                .border(
                                    width = 1.dp,
                                    color = Color.Gray.copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(100)
                                )
                                .clickable(
                                    onClick = {}
                                )
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.buy),
                                contentDescription = "Add to cart",
                                tint = Color(0xFF2D3C52),
                                modifier = Modifier.size(30.dp)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(100))
                                .background(Color(0xFFE8E8EA)),
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.add_),
                                contentDescription = "Icon",
                                colorFilter = ColorFilter.tint(Color.Black),

                                alignment = Alignment.CenterEnd
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .height(48.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2D3C52),
                        )
                    ) {
                        Text(
                            text = "Checkout",
                            color = Color.White,
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp
                        )
                        
                    }
                }
            }
        }
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
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
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
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Macbook Pro 15” 2019 - Intel core i7",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "$1,200",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W700,
                            color = Color(0xFF1B5EC9)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = "$1,500",
                            fontSize = 14.sp,
                            color = Color(0xFF7C7D82),
                            fontWeight = FontWeight.W400,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }
                SliderProduct()
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Color",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                LazyRow(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    items(listColors.size) {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(40.dp)
                                .clip(RoundedCornerShape(100))
                                .background(listColors[it])
                                .clickable(
                                    onClick = {

                                    }
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFA6A5AA),
                                    shape = RoundedCornerShape(100)
                                )
                                .padding(2.dp)
                        ) {

                        }

                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Description",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "The MacBook Pro is a line of Macintosh portable computers introduced in January 2006, by Apple Inc. It is the higher-end model of the MacBook family,",
                    fontSize = 14.sp,
                    color = Color(0xFF7C7D82),
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Recommend for you",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                LazyRow {
                    items(5) {
                        ListProducts(
                            end = true,
                            onClick = {
                                navController.navigate(DetailProduct.route)
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SliderProduct(modifier: Modifier = Modifier) {
    val pageState = rememberPagerState(pageCount = { 5 })
    Column {
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
                    Image(
                        painter = painterResource(id = R.drawable.mac),
                        contentDescription = "",
                        modifier = Modifier
                            .size(400.dp)
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .padding(horizontal = 16.dp)
                    )
                }
            }

        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 0 until 5) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)

                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            Color.White
                        )
                        .border(
                            width = 1.dp,
                            color = if (pageState.currentPage == i)
                                Color(0xFF2D3C52) else
                                Color(0xFFEAEAEA),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mac),
                        contentDescription = "",
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    DetailsProductScreen(navController = rememberNavController())
}