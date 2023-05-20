package com.programmingwithahmed.composegiude.counter_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.ui.theme.*

@Composable
fun CounterScreen() {
    var counter by remember { mutableStateOf(0) }
    CounterContent(
        counter.toString(),
        onPlusClicked = { counter++ },
        onMinusClicked = { counter-- }
    )
}


@Composable
private fun CounterContent(counter: String, onPlusClicked: () -> Unit, onMinusClicked: () -> Unit) {

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
fun CounterContentPreview() {
    CounterContent("0", {}, {})
}