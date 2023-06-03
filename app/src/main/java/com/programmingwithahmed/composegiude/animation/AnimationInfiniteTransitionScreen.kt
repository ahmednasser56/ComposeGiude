package com.programmingwithahmed.composegiude.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AnimationInfiniteTransitionScreen() {
    AnimationInfiniteTransitionContent()
}

@Composable
private fun AnimationInfiniteTransitionContent() {

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Yellow,
        targetValue = Color.Cyan,
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

        ScreenHeader(backgroundColor = color)

    }
}

@Composable
private fun ScreenHeader(backgroundColor: Color) {
    Text(
        text = "This is the header",
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)

    )
}