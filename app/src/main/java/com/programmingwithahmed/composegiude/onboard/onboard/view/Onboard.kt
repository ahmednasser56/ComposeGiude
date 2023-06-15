package com.programmingwithahmed.composegiude.onboard.onboard.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.programmingwithahmed.composegiude.onboard.data.collectAsEffect
import com.programmingwithahmed.composegiude.onboard.onboard.route.navigateToOnboard
import com.programmingwithahmed.composegiude.onboard.onboard.viewModel.OnboardViewModel


@Composable
fun Onboard(
    navHostController: NavHostController,
    viewModel: OnboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.onboardUIState.collectAsState()


    viewModel.navigateToHome.collectAsEffect{
        //navHostController.navigateToOnboard()
    }

    OnboardContent(
        onboardUIState = uiState,
        onPagerCurrentPageChanged = viewModel::onPageChanged,
        onFinishClicked = viewModel::onFinishClicked
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OnboardContent(
    onboardUIState: OnboardUIState,
    onPagerCurrentPageChanged: (Int) -> Unit,
    onFinishClicked: () -> Unit
) {

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            pageCount = onboardUIState.onboardItems.size,
            state = pagerState,
            modifier = Modifier.weight(10f)
        ) {
            OnboardPage(onboardItem = onboardUIState.onboardItems[it])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = onboardUIState.onboardItems.size,
            modifier = Modifier.weight(1f)
        )

        AnimatedVisibility(
            onboardUIState.showFinishButton,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Button(
                onClick = onFinishClicked, modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(text = "Finish")
            }
        }


        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect {
                onPagerCurrentPageChanged(it)
            }
        }
    }

}