package com.programmingwithahmed.composegiude.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.programmingwithahmed.composegiude.ui.theme.Purple700


@Composable
fun AnimationAnimateAsStateScreen() {
    AnimationAnimateAsStateContent()
}

@Composable
private fun AnimationAnimateAsStateContent() {

    var isSelected by remember { mutableStateOf(false) }

    val borderSize by animateDpAsState(targetValue = if (isSelected) 2.dp else 0.dp)
    val cardWidth by animateDpAsState(targetValue = if (isSelected) 256.dp else 128.dp)
    val iconColor by animateColorAsState(targetValue = if (isSelected) Purple700 else Color.Gray)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .width(cardWidth)
                .height(128.dp)
                .clip(CutCornerShape(24.dp))
                .clickable { isSelected = !isSelected },
            shape = CutCornerShape(24.dp),
            border = BorderStroke(borderSize, Purple700)

        ) {

            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notification Icon",
                modifier = Modifier.padding(32.dp),
                tint = iconColor
            )

        }

    }
}