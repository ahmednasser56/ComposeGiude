package com.programmingwithahmed.composegiude.animated_splash

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController) {

    var startAnimation by remember { mutableStateOf(false) }

    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect("Unit"){
        startAnimation = true
        Log.d("A7A", "AnimatedSplashScreen: ")
        delay(4000)
        navController.popBackStack()
        navController.navigate("Home")
    }

    SplashScreen(alphaAnim.value)
}


@Composable
fun SplashScreen(alpha: Float) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue), contentAlignment = Alignment.Center
    ) {

        Icon(
            modifier = Modifier
                .size(100.dp)
                .alpha(alpha),
            imageVector = Icons.Default.Email,
            contentDescription = "Logo Icon",
            tint = Color.White
        )

    }

}