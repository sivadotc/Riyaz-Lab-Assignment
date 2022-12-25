package com.example.riyazlabassignment

sealed class Screen(val route: String){
    object HomeScreen : Screen("home")
    object AllLabScreen: Screen("alllab")
    object ProfileScreen: Screen("profile")
}
