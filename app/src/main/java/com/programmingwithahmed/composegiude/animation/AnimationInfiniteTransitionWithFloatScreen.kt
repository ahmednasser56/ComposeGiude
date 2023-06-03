package com.programmingwithahmed.composegiude.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimationInfiniteTransitionWithFloatScreen() {
    AnimationInfiniteTransitionWithFloatContent()
}

@Composable
private fun AnimationInfiniteTransitionWithFloatContent() {

    val infiniteTransition = rememberInfiniteTransition()
    val width by infiniteTransition.animateFloat(
        initialValue = 50f,
        targetValue = 200f,
        animationSpec = InfiniteRepeatableSpec(
            tween(2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    val alpha by infiniteTransition.animateFloat(
        initialValue = .1f,
        targetValue = 1f,
        animationSpec = InfiniteRepeatableSpec(
            tween(2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .alpha(alpha)
                .background(Color.Red)
                .width(width.dp)
                .height(200.dp)
        )

    }
}