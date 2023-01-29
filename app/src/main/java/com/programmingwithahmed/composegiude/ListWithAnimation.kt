package com.programmingwithahmed.composegiude

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class ListWithAnimation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGiudeTheme {
                ListScreen()
            }
        }
    }
}

@Composable
fun ListScreen() {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .background(color = Color.White)
    ) {
        items(20) {
            MessageCard()
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultScreenPreview() {
    ComposeGiudeTheme {
        ListScreen()
    }
}