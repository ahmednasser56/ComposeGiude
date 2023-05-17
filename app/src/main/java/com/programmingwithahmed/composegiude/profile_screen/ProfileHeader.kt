package com.programmingwithahmed.composegiude.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.ui.theme.PrimaryTextColor
import com.programmingwithahmed.composegiude.ui.theme.Rubik
import com.programmingwithahmed.composegiude.ui.theme.SecondaryTextColor

@Composable
fun ProfileHeader(title: String, subTitle: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            title,
            color = PrimaryTextColor,
            fontFamily = Rubik,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )


        Text(
            subTitle,
            color = SecondaryTextColor,
            fontFamily = Rubik,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )

    }

}


@Preview
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader(title = "Account", subTitle = "Edit or manage your Account")
}