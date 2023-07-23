package com.programmingwithahmed.composegiude.pick_image

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.programmingwithahmed.composegiude.R

@Composable
fun PickImageScreen() {

    val context = LocalContext.current

    var imageUri: Any? by remember {
        mutableStateOf(R.drawable.ic_placeholder)
    }

//    val imageLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.PickVisualMedia()
//    ) {
//        if (it != null) {
//            Log.d("PhotoPicker", "Selected URI: $it")
//            imageUri = it
//        } else {
//            Toast.makeText(context, "Error while selecting the image", Toast.LENGTH_SHORT).show()
//        }
//    }

    val imageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(maxItems = 2)
    ) {
        if (it.isNotEmpty()) {
            Log.d("PhotoPicker", "Selected URI: ${it[0]}")
            imageUri = it[0]
        } else {
            Toast.makeText(context, "Error while selecting the image", Toast.LENGTH_SHORT).show()
        }
    } 

    PickImageContent(
        context = context,
        imageUri = imageUri,
        onImageClicked = {
            imageLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        },
        onButtonClicked = {
            Toast.makeText(
                context,
                ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(context).toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    )
}

@Composable
private fun PickImageContent(
    context: Context,
    imageUri: Any?,
    onImageClicked: () -> Unit,
    onButtonClicked: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = ImageRequest.Builder(context).data(imageUri).build(),
            contentDescription = "Pick photo image",
            modifier = Modifier
                .size(250.dp)
                .clickable {
                    onImageClicked()
                },
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onButtonClicked() }) {
            Text(text = "Availability")
        }

    }
}