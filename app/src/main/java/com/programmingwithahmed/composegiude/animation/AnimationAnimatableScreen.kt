package com.programmingwithahmed.composegiude.animation

import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.programmingwithahmed.composegiude.ui.theme.Purple700
import kotlinx.coroutines.delay


@Composable
fun AnimationAnimatableScreen() {
    AnimationAnimatableContent()
}

@Composable
private fun AnimationAnimatableContent() {

    val color = remember { Animatable(Color.Yellow) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(128.dp)
                .clip(CutCornerShape(24.dp))
                .background(color.value),
        ) {}

        LaunchedEffect(key1 = true) {
            val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Cyan)
            colors.forEach {
                color.animateTo(
                    it,
                    animationSpec = tween(2000)
                )
                delay(2000)
            }
        }
    }
}