package com.thoen.zaladaandroid.views.cart.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.data.ItemCartModel
import com.thoen.zaladaandroid.views.cart.functions.ItemInCart
import com.thoen.zaladaandroid.views.favorite.ShapeIcons
import com.thoen.zaladaandroid.views.home.ListProducts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navController: NavController
) {
    var listCart by remember {
        mutableStateOf(
            listOf(
                ItemCartModel(
                    id = 1,
                    name = "Macbook Pro 2021 16 inch M1 Pro",
                    originalPrice = 1200.00,
                    discountPrice = 1000.00,
                    quantity = 1,
                    image = R.drawable.mac,
                    isChecked = true
                ),
                ItemCartModel(
                    id = 2,
                    name = "Macbook Pro 2021 16 inch M1 Pro",
                    originalPrice = 1000.00,
                    discountPrice = 800.00,
                    quantity = 1,
                    image = R.drawable.mac,
                    isChecked = true
                ),
                ItemCartModel(
                    id = 2,
                    name = "Macbook Pro 2021 16 inch M1 Pro",
                    originalPrice = 1500.00,
                    discountPrice = 1200.00,
                    quantity = 1,
                    image = R.drawable.mac,
                    isChecked = true
                ),
            )
        )
    }

    var total by remember { mutableDoubleStateOf(0.0) }

    fun calculateTotal() {
        total = listCart.filter { it.isChecked }.sumOf { it.discountPrice * it.quantity }
    }
    calculateTotal()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Cart",
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        fontSize = 24.sp
                    )
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(100))
                            .background(Color.White.copy(alpha = 0.1f))
                            .border(
                                width = 1.dp,
                                color = Color.Gray.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(100)
                            )
                            .clickable(
                                onClick = {
                                    navController.popBackStack()
                                }
                            )
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "Minus",
                            tint = Color(0xFF2D3C52),
                        )
                    }
                },
            )

        },
        bottomBar = {
            BottomAppBar(
                contentPadding = PaddingValues(0.dp),
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = "Grand Total: $total\$",
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Button(
                            onClick = {
                                //tap to c
                            },
                            modifier = Modifier
                                .height(48.dp)
                                .padding(horizontal = 16.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF2D3C52),
                            )

                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = "Checkout",
                                    color = Color.White,
                                    style = typography.bodyLarge,
                                )
                                Spacer(modifier = Modifier.size(4.dp))
                                Text(
                                    text = "(${listCart.filter { it.isChecked }.size})",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }

                        }

                    }
                },
                tonalElevation = 0.dp,
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
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Checkbox(
                        checked = listCart.all { it.isChecked },
                        onCheckedChange = {
                            listCart = listCart.map { item ->
                                item.copy(isChecked = it)
                            }
                        },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.White,
                            checkedColor = Color(0xFF2D3C52),
                            uncheckedColor = Color(0xFF2D3C52)
                        )
                    )
                    Spacer(modifier = Modifier.size(2.dp))
                    Text(
                        text = "Select All Products",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))
                listCart.forEachIndexed { index, item ->
                    ItemInCart(
                        title = item.name,
                        originalPrice = item.originalPrice,
                        discountPrice = item.discountPrice,
                        image = item.image,
                        quantity = item.quantity,
                        isChecked = item.isChecked,
                        onCheckedChange = { checked ->
                            listCart = listCart.mapIndexed { i, item ->
                                if (i == index) {
                                    item.copy(isChecked = checked)
                                } else {
                                    item
                                }
                            }
                        },
                        onDeleted = {
                            listCart = listCart.filterIndexed { i, _ ->
                                i != index
                            }
                        },
                        onPlus = {
                            listCart = listCart.mapIndexed { i, it ->
                                if (i == index) {
                                    it.copy(quantity = it.quantity + 1)
                                } else {
                                    it.copy(discountPrice = it.discountPrice * it.quantity)
                                }
                            }.also {
                                calculateTotal()
                            }
                        },

                        onMinus = {
                            listCart = listCart.mapIndexed { i, it ->
                                if (i == index && it.quantity > 1) {
                                    it.copy(quantity = it.quantity - 1)
                                } else {
                                    it
                                }
                            }.also {
                                calculateTotal()
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Recommended for you",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp),
                ) {
                    for (i in 1..5) {
                        ListProducts(
                            end = true,
                            onClick = {
                                //tap to c
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen(navController = rememberNavController())
}