package com.programmingwithahmed.composegiude.system_colors

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class SystemColorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
             val systemUiColors = rememberSystemUiController()
                systemUiColors.setSystemBarsColor(color = Color.Blue)
                systemUiColors.setNavigationBarColor(color = Color.Red)
            }
        }
    }

}