package com.programmingwithahmed.composegiude.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programmingwithahmed.composegiude.R

@Composable
fun ProfileAvatar(painter: Painter) {

    Image(
        painter = painter, contentDescription = "Profile Image",
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black, shape = CutCornerShape(16.dp))
            .clip(shape = CutCornerShape(16.dp)),
    )
}


@Preview
@Composable
fun ProfileAvatarPreview() {
    ProfileAvatar(painter = painterResource(id = R.drawable.me))

}