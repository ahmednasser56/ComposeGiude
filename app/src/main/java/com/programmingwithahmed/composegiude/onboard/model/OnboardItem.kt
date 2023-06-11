package com.programmingwithahmed.composegiude.onboard.model

import androidx.annotation.DrawableRes

data class OnboardItem(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
)
