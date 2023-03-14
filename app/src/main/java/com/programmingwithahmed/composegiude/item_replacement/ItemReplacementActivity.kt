package com.programmingwithahmed.composegiude.item_replacement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

@OptIn(ExperimentalFoundationApi::class)
class ItemReplacementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGiudeTheme {

                var items by remember {
                    mutableStateOf(
                        listOf(
                            "Kotlin",
                            "Java",
                            "Python",
                            "Go",
                            "C++"
                        )
                    )
                }

                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {

                    items(items.size) {

                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.LightGray.copy(alpha = 0.2f))
                                .padding(16.dp)
                                .animateItemPlacement(
                                    animationSpec = tween(durationMillis = 1000)
                                ),

                            text = "I love ${items[it]}"
                        )

                    }

                    item {
                        Button(modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp), onClick = { items = items.shuffled()}) {

                            Text(text = "Shuffle")
                        }
                    }
                }
            }
        }
    }
}