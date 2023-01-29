package com.programmingwithahmed.composegiude.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route) {

        composable(route = BottomBarScreen.Home.route){
            BottomHomeScreen()
        }

        composable(route = BottomBarScreen.Profile.route){
            BottomProfileScreen()
        }

        composable(route = BottomBarScreen.Settings.route){
            BottomSettingScreen()
        }

    }

}