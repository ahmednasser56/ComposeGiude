package com.programmingwithahmed.composegiude.shimmer

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShimmer() {

    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition()

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )

    Column {
        repeat(5){
            ShimmerItem(brush = brush)
        }
    }
}


@Composable
fun ShimmerItem(brush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(brush))
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column( modifier = Modifier.weight(1.0f), verticalArrangement = Arrangement.Center) {

            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.6f)
                .clip(RoundedCornerShape(8.dp))
                .background(brush))

            Spacer(modifier = Modifier.height(8.dp))

            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(brush))
        }

    }
}


@Composable
@Preview(showBackground = true)
fun AnimatedShimmerPreview(){
    AnimatedShimmer()
}