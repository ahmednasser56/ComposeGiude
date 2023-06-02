package com.programmingwithahmed.composegiude.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.programmingwithahmed.composegiude.R


@Composable
fun AnimationAnimatedVisibilityScreen() {
    AnimationAnimatedVisibilityContent()
}

@Composable
private fun AnimationAnimatedVisibilityContent() {

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

        AnimatedVisibility(imageVisibilityState) {

            Image(
                painter = painterResource(id = R.drawable.me),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CutCornerShape(16.dp)),
                contentScale = ContentScale.FillWidth
            )

        }

    }
}