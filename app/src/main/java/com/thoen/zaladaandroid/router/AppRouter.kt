package com.thoen.zaladaandroid.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.views.authentications.LoginScreen
import com.thoen.zaladaandroid.views.authentications.SignUpScreen

@Composable
fun AppRouter() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NameRouter.LOGIN.name,
        builder = {
            composable(NameRouter.LOGIN.name) {
                LoginScreen(navController)
            }
            composable(NameRouter.SIGNUP.name) {
                SignUpScreen(navController)
            }
        }
    )
}