package com.programmingwithahmed.composegiude.custom_modifier

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Stable
fun Modifier.blueLight() = then(Modifier.shadow(8.dp, spotColor = Color.Blue))