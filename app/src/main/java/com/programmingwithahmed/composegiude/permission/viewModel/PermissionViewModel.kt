package com.programmingwithahmed.composegiude.permission.viewModel

import android.Manifest
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmingwithahmed.composegiude.GeneralUtility
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PermissionViewModel @Inject constructor(

) : ViewModel() {

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    private val _imageBitmap = MutableStateFlow<Bitmap?>(null)
    val imageBitmap = _imageBitmap.asStateFlow()

    init {

    }

    fun onTakeImageButtonClicked(context: Context) {
        checkCameraPermissionIsGranted(context)
    }

    //region camera
    private val _launchCameraPermission = MutableSharedFlow<Boolean>()
    val launchCameraPermission = _launchCameraPermission.asSharedFlow()

    private val _openCamera = MutableSharedFlow<Boolean>()
    val openCamera = _openCamera.asSharedFlow()

    private fun checkCameraPermissionIsGranted(context: Context) = viewModelScope.launch {

        if (GeneralUtility.checkPermissionIsGranted(context, Manifest.permission.CAMERA)) {
            _openCamera.emit(true)
        } else {
            _launchCameraPermission.emit(true)
        }
    }

    fun handleCameraPermissionResult(context: Context) =
        viewModelScope.launch {

            if (!GeneralUtility.checkPermissionIsGranted(context, Manifest.permission.CAMERA)) {
                _error.emit("You must accept camera permission")
                return@launch
            }

            _openCamera.emit(true)
        }

    fun handleCameraResult(result: ActivityResult) = viewModelScope.launch {

        delay(300)

        if (result.resultCode == Activity.RESULT_OK) {

            val photo = result.data?.extras?.get("data") as Bitmap

            _imageBitmap.update {
                photo
            }

        } else {
            _error.emit("Error while taking the image")
        }

    }
    //endregion
}