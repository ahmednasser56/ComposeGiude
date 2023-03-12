package com.programmingwithahmed.composegiude.circular_image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.programmingwithahmed.composegiude.R
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class CircularImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGiudeTheme {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularImage(R.drawable.ram, 100, 4, Color.White)
                }

            }
        }
    }
}