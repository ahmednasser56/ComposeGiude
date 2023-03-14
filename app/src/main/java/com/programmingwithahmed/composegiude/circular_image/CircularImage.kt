package com.programmingwithahmed.composegiude.circular_image

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programmingwithahmed.composegiude.R

@Composable
fun CircularImage(imageId: Int, size: Int, borderWidth: Int, borderColor: Color) {

    Image(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
            .border(
                width = borderWidth.dp,
                color = borderColor,
                shape = CircleShape
            ),
        painter = painterResource(id = imageId),
        contentDescription = "Riyadh City"
    )
}

@Preview
@Composable
fun CircularImagePreview() {
    CircularImage(R.drawable.ram, 100, 4, Color.White)
}