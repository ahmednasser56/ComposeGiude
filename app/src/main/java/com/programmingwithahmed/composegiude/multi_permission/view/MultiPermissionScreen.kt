package com.programmingwithahmed.composegiude.multi_permission.view

import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.programmingwithahmed.composegiude.R
import com.programmingwithahmed.composegiude.multi_permission.viewModel.MultiPermissionViewModel
import com.programmingwithahmed.composegiude.onboard.data.collectAsEffect
import com.programmingwithahmed.composegiude.widgets.BitmapImage

@Composable
fun MultiPermissionScreen(
    viewModel: MultiPermissionViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val imageBitmap by viewModel.imageBitmap.collectAsStateWithLifecycle()

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        viewModel.handleCameraResult(context, it)
    }

    val cameraPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) {
            viewModel.handleCameraPermissionResult(context)
        }

    //region handle flows
    viewModel.launchCameraPermission.collectAsEffect {
        cameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
    }

    viewModel.openCamera.collectAsEffect {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, it)
        cameraLauncher.launch(cameraIntent)
    }

    viewModel.error.collectAsEffect {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }
    //endregion

    MultiPermissionContent(
        imageBitmap = imageBitmap,
        onTakeImageButtonClicked = { viewModel.onTakeImageButtonClicked(context) }
    )
}

@Composable
private fun MultiPermissionContent(imageBitmap: Bitmap?, onTakeImageButtonClicked: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onTakeImageButtonClicked() }) {
            Text(text = "Take Image")
        }

        Spacer(modifier = Modifier.height(16.dp))

        BitmapImage(
            bitmap = imageBitmap,
            modifier = Modifier
                .size(300.dp),
        )

    }
}

@Preview
@Composable
fun MultiPermissionPreview() {
    MultiPermissionContent(imageBitmap = null) {}
}