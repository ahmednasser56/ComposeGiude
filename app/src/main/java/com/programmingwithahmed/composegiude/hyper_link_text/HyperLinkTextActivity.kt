package com.programmingwithahmed.composegiude.hyper_link_text

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class HyperLinkTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                Column(
                    modifier = Modifier.fillMaxSize().background(color = Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HyperlinkText("This text may go to Google or GitHub", hyperlinks = mapOf(
                        "Google" to "https://www.google.com",
                        "GitHub" to "https://github.com/"
                    ))
                }
            }
        }
    }

}