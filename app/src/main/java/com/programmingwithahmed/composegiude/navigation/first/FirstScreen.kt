package com.programmingwithahmed.composegiude.navigation.first

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
import com.programmingwithahmed.composegiude.navigation.second.route.navigateToSecond


@Composable
fun FirstScreen(navHostController: NavHostController) {

    FirstContent {
        navHostController.navigateToSecond("Ahmed")
    }
}

@Composable
private fun FirstContent(onNextClicked: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "First Screen", fontSize = 48.sp)


        Button(onClick = onNextClicked) {
            Text(text = "Next")
        }
    }

}


@Preview
@Composable
fun FirstContentPreview() {
    FirstContent() {}
}