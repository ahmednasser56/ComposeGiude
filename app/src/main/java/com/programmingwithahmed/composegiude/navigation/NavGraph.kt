package com.programmingwithahmed.composegiude.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.programmingwithahmed.composegiude.navigation.first.FirstScreen
import com.programmingwithahmed.composegiude.navigation.second.route.secondRoute
import com.programmingwithahmed.composegiude.navigation.third.ThirdScreen

@Composable
fun NavGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screen.FirstScreen.route) {

        composable(route = Screen.FirstScreen.route) { FirstScreen(navHostController) }

        secondRoute(navHostController)

        composable(route = Screen.ThirdScreen.route) { ThirdScreen(navHostController) }

    }

}