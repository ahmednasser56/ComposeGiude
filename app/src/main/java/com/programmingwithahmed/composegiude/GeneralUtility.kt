package com.programmingwithahmed.composegiude

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.*
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.transition.platform.MaterialSharedAxis
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


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