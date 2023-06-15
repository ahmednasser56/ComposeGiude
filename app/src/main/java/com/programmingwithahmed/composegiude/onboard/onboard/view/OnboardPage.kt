package com.programmingwithahmed.composegiude.onboard.onboard.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.R
import com.programmingwithahmed.composegiude.onboard.model.OnboardItem

@Composable
fun OnboardPage(onboardItem: OnboardItem) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = onboardItem.image),
            contentDescription = "Onboard Image",
            modifier = Modifier.size(200.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = onboardItem.title, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = onboardItem.description, fontSize = 18.sp, textAlign = TextAlign.Center)
        }
    }

}


@Preview
@Composable
fun OnboardPagePreview() {
    OnboardPage(
        OnboardItem(
            image = R.drawable.first,
            title = "Meeting",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
        )
    )
}