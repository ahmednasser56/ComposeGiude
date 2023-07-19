package com.programmingwithahmed.composegiude.utils

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import java.io.File

class SaveImageFileUtil {

    companion object {

        fun saveImageFile(context: Context): Uri {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) saveImage(context)
            else saveImageLegacy(context)
        }

        @RequiresApi(Build.VERSION_CODES.Q)
        private fun saveImage(context: Context): Uri {

            return context.contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                ContentValues()
            )!!
        }

        private fun saveImageLegacy(context: Context): Uri {

            val storageDir =
                context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

            val photoFile = File.createTempFile("IMG_", ".jpg", storageDir)

            return FileProvider.getUriForFile(
                context,
                "com.programmingwithahmed.composegiude.fileprovider",
                File(photoFile.absolutePath)
            )
        }
    }

}