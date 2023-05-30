package com.programmingwithahmed.composegiude.flow_layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class FlowLayoutActivity : AppCompatActivity() {

    private val names = listOf("Ahmed", "Ali", "Ramadan", "Mostafa", "Ibrahim")

    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                FlowRow(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start)
                ) {
                    names.forEach {
                        ColorfulCard(text = it)
                    }
                    names.forEach {
                        ColorfulCard(text = it)
                    }
                    names.forEach {
                        ColorfulCard(text = it)
                    }
                }
            }
        }
    }


    @Composable
    fun ColorfulCard(text: String) {

        val colors = listOf(Color.LightGray, Color.Green, Color.Blue, Color.Red, Color.Yellow)

        Text(
            text = text,
            fontSize = 20.sp,
            modifier = Modifier
                .clip(CutCornerShape(8.dp))
                .background(color = colors.random())
                .padding(8.dp)
        )

    }

}