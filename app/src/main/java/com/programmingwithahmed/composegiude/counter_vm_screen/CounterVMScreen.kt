package com.programmingwithahmed.composegiude.counter_vm_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.programmingwithahmed.composegiude.ui.theme.PrimaryTextColor
import com.programmingwithahmed.composegiude.ui.theme.Rubik


@Composable
fun CounterVMScreen(
    counterViewModel: CounterViewModel = hiltViewModel()
) {
    val counterState by counterViewModel.counterState.collectAsState()

    CounterVMContent(
        counterState.toString(),
        onPlusClicked =  counterViewModel::increaseCounter ,
        onMinusClicked = { counterViewModel.decreaseCounter() }
    )
}


@Composable
private fun CounterVMContent(counter: String, onPlusClicked: () -> Unit, onMinusClicked: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            counter,
            color = PrimaryTextColor,
            fontFamily = Rubik,
            fontSize = 100.sp,
            fontWeight = FontWeight.Medium
        )

        Row {

            Button(onClick = onMinusClicked) {
                Text(
                    "-",
                    fontSize = 50.sp,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = onPlusClicked) {
                Text(
                    "+",
                    fontSize = 50.sp,
                )
            }
        }

    }

}


@Preview
@Composable
fun CounterVMContentPreview() {
    CounterVMContent("0", {}, {})
}