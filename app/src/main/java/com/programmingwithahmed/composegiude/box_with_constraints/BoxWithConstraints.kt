package com.programmingwithahmed.composegiude.box_with_constraints

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxWithConstraintsScreen() {

    BoxWithConstraintsContent()
}

@Composable
private fun BoxWithConstraintsContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card()

        Spacer(modifier = Modifier.height(100.dp))
        Column(
            modifier = Modifier
                .width(150.dp),
        ) {
            Card()
        }

    }
}

@Composable
private fun Card() {

    BoxWithConstraints(
        modifier = Modifier
            .background(color = Color.Yellow),
    ) {

        val boxWithConstraintsScope = this

        Column {

            if (boxWithConstraintsScope.maxWidth >= 200.dp) {
                Text(text = "This will appear if max width is greater than 200 dp")
            }
            Text(text = "MinWidth = ${boxWithConstraintsScope.minWidth}, MaxWidth = ${boxWithConstraintsScope.maxWidth}")
        }
    }

}

@Preview
@Composable
fun BoxWithConstraintsPreview() {
    BoxWithConstraintsContent()
}