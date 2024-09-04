package com.thoen.zaladaandroid.router

interface Destinations {
    val route: String
}

object Login : Destinations {
    override val route = "Login"
}

object Signup : Destinations {
    override val route = "Signup"
}

object Main : Destinations {
    override val route = "Main"
}

object Cart : Destinations {
    override val route = "Cart"
}

object Home : Destinations {
    override val route = "Home"
}

object DetailProduct : Destinations {
    override val route = "DetailProduct"
}

object Search : Destinations {
    override val route = "Search"
}

object Favorite : Destinations {
    override val route = "Favorite"
}

object ProductAll : Destinations {
    override val route = "ProductAll"
}

object ForgetPassword : Destinations {
    override val route = "ForgetPassword"
}

object OTP : Destinations {
    override val route = "OTP"
}

object CreatePassword : Destinations {
    override val route = "CreatePassword"
}