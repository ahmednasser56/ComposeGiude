package com.programmingwithahmed.composegiude.pick_image

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.programmingwithahmed.composegiude.multi_permission.view.MultiPermissionScreen
import com.programmingwithahmed.composegiude.permission.view.PermissionScreen
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class PickImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                PickImageScreen()
            }
        }
    }

}