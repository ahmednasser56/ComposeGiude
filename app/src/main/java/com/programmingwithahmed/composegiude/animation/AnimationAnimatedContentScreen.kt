package com.programmingwithahmed.composegiude.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.R


@Composable
fun AnimationAnimatedContentScreen() {
    AnimationAnimatedContentContent()
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimationAnimatedContentContent() {

    var showImage by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { showImage = !showImage }
        ) {
            Text(text = "Click Me")
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedContent(targetState = showImage, transitionSpec = {
            scaleIn(animationSpec = tween(2000)) with scaleOut(tween(2000))
        }) {
            if (it) ScreenBody()
            else ScreenHeader()
        }

    }
}


@Composable
private fun ScreenHeader() {
    Text(
        text = "This is the header",
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
        modifier = Modifier
            .fillMaxWidth()

    )
}

@Composable
private fun ScreenBody() {
    Image(
        painter = painterResource(id = R.drawable.me),
        contentDescription = "Profile Image",
        modifier = Modifier
            .fillMaxWidth()
            .clip(CutCornerShape(16.dp)),
        contentScale = ContentScale.FillWidth
    )
}