package com.programmingwithahmed.composegiude.box_with_constraints

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.navigation.compose.rememberNavController
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoxWithConstraintsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                BoxWithConstraintsScreen()
            }
        }
    }

}