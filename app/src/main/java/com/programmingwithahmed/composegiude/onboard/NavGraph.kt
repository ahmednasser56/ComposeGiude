package com.programmingwithahmed.composegiude.onboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.programmingwithahmed.composegiude.navigation.first.FirstScreen
import com.programmingwithahmed.composegiude.navigation.second.route.secondRoute
import com.programmingwithahmed.composegiude.navigation.third.ThirdScreen
import com.programmingwithahmed.composegiude.onboard.onboard.route.onboardRoute

@Composable
fun NavGraph(navHostController: NavHostController, start: String) {

    NavHost(navController = navHostController, startDestination = start) {

        onboardRoute(navHostController)


    }

}