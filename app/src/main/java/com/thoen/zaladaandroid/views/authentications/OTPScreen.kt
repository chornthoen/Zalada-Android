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
import com.droidDevOs.verifyswift.base.SwiftAuth
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.component.ButtonBack
import com.thoen.zaladaandroid.component.CardSocialMedia
import com.thoen.zaladaandroid.component.CustomTextField
import com.thoen.zaladaandroid.component.FilledButtonCustom
import com.thoen.zaladaandroid.router.CreatePassword
import com.thoen.zaladaandroid.router.Main
import com.thoen.zaladaandroid.router.Search
import com.thoen.zaladaandroid.router.Signup
import com.thoen.zaladaandroid.ui.theme.ZaladaAndroidTheme
import com.thoen.zaladaandroid.views.favorite.screen.ShapeIcons

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun OTPScreen(
    navController: NavController,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "OTP Verification",
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
                BodyOTPScreen(navController)
            }
        }
    }
}

@Composable
fun BodyOTPScreen(
    navController: NavController
) {
    var otpValue by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current


    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.otp),
                contentDescription = null,
            )
        }
        Text(
            text = "OTP Verification",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 32.sp,
            fontWeight = FontWeight.W500,
        )
        Box(
            modifier = Modifier
                .height(12.dp)
        )
        Text(
            text = "Enter the OTP code sent to your email address",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 12.sp,
            color = Color(0xFF828282),
            lineHeight = 16.sp
        )
        Box(
            modifier = Modifier
                .height(40.dp)
        )
        SwiftAuth(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp),
            otpValue = otpValue,
            onOtpTextChange = { otpValue = it },
            onCompletedNumbers = {
                println("Completed Numbers: $it")
                keyboardController?.hide()
            },
        )


        Box(
            modifier = Modifier
                .height(40.dp)
        )
        FilledButtonCustom(
            onClick = {
                navController.navigate(CreatePassword.route)
            },
            text = "Verify",
        )
        Box(
            modifier = Modifier
                .height(16.dp)
        )


    }
}



@Preview
@Composable
fun PreviewOTPScreen() {
    ZaladaAndroidTheme {
        OTPScreen(navController = rememberNavController())
    }
}