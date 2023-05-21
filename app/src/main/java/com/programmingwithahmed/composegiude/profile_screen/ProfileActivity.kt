package com.programmingwithahmed.composegiude.profile_screen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                ProfileVMScreen()
            }
        }
    }

}