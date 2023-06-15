package com.programmingwithahmed.composegiude.onboard.onboard.route

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.programmingwithahmed.composegiude.onboard.onboard.view.Onboard

private const val ROUTE = "onboard"

fun NavHostController.navigateToOnboard() {
    navigate(ROUTE)
}

fun NavGraphBuilder.onboardRoute(navHostController: NavHostController) {

    composable(route = ROUTE) { Onboard(navHostController) }

}