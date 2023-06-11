package com.programmingwithahmed.composegiude.onboard.onboard.view

import com.programmingwithahmed.composegiude.onboard.model.OnboardItem

data class OnboardUIState(
    val onboardItems: List<OnboardItem> = emptyList(),
    var showFinishButton: Boolean = false
)