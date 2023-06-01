package com.programmingwithahmed.composegiude.effects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun LaunchedEffectScreenDerivedState() {
    LaunchedEffectDerivedStateContent()
}

@Composable
private fun LaunchedEffectDerivedStateContent() {

    var counterValue by remember { mutableStateOf(0) }
    val counterColor by remember {
        derivedStateOf {
            if (counterValue % 2 == 0) Color.Blue
            else Color.Red
        }
    }

    Text(
        text = counterValue.toString(),
        color = counterColor,
        fontSize = 22.sp,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow)
    )

    LaunchedEffect(key1 = true) {
        while (true) {
            delay(1000)
            counterValue++
        }
    }

}