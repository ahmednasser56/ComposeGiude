package com.programmingwithahmed.composegiude.profile_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.R
import com.programmingwithahmed.composegiude.ui.theme.*


@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ProfileHeader(title = "Account", subTitle = "Edit or manage your Account")
        Spacer(modifier = Modifier.height(32.dp))
        ProfileAvatar(painter = painterResource(id = R.drawable.me))
        Spacer(modifier = Modifier.height(24.dp))
        TextButton(text = "Change Profile Picture") {
        }
        Spacer(modifier = Modifier.height(32.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = CardBackgroundColor,
            shape = CutCornerShape(16.dp),
            elevation = 0.dp
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    "abcd",
                    color = SecondaryTextColor,
                    fontFamily = Rubik,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal
                )


                Text(
                    "abcdgfffffffff",
                    color = PrimaryTextColor,
                    fontFamily = Rubik,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }

}


@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}