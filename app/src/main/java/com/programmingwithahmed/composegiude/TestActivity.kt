package com.programmingwithahmed.composegiude

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.programmingwithahmed.composegiude.TestScreen
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                TestScreen()
            }
        }
    }

}