package com.thoen.zaladaandroid.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.views.authentications.LoginScreen
import com.thoen.zaladaandroid.views.authentications.SignUpScreen
import com.thoen.zaladaandroid.views.cart.CartScreen
import com.thoen.zaladaandroid.views.home.HomeScreen
import com.thoen.zaladaandroid.views.main.MainScreen

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
            composable(NameRouter.MAIN.name) {
                MainScreen(navController)
            }
            composable(NameRouter.HOME.name) {
                HomeScreen(navController)
            }
            composable(NameRouter.CART.name) {
                CartScreen(navController)
            }
        }
    )
}