package com.programmingwithahmed.composegiude.effects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun LaunchedEffectScreenLazyColumn() {
    LaunchedEffectLazyColumnContent()
}

@Composable
private fun LaunchedEffectLazyColumnContent() {

    val listState = rememberLazyListState()

    var scrollState by remember { mutableStateOf(-1) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = listState
    ) {

        item {
            Button(onClick = { scrollState = 1 }) {
                Text(text = "Go Down")
            }
        }

        items(50) {
            Text(
                text = "Text $it",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray)
                    .padding(16.dp)
            )
        }

        item {
            Button(onClick = { scrollState = 0 }) {
                Text(text = "Go Up")
            }
        }

    }

    LaunchedEffect(key1 = scrollState) {

        if (scrollState == -1) return@LaunchedEffect

        if (scrollState == 0) listState.animateScrollToItem(0)

        if (scrollState == 1) listState.animateScrollToItem(49)

    }

}