package com.programmingwithahmed.composegiude.loading_animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 30.dp,
    circleColor: Color = MaterialTheme.colors.primary,
    spaceBetweenCircles: Dp = 8.dp,
) {

    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    circles.forEachIndexed { index, animatable ->

        LaunchedEffect(key1 = animatable) {

            delay(index * 100L)

            animatable.animateTo(
                targetValue = 1f,

                animationSpec = infiniteRepeatable(

                    repeatMode = RepeatMode.Restart,

                    animation = keyframes {
                        durationMillis = 1200
                        0.0f at 0 with LinearOutSlowInEasing
                        1.0f at 300 with LinearOutSlowInEasing
                        0.0f at 600 with LinearOutSlowInEasing
                        0.0f at 1200 with LinearOutSlowInEasing
                    },
                    )
            )
        }

    }


    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(spaceBetweenCircles)) {

        circles.forEach {
            LoadingCircle(
                circleSize = circleSize,
                circleColor = circleColor,
                circleYPosition = it.value
            )
        }

    }


}

@Composable
private fun LoadingCircle(circleSize: Dp, circleColor: Color, circleYPosition: Float) {

    Box(
        modifier = Modifier
            .size(circleSize)
            .graphicsLayer {
                translationY = -circleYPosition * 60
            }
            .clip(CircleShape)
            .background(color = circleColor),
    )

}

@Composable
@Preview
fun LoadingAnimationPreview() {
    LoadingAnimation()
}