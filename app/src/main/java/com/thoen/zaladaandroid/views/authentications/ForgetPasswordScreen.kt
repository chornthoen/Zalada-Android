package com.thoen.zaladaandroid.views.authentications

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.component.ButtonBack
import com.thoen.zaladaandroid.component.CardSocialMedia
import com.thoen.zaladaandroid.component.CustomTextField
import com.thoen.zaladaandroid.component.FilledButtonCustom
import com.thoen.zaladaandroid.router.Main
import com.thoen.zaladaandroid.router.OTP
import com.thoen.zaladaandroid.router.Search
import com.thoen.zaladaandroid.router.Signup
import com.thoen.zaladaandroid.ui.theme.ZaladaAndroidTheme
import com.thoen.zaladaandroid.views.favorite.screen.ShapeIcons

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun ForgetPasswordScreen(
    navController: NavController,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Forget Password",
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        fontSize = 24.sp
                    )
                },
                navigationIcon = {
                    Box (
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)

                    ){
                        ButtonBack(
                            onClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                },
            )

        },

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .imePadding()
                .clickable(
                    onClick = {
                        keyboardController?.hide()
                    },
                    interactionSource = MutableInteractionSource(),
                    indication = null
                )


        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 8.dp)

            ) {
                BodyForgetPassword(navController)
            }
        }
    }
}

@Composable
fun BodyForgetPassword(
    navController: NavController
) {
    var username by rememberSaveable { mutableStateOf("") }

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.forget),
                contentDescription = null,
            )
        }
        Text(
            text = "Forget Password",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 32.sp,
            fontWeight = FontWeight.W500,
        )
        Box(
            modifier = Modifier
                .height(12.dp)
        )
        Text(
            text = "Please enter your email address. You will receive a link to create a new password via email.",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 12.sp,
            color = Color(0xFF828282),
            lineHeight = 16.sp
        )
        Box(
            modifier = Modifier
                .height(40.dp)
        )
        Text(
            text = "Email Address",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 16.sp,
            lineHeight = 12.sp

        )
        CustomTextField(
            keyboardType = KeyboardType.Email,
            label = "Email",
            value = username,
            onTextChanged = { username = it },
            passwordVisible = true
        )
        Box(
            modifier = Modifier
                .height(40.dp)
        )
        FilledButtonCustom(
            onClick = {
                navController.navigate(OTP.route)
            },
            text = "Continue",
        )
        Box(
            modifier = Modifier
                .height(16.dp)
        )


    }
}


@Preview
@Composable
fun PreviewForgetPasswordScreen() {
    ZaladaAndroidTheme {
        ForgetPasswordScreen(navController = rememberNavController())
    }
}