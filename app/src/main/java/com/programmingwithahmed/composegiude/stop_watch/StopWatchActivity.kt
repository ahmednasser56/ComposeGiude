package com.programmingwithahmed.composegiude.stop_watch

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.rememberNavController
import com.programmingwithahmed.composegiude.stop_watch.view.StopWatchScreen
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StopWatchActivity : AppCompatActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                StopWatchScreen()
            }
        }
    }

}