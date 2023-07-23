package com.programmingwithahmed.composegiude.md3_app_bar

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.programmingwithahmed.composegiude.multi_permission.view.MultiPermissionScreen
import com.programmingwithahmed.composegiude.permission.view.PermissionScreen
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class Md3TopAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                Md3TopAppBarScreen()
            }
        }
    }

}