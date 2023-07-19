package com.programmingwithahmed.composegiude.widgets

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.programmingwithahmed.composegiude.R

@Composable
fun BitmapImage(bitmap: Bitmap?, modifier: Modifier = Modifier) {

    if (bitmap == null) {
        Image(
            painter = painterResource(id = R.drawable.ic_placeholder),
            contentDescription = "Some useful content",
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    } else {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "Some useful content",
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    }
}