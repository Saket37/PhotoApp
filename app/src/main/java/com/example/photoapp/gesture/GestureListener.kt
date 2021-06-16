package com.example.photoapp.gesture

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import com.example.photoapp.data.remote.entity.URL

class GestureListener(private val context: Context, private val urls: URL) :
    GestureDetector.SimpleOnGestureListener() {

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        Log.d(this.javaClass.canonicalName, "onDoubleTap: $e")
        downloadImage()
        return true
    }

    // TODO set photo as wallpaper
    private fun downloadImage() {

        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        val downloadUri = Uri.parse(urls.full)

        val request = DownloadManager.Request(downloadUri)
        if (checkFileWritePermissions()) {
            request.setTitle(downloadUri.lastPathSegment)
                .setDescription("")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS, downloadUri.lastPathSegment + ".jpg"
                )
            Toast.makeText(context, "Downloading...", Toast.LENGTH_SHORT).show()
            downloadManager.enqueue(request)
        } else {
            Toast.makeText(context, "Write Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFileWritePermissions(): Boolean {
        val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
        val result: Int = context.checkCallingOrSelfPermission(permission)
        return result == PackageManager.PERMISSION_GRANTED
    }
}