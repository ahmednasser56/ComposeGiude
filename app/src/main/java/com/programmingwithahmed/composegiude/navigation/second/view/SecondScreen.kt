package com.programmingwithahmed.composegiude.navigation.second.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.programmingwithahmed.composegiude.navigation.Screen
import com.programmingwithahmed.composegiude.navigation.second.viewModel.SecondViewModel


@Composable
fun SecondScreen(
    navHostController: NavHostController,
    viewModel: SecondViewModel = hiltViewModel()
) {
    val name by viewModel.name.collectAsState()

    SecondContent(name = name) {
        navHostController.navigate(Screen.ThirdScreen.route)
    }
}

@Composable
private fun SecondContent(name: String, onNextClicked: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Second Screen", fontSize = 48.sp)

        Text(text = "Hello $name", fontSize = 48.sp)


        Button(onClick = onNextClicked) {
            Text(text = "Next")
        }
    }

}


@Preview
@Composable
fun SecondContentPreview() {
    SecondContent("") {}
}