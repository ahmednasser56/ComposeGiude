package com.programmingwithahmed.composegiude.lottie

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.programmingwithahmed.composegiude.R

@Composable
fun LottieScreen() {
    LottieContent()
}

@Composable
private fun LottieContent() {

    val lottieComposition by
    rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.lottie_anim))

    var isPlaying by remember { mutableStateOf(true) }

    val progress by animateLottieCompositionAsState(
        composition = lottieComposition,
        isPlaying = isPlaying
    )

    LaunchedEffect(key1 = progress){
        if (progress == 1f) isPlaying = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(
            composition = lottieComposition,
            progress = { progress },
            modifier = Modifier
                .size(200.dp),
        )

        AnimatedVisibility(visible = progress == 1f) {
            IconButton(onClick = { isPlaying = true }) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh Icon",  modifier = Modifier
                    .size(50.dp))
            }
        }


    }
}

@Preview
@Composable
fun LottiePreview() {
    LottieContent()
}