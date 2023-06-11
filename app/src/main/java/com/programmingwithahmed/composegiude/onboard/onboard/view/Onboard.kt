package com.programmingwithahmed.composegiude.onboard.onboard.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
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
import com.programmingwithahmed.composegiude.onboard.onboard.viewModel.OnboardViewModel


@Composable
fun Onboard(
    navHostController: NavHostController,
    viewModel: OnboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.onboardUIState.collectAsState()

    SecondContent(name = name) {
        navHostController.navigate(Screen.ThirdScreen.route)
    }
}

@Composable
private fun OnboardContent(onboardUIState: OnboardUIState, onNextClicked: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        HorizontalPager(pageCount = onboardUIState.onboardItems.size) {
            
        }
        Text(text = "Second Screen", fontSize = 48.sp)

        Text(text = "Hello $name", fontSize = 48.sp)


        Button(onClick = onNextClicked) {
            Text(text = "Next")
        }
    }

}


@Preview
@Composable
fun OnboardContentPreview() {
    OnboardContent("") {}
}