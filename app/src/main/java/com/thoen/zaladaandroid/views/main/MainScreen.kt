package com.thoen.zaladaandroid.views.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.thoen.zaladaandroid.data.NavItem
import com.thoen.zaladaandroid.views.cart.CartScreen
import com.thoen.zaladaandroid.views.favorite.FavoriteScreen
import com.thoen.zaladaandroid.views.home.HomeScreen
import com.thoen.zaladaandroid.views.notification.NotificationScreen
import com.thoen.zaladaandroid.views.profile.ProfileScreen

@Composable
fun MainScreen(
    navController: NavController
) {
    val items = listOf(
        NavItem("Home", R.drawable.home_light, R.drawable.home_bulk),
        NavItem("Favorite", R.drawable.heart_light, R.drawable.heart_bulk),
        NavItem("Cart", R.drawable.bag_light, R.drawable.bag_bulk),
        NavItem("Notification", R.drawable.notification_light, R.drawable.notification_bulk),
        NavItem("Profile", R.drawable.profile_light, R.drawable.profile_bulk),


        )

    var selectedIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    items.forEachIndexed { index, item ->
                        ItemBottomBar(
                            item = item,
                            isSelected = index == selectedIndex,
                            onClick = {
                                selectedIndex = index
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex,
            navController = navController,
        )
    }
}


@SuppressLint("RememberReturnType", "UnrememberedMutableInteractionSource")
@Composable
fun ItemBottomBar(
    item: NavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(74.dp)
            .imePadding()
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = MutableInteractionSource(),
            )
            .padding(vertical = 8.dp, horizontal = 2.dp)


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = if (isSelected) item.iconSelected else item.icon),
                contentDescription = item.title,
                alignment = Alignment.Center,
                colorFilter = ColorFilter.tint(if (isSelected) Color.Black else Color.Gray),
                modifier = Modifier.size(26.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = item.title,
                fontSize = 12.sp,
                color = if (isSelected) Color.Black else Color.Gray,
                fontWeight = if (isSelected) FontWeight.W500 else FontWeight.Normal
            )
        }
    }
}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    selectedIndex: Int = 0
) {
    when (selectedIndex) {
        0 -> HomeScreen(navController)
        1 -> FavoriteScreen(navController)
        2 -> CartScreen(navController)
        3 -> NotificationScreen(navController)
        4 -> ProfileScreen(navController)
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen(
        navController = rememberNavController()
    )
}