package com.programmingwithahmed.composegiude

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestScreen() {
    TestContent()
}

@Composable
private fun TestContent() {

    var counter by remember { mutableStateOf(1) }


    Column (modifier = Modifier
    .fillMaxSize().background(color = Color.White),){

        Button(onClick = { counter++ }) {
            Text(text = "Update Counter One")
        }

        Text(text = counter.toString())

        AnimatedVisibility(visible = counter < 5 || counter > 10) {
            AdditionalContent()
        }
    }
}

@Composable
private fun AdditionalContent() {

    var counter2 by remember { mutableStateOf(1) }

    Column {

        Button(onClick = { counter2++ }) {
            Text(text = "Update Counter Two")
        }

        Text(text = counter2.toString())
    }
}

@Preview
@Composable
fun TestPreview() {
    TestContent()
}