package com.programmingwithahmed.composegiude.animation

import androidx.compose.animation.*
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
fun AnimationNestedAnimatedVisibilityScreen() {
    AnimationNestedAnimatedVisibilityContent()
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimationNestedAnimatedVisibilityContent() {

    var imageVisibilityState by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { imageVisibilityState = !imageVisibilityState }
        ) {
            Text(text = "Toggle Button Visibility")
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(
            imageVisibilityState,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = Color.Yellow)

                    .padding(16.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Arrow Icon",
                    modifier = Modifier
                        .animateEnterExit(
                            enter = slideInVertically { it*2 },
                            exit = slideOutVertically { -it*2 }
                        )
                )

            }
        }

    }
}