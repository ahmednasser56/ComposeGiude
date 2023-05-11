package com.programmingwithahmed.composegiude.image_slider

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programmingwithahmed.composegiude.R
import com.programmingwithahmed.composegiude.ui.theme.ComposeGiudeTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
class ImageSliderActivity : AppCompatActivity() {

    private val items = listOf(
        R.drawable.ram,
        R.drawable.riyadh,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeGiudeTheme {
                ImageSlider()
            }
        }
    }

    @Composable
    fun ImageSlider() {

        val pagerState = rememberPagerState()
        val coroutineScope = rememberCoroutineScope()

        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(
                pageCount = items.size,
                state = pagerState,
                key = { items[it] },
                //  pageSize = PageSize.Fixed(200.dp)
            ) { index ->

                Image(
                    painter = painterResource(id = items[index]),
                    contentDescription = "Image Slider",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

            }

            Box(
                modifier = Modifier
                   // .offset(y = -(16).dp)
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(100))
                    .background(Color.White)
                    .padding(8.dp)
                    .align(Alignment.BottomCenter)
            ) {

                IconButton(
                    modifier = Modifier.align(Alignment.CenterStart),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Go Back"
                    )
                }

                IconButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Go Forward"
                    )
                }
            }
        }

    }

    @Preview
    @Composable
    fun ImageSliderPreview() {
        ComposeGiudeTheme {
            ImageSlider()
        }
    }

}