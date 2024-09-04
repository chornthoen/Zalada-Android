package com.thoen.zaladaandroid.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thoen.zaladaandroid.views.authentications.CreatePasswordScreen
import com.thoen.zaladaandroid.views.authentications.ForgetPasswordScreen
import com.thoen.zaladaandroid.views.authentications.LoginScreen
import com.thoen.zaladaandroid.views.authentications.OTPScreen
import com.thoen.zaladaandroid.views.authentications.SignUpScreen
import com.thoen.zaladaandroid.views.cart.screen.CartScreen
import com.thoen.zaladaandroid.views.home.DetailsProductScreen
import com.thoen.zaladaandroid.views.home.HomeScreen
import com.thoen.zaladaandroid.views.home.ProductAllScreen
import com.thoen.zaladaandroid.views.main.MainScreen
import com.thoen.zaladaandroid.views.search.screen.SearchScreen

@Composable
fun AppRouter() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Login.route,
        builder = {
            composable(Login.route) {
                LoginScreen(navController)
            }
            composable(Signup.route) {
                SignUpScreen(navController)
            }
            composable(Main.route) {
                MainScreen(navController)
            }
            composable(Home.route) {
                HomeScreen(navController)
            }
            composable(Cart.route) {
                CartScreen(navController)
            }
            composable(DetailProduct.route) {
                DetailsProductScreen(navController)
            }
            composable(Search.route) {
                SearchScreen(navController)
            }
            composable(ProductAll.route) {
                ProductAllScreen(navController)
            }
            composable(ForgetPassword.route) {
                ForgetPasswordScreen(navController)
            }
            composable(OTP.route) {
                OTPScreen(navController)
            }
            composable(CreatePassword.route) {
                CreatePasswordScreen(navController)
            }
        }
    )
}