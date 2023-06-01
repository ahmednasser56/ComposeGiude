package com.programmingwithahmed.composegiude.effects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun LaunchedEffectScreenPager() {
    LaunchedEffectPagerContent()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun LaunchedEffectPagerContent() {

    val state = rememberPagerState()


    VerticalPager(
        state = state,
        pageCount = 3
    ) {

        when (it) {
            0 -> ScreenA()
            1 -> ScreenB()
            2 -> ScreenC()
        }

    }

    LaunchedEffect(key1 = true) {
        delay(3000)
        state.animateScrollToPage(1)
    }

}

@Composable
fun ScreenA() {
    Text(
        text = "A",
        fontSize = 22.sp,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow)
    )
}

@Composable
fun ScreenB() {
    Text(
        text = "B",
        fontSize = 22.sp,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
    )
}

@Composable
fun ScreenC() {
    Text(
        text = "C",
        fontSize = 22.sp,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    )
}