package com.programmingwithahmed.composegiude.navigation.second.route

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.programmingwithahmed.composegiude.navigation.second.view.SecondScreen

private const val ROUTE = "secondScreen"

fun NavHostController.navigateToSecond(name: String) {
    navigate("$ROUTE/$name")
}

fun NavGraphBuilder.secondRoute(navHostController: NavHostController) {

    composable(
        route = "$ROUTE/{${SecondArgs.NAME}}",
        arguments = listOf(
         navArgument(SecondArgs.NAME){NavType.StringType}
        )
    ) { SecondScreen(navHostController) }

}

class SecondArgs(savedStateHandle: SavedStateHandle) {

    val name: String = checkNotNull(savedStateHandle[NAME])

    companion object {
        const val NAME = "name"
    }

}