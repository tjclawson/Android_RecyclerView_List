package com.example.image_viewer.model

import android.net.Uri
import java.io.Serializable
import java.net.URI

class ImageData(imageUri: Uri) : Serializable {

    private var imageUri: Uri? = null
    private var stringUri: String = ""

    fun setName(){
        val path = stringUri.split("/".toRegex()).dropLastWhile{ it.isEmpty() }.toTypedArray()
        val name = path[path.size-1]
    }

    fun setUri(imageUri: Uri) {
        stringUri = imageUri.toString()
        setName()
    }

    fun getUri():Uri {
        return Uri.parse(stringUri)
    }


}