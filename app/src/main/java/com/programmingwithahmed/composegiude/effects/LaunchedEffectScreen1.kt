package com.programmingwithahmed.composegiude.effects

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay


@Composable
fun LaunchedEffectScreen1() {
    LaunchedEffectContent()
}

@Composable
private fun LaunchedEffectContent() {

    var state by remember { mutableStateOf(0) }
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Button(onClick = { state++ }) {
            Text(text = "Click Me")
        }

    }

    LaunchedEffect(key1 = state) {
        //while (true) {
        //   delay(5000)
        Toast.makeText(context, "Hello $state", Toast.LENGTH_SHORT).show()
        //   }
    }

}


@Preview
@Composable
fun LaunchedEffectContentPreview() {
    LaunchedEffectContent()
}