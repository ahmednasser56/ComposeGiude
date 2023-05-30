package com.programmingwithahmed.composegiude.navigation.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.programmingwithahmed.composegiude.navigation.second.route.navigateToSecond


@Composable
fun FirstScreen(
    navHostController: NavHostController,
    viewModel: FirstViewModel = hiltViewModel()
) {

    val nameState = viewModel.name.collectAsState()

    FirstContent(
        name = nameState.value,
        onNextClicked = {
            navHostController.navigateToSecond(nameState.value)
        },
        onNameChanged = viewModel::onNameChanged
    )
}

@Composable
private fun FirstContent(
    name: String,
    onNextClicked: () -> Unit,
    onNameChanged: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "First Screen", fontSize = 48.sp)

       TextField(
            value = name, onValueChange = onNameChanged,

            modifier = Modifier
                .fillMaxWidth(),
            placeholder = { Text(text = "Please enter your name.")}
        )

        Button(onClick = onNextClicked) {
            Text(text = "Next")
        }
    }

}


@Preview
@Composable
fun FirstContentPreview() {
    FirstContent("", onNextClicked = {}, onNameChanged = {})
}