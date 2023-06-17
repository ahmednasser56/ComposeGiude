package com.programmingwithahmed.composegiude.onboard.onboard.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.programmingwithahmed.composegiude.onboard.data.collectAsEffect
import com.programmingwithahmed.composegiude.onboard.home.route.navigateToHome
import com.programmingwithahmed.composegiude.onboard.onboard.viewModel.OnboardViewModel


@Composable
fun Onboard(
    navHostController: NavHostController,
    viewModel: OnboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.onboardUIState.collectAsStateWithLifecycle()

    viewModel.navigateToHome.collectAsEffect{
        navHostController.navigateToHome()
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