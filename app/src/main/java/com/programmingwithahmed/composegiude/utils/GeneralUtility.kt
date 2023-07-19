package com.programmingwithahmed.composegiude.utils

import android.Manifest
import android.content.*
import android.content.pm.PackageManager
import android.graphics.*
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.core.content.ContextCompat


class GeneralUtility {

    companion object {


        //region permissions
        fun checkPermissionIsGranted(context: Context, permission: String): Boolean {
            return ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }

        fun checkLocationPermissionIsGranted(context: Context): Boolean =
            checkPermissionIsGranted(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) &&
                    checkPermissionIsGranted(
                        context,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
        //endregion

        fun getBitmapFromUri(context: Context, uri: Uri): Bitmap {

            return if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images.Media.getBitmap(
                    context.contentResolver,
                    uri
                )
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                ImageDecoder.decodeBitmap(source)
            }

        }

    }

}