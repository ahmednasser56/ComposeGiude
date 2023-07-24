package com.programmingwithahmed.composegiude.marquee

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MarqueeScreen() {
    MarqueeContent()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MarqueeContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ahmed Nasser Ramadan Mostafa Abdulrahman Ahmed Mohammed Ali Yousef",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.background(color = Color.Red).padding(vertical = 16.dp)
                .basicMarquee()
        )

    }
}

@Preview
@Composable
fun MarqueePreview() {
    MarqueeContent()
}