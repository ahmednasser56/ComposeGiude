package com.programmingwithahmed.composegiude.animated_splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SplashNavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = "Splash") {

        composable(route = "Splash"){
            AnimatedSplashScreen(navHostController)
        }

        composable(route = "Home"){
            Box(modifier = Modifier.fillMaxSize().background(color = Color.White))
        }

    }

}