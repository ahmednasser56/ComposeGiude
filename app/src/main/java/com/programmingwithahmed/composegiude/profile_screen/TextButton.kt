package com.programmingwithahmed.composegiude.profile_screen

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.ui.theme.Orange
import com.programmingwithahmed.composegiude.ui.theme.Rubik

@Composable
fun TextButton(text: String, onClick: () -> Unit) {

    Text(
        text,
        color = Orange,
        fontFamily = Rubik,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.clickable { onClick }
    )
}


@Preview
@Composable
fun TextButtonPreview() {
    TextButton(text = "Change Profile Picture") {}
}