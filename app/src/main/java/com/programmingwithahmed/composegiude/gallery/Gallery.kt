package com.programmingwithahmed.composegiude.gallery

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun GalleryScreen() {
    GalleryContent()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun GalleryContent() {

    val images = listOf(
        "https://wallpaperaccess.com/full/1933166.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwB_v5ciQOKh44znzhZ4lOo437j7WR_yUAHA&usqp=CAU",
        "https://e0.pxfuel.com/wallpapers/524/104/desktop-wallpaper-calming-background-calming-aesthetic.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShWoTqko50hTd2YvxNeJIFUz9XLNPQYkybAg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-lHrlEQ7OKgPI8ZctzO9JEEiXQ_T7CiKOoA&usqp=CAU",
    )
    val pagerState = rememberPagerState()
    val matrix = remember{
        ColorMatrix()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            pageCount = images.size, state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
        ) {

            val pageOffset = (pagerState.currentPage - it) + pagerState.currentPageOffsetFraction
            val imageSize by animateFloatAsState(
                targetValue = if (pageOffset == 0.0f) 1f else 0.75f,
                animationSpec = tween(durationMillis = 300)
            )

            LaunchedEffect(key1 = imageSize){
                if (pageOffset == 0.0f)
                    matrix.setToSaturation(1f)
                    else
                    matrix.setToSaturation(0f)
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(images[it]).build(),
                contentDescription = "Gallery Image",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer {
                        scaleX = imageSize
                        scaleY = imageSize
                    },
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(matrix)
            )

        }
    }

}

@Preview
@Composable
fun GalleryPreview() {
    GalleryContent()
}