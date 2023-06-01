package com.programmingwithahmed.composegiude.webview

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                Browser()
            }
        }
    }

}