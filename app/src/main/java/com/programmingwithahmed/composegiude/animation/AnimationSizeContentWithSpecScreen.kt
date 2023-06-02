package com.programmingwithahmed.composegiude.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimationSizeContentWithSpecScreen() {
    AnimationSizeContentWithSpecContent()
}

@Composable
private fun AnimationSizeContentWithSpecContent() {

    var textState by remember { mutableStateOf("Hi") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { textState += " Hi" }
        ) {
            Text(text = "Click Me")
        }

        Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = Color.Yellow)
                    .padding(16.dp)
            ) {
                Text(text = textState,    modifier = Modifier
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 1000,
                        )
                    )
                )
            }

    }
}