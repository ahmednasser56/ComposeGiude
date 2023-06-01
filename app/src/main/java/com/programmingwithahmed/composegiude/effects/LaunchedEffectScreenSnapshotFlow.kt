package com.programmingwithahmed.composegiude.effects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun LaunchedEffectScreenSnapshotFlow() {
    LaunchedEffectSnapshotFlowContent()
}

@Composable
private fun LaunchedEffectSnapshotFlowContent() {

    val listState = rememberLazyListState()

    var scrollState by remember { mutableStateOf(-1) }

    var buttonsVisibilityState by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = listState
        ) {
            items(50) {
                Text(
                    text = "Text $it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Gray)
                        .padding(16.dp)
                )
            }
        }

        if (buttonsVisibilityState)
            Button(
                onClick = { scrollState = 1 }, modifier = Modifier
                    .align(Alignment.TopCenter)
            ) {
                Text(text = "Go Down")
            }


        if (buttonsVisibilityState)
            Button(
                onClick = { scrollState = 0 }, modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                Text(text = "Go Up")
            }

        LaunchedEffect(key1 = scrollState) {

            if (scrollState == -1) return@LaunchedEffect

            if (scrollState == 0) listState.animateScrollToItem(0)

            if (scrollState == 1) listState.animateScrollToItem(49)

            snapshotFlow { listState.isScrollInProgress }.collect {
                buttonsVisibilityState = !it
            }

        }

        LaunchedEffect(key1 = listState) {

            snapshotFlow { listState.isScrollInProgress }.collect {
                buttonsVisibilityState = !it
            }

        }

    }
}