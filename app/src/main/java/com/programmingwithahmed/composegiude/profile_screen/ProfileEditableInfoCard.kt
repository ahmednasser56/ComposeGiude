package com.programmingwithahmed.composegiude.profile_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingwithahmed.composegiude.ui.theme.CardBackgroundColor
import com.programmingwithahmed.composegiude.ui.theme.Rubik
import com.programmingwithahmed.composegiude.ui.theme.SecondaryTextColor

@Composable
fun ProfileEditableInfoCard(title: String, body: String, onValueChanged: (String) -> Unit) {

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
                title,
                color = SecondaryTextColor,
                fontFamily = Rubik,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )

            BasicTextField(value = body, onValueChange = onValueChanged)
        }
    }
}


@Preview
@Composable
fun ProfileEditableInfoCardPreview() {
    ProfileEditableInfoCard(title = "Title", body = "Body", {})
}