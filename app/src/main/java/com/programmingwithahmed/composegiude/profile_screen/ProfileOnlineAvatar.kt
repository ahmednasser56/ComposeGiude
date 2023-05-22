package com.programmingwithahmed.composegiude.profile_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileOnlineAvatar(imageUrl: String) {

    AsyncImage(
        model = imageUrl, contentDescription = "Profile Image",
        modifier = Modifier
            .size(100.dp)
            .border(width = 1.dp, color = Color.Black, shape = CutCornerShape(16.dp))
            .clip(shape = CutCornerShape(16.dp)),
    )
}


@Preview
@Composable
fun ProfileOnlineAvatarPreview() {
    ProfileOnlineAvatar(imageUrl = "")
}