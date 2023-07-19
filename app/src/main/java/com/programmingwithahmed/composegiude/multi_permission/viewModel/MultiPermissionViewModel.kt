package com.programmingwithahmed.composegiude.multi_permission.viewModel

import android.Manifest
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.util.Base64
import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmingwithahmed.composegiude.utils.GeneralUtility
import com.programmingwithahmed.composegiude.utils.SaveImageFileUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@HiltViewModel
class MultiPermissionViewModel @Inject constructor(

) : ViewModel() {

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    private val _imageBitmap = MutableStateFlow<Bitmap?>(null)
    val imageBitmap = _imageBitmap.asStateFlow()

    private val _launchCameraPermission = MutableSharedFlow<List<String>>()
    val launchCameraPermission = _launchCameraPermission.asSharedFlow()

    private val _openCamera = MutableSharedFlow<Uri>()
    val openCamera = _openCamera.asSharedFlow()

    private lateinit var _imageUri: Uri

    //region camera
    private fun checkCameraPermissionIsGranted(context: Context) = viewModelScope.launch {
        val permissionsNotGranted = mutableListOf<String>()

        if (!GeneralUtility.checkPermissionIsGranted(context, Manifest.permission.CAMERA))
            permissionsNotGranted.add(Manifest.permission.CAMERA)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q &&
            !GeneralUtility.checkPermissionIsGranted(
                context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) permissionsNotGranted.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permissionsNotGranted.isEmpty()) {
            openCamera(context)
        } else {
            _launchCameraPermission.emit(permissionsNotGranted)
        }
    }

    fun handleCameraPermissionResult(context: Context) =
        viewModelScope.launch {

            if (!GeneralUtility.checkPermissionIsGranted(context, Manifest.permission.CAMERA)) {
                _error.emit("You must accept camera permission")
                return@launch
            }

            if (!GeneralUtility.checkPermissionIsGranted(
                    context,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            ) {
                _error.emit("You must accept storage permission")
                return@launch
            }

            openCamera(context)
        }

    private fun openCamera(context: Context) = viewModelScope.launch {

        _imageUri = SaveImageFileUtil.saveImageFile(context)
        _openCamera.emit(_imageUri)
    }

    fun handleCameraResult(context: Context, result: ActivityResult) = viewModelScope.launch {

        if (result.resultCode == Activity.RESULT_OK) {

            delay(300)

            val bitmap = GeneralUtility.getBitmapFromUri(context, _imageUri)
            _imageBitmap.update {
                bitmap
            }

        } else {
            _error.emit("Error while taking the image")
        }

    }
    //endregion

    fun onTakeImageButtonClicked(context: Context) {
        checkCameraPermissionIsGranted(context)
    }

}