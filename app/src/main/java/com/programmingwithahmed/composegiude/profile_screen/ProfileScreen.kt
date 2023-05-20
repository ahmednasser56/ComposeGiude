package com.programmingwithahmed.composegiude.profile_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
        TextButton(text = "Change Profile Picture") {}
        Spacer(modifier = Modifier.height(32.dp))
        Row() {
            Box(modifier = Modifier.weight(1f))
            {
                ProfileInfoCard(title = "First Name", body = "Ahmed")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f))
            {
                ProfileInfoCard(title = "Last Name", body = "Nasser")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ProfileInfoCard(title = "Location", body = "Cairo")
        Spacer(modifier = Modifier.height(16.dp))
        ProfileInfoCard(title = "Email", body = "ahmednasser904@gmail.com")
        Spacer(modifier = Modifier.height(16.dp))
        ProfileInfoCard(title = "Phone", body = "+12345678900")
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(),
            shape = CutCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Green),
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Text(
                "Save",
                modifier = Modifier
                    .padding(8.dp),
                color = Color.White,
                fontFamily = Rubik,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }

}


@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}