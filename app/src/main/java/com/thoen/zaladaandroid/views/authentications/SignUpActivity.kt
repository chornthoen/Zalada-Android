package com.thoen.zaladaandroid.views.authentications


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.R
import com.thoen.zaladaandroid.component.CardSocialMedia
import com.thoen.zaladaandroid.component.CustomTextField
import com.thoen.zaladaandroid.component.FilledButtonCustom
import com.thoen.zaladaandroid.ui.theme.ZaladaAndroidTheme

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun SignUpScreen(
    navController: NavController,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        modifier = Modifier.fillMaxSize()
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
                    .background(Color(0xFFFFFFFF))
                    .padding(horizontal = 8.dp)

            ) {
                BodySignUp(navController)
            }
        }
    }
}

@Composable
fun BodySignUp(
    navController: NavController
) {
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        Box(
            modifier = Modifier
                .height(20.dp)
        )
        Text(
            text = "Create your new\naccount.",
            modifier = Modifier.padding(16.dp),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 40.sp
        )
        Box(
            modifier = Modifier
                .height(12.dp)
        )
        Text(
            text = "Full Name",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 16.sp,
            lineHeight = 12.sp

        )
        CustomTextField(
            keyboardType = KeyboardType.Text,
            label = "Full Name",
            value = username,
            onTextChanged = { username = it },
            passwordVisible = true
        )
        Box(
            modifier = Modifier
                .height(12.dp)
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
            value = email,
            onTextChanged = { email = it },
            passwordVisible = true
        )
        Box(
            modifier = Modifier
                .height(12.dp)
        )
        Text(
            text = "Password",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 16.sp,
            lineHeight = 12.sp
        )
        CustomTextField(
            keyboardType = KeyboardType.Password,
            label = "Password",
            value = password,
            onTextChanged = { password = it },
        )
        Box(
            modifier = Modifier
                .height(16.dp)
        )
        FilledButtonCustom(
            onClick = {
                keyboardController?.hide()

            },
            text = "Sign Up",
        )
        Box(
            modifier = Modifier
                .height(16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {

            Box(
                modifier = Modifier
                    .height(1.dp)
                    .width(100.dp)
                    .background(Color(0xFFE0E0E0))
                    .weight(1f)
            )
            Text(
                text = "OR",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .width(100.dp)
                    .background(Color(0xFFE0E0E0))
                    .weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .height(8.dp)
        )
        CardSocialMedia(
            text = "Continue with Google",
            onClick = {},
            icon = R.drawable.google
        )
        CardSocialMedia(
            text = "Continue with Facebook",
            onClick = {},
            icon = R.drawable.facebook
        )
        Box(
            modifier = Modifier
                .height(16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 16.sp,
                lineHeight = 12.sp
            )
            TextButton(
                onClick = {
                    navController.popBackStack()
                },
                shape = RoundedCornerShape(8.dp),

                ) {
                Text(
                    text = "Log In",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    textDecoration = TextDecoration.Underline
                )
            }
        }


    }
}

@Preview
@Composable
fun GreetingPreview() {
    ZaladaAndroidTheme {
        SignUpScreen(navController = rememberNavController())
    }

}

