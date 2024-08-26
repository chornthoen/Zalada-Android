package com.thoen.zaladaandroid.views.profile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.component.AlertDialogCustom
import com.thoen.zaladaandroid.router.NameRouter
import com.thoen.zaladaandroid.views.favorite.ShapeIcons
import com.thoen.zaladaandroid.views.profile.functions.ItemProfile
import com.thoen.zaladaandroid.views.profile.functions.SwitcherNotification

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController
) {

    var checked by remember { mutableStateOf(false) }
    var showLogoutDialog by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Profile",
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    ShapeIcons(
                        onClick = {},
                        icon = R.drawable.edit
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
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF2BA8CF).copy(alpha = 0.2f),
                                    Color.White,
                                    Color(0xFF2BA8CF).copy(alpha = 0.1f),
                                    Color(0xFFF898DE).copy(alpha = 0.2f)
                                ),
                            )
                        )
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                )
                {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.thoen),
                            contentDescription = "Profile",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(100))
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            text = "Chorn THOEN",
                            color = Color.Black,
                            fontWeight = FontWeight.W600,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "thoenchorn@gmail.com",
                            color = Color.Gray,
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.size(24.dp))
                Text(
                    text = "Account Settings",
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.size(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                ) {
                    Column {
                        ItemProfile(
                            icon = R.drawable.location_bulk,
                            title = "Address"
                        )
                        ItemProfile(
                            icon = R.drawable.wallet,
                            title = "Payment"
                        )
                        ItemProfile(
                            icon = R.drawable.time,
                            title = "Order History",
                        )
                        SwitcherNotification(
                            icon = R.drawable.notification_bulk,
                            title = "Notification",
                            checked = checked,
                            onCheckedChange = {
                                checked = it
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "General",
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.size(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                ) {
                    Column {
                        ItemProfile(
                            icon = R.drawable.setting,
                            title = "Change Language"
                        )
                        ItemProfile(
                            icon = R.drawable.password,
                            title = "Change Password"
                        )
                        ItemProfile(
                            icon = R.drawable.done,
                            title = "Privacy Policy"
                        )
                        ItemProfile(
                            icon = R.drawable.about,
                            title = "About Us",
                            end = true
                        )
                    }
                }

                Spacer(modifier = Modifier.size(24.dp))

                ItemProfile(
                    icon = R.drawable.logout,
                    title = "Logout",
                    end = true,
                    color = Color.Red,
                    onClick = {
                        showLogoutDialog = true
                    }
                )
                if (showLogoutDialog) {
                    AlertDialogCustom(
                        onDismissRequest = {
                            showLogoutDialog = false
                        },
                        onConfirmation = {
                            showLogoutDialog = false
                            navController.navigate(NameRouter.LOGIN.name)
                        },
                        dialogTitle = "Logout",
                        dialogText = "Are you sure you want to logout?",
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(navController = rememberNavController())
}