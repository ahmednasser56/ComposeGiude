package com.programmingwithahmed.composegiude.search

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme

class SearchActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                SearchMainScreen(searchViewModel = searchViewModel)
            }
        }
    }

}