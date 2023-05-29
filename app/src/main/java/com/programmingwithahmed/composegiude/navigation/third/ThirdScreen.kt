package com.programmingwithahmed.composegiude.navigation.third

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun ThirdScreen(navHostController: NavHostController) {

    ThirdContent {
        navHostController.popBackStack()
    }
}

@Composable
private fun ThirdContent(onBackClicked: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Third Screen", fontSize = 48.sp)


        Button(onClick = onBackClicked) {
            Text(text = "Back")
        }
    }

}


@Preview
@Composable
fun ThirdContentPreview() {
    ThirdContent() {}
}