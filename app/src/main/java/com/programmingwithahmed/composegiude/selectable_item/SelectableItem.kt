package com.programmingwithahmed.composegiude.selectable_item

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.ui.theme.Purple700

@Composable
fun SelectableItem(
    modifier: Modifier = Modifier,

    selected: Boolean,
    isExpanded: Boolean,

    title: String,
    titleColor: Color = Purple700,
    titleSize: TextUnit = 22.sp,
    titleWeight: FontWeight = FontWeight.Medium,

    subTitle: String,
    subTitleColor: Color = Color.Black,
    subTitleSize: TextUnit = 18.sp,
    subTitleWeight: FontWeight = FontWeight.Light,

    borderWidth: Dp = 1.dp,
    borderColor: Color = Purple700,
    borderShape: Shape = RoundedCornerShape(16.dp),

    iconColor: Color = Purple700,

    disableAlpha: Float = .3f,

    onClick: () -> Unit,
    onIconClicked: () -> Unit
) {

    val scale = remember { Animatable(initialValue = 1f) }

    Column(
        modifier = modifier
            .scale(scale.value)
            .border(
                width = borderWidth,
                color = if (selected) borderColor else borderColor.copy(alpha = disableAlpha),
                shape = borderShape
            )
            .clip(borderShape)
            .clickable { onClick() }
            .padding(8.dp)

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = title, style = TextStyle(
                    color = if (selected) titleColor else titleColor.copy(alpha = disableAlpha),
                    fontSize = titleSize,
                    fontWeight = titleWeight
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(onClick = { onIconClicked() }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    tint = if (selected) iconColor else iconColor.copy(alpha = disableAlpha)
                )
            }
        }

        AnimatedVisibility(isExpanded) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = subTitle, style = TextStyle(
                    color = if (selected) subTitleColor else subTitleColor.copy(alpha = disableAlpha),
                    fontSize = subTitleSize,
                    fontWeight = subTitleWeight
                )
            )
        }
    }

    LaunchedEffect(key1 = selected) {
        scale.animateTo(targetValue = .5f, animationSpec = tween(durationMillis = 50))
        scale.animateTo(
            targetValue = 1f,
            animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessHigh)
        )
    }

}

@Composable
@Preview
fun LoadingAnimationPreview() {
    SelectableItem(
        selected = true,
        isExpanded = true,
        title = "Lorem Ipsum",
        subTitle = "This is the subtitle of the card",
        onIconClicked = {

        },
        onClick = {

        }
    )
}