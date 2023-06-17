package com.programmingwithahmed.composegiude.onboard.home.route

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.programmingwithahmed.composegiude.onboard.home.view.Home

const val ROUTE = "home"

fun NavHostController.navigateToHome() {
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(navHostController: NavHostController) {

    composable(route = ROUTE) { Home(navHostController) }

}