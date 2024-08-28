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