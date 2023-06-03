package com.programmingwithahmed.composegiude.animation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                AnimationInfiniteTransitionScreen()
            }
        }
    }

}