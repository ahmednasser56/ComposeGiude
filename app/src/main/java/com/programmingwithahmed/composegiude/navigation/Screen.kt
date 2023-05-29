package com.programmingwithahmed.composegiude.navigation

sealed class Screen(
    val route: String
){
    object FirstScreen: Screen("FirstScreen")
    //object SecondScreen: Screen("SecondScreen")
    object ThirdScreen: Screen("ThirdScreen")
}
