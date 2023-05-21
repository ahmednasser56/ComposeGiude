package com.programmingwithahmed.composegiude.counter_vm_screen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class CounterVmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                CounterVMScreen()
            }
        }
    }

}