package com.example.image_viewer.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.image_viewer.R
import com.example.image_viewer.model.ImageData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var imageList = mutableListOf<ImageData>()
    var index = 0


    companion object {
        const val IMAGE_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, IMAGE_REQUEST_CODE)
            }
        }


    }

    fun createTextView(name: String, index: Int): TextView {
        val textview = TextView(this)

        textview.text = name
        textview.id = index


        return textview
        index++


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val newImageData = data!!.getSerializableExtra("Image") as ImageData
            imageList.add(newImageData)
            image_scroll_linear.addView(createTextView(newImageData., index))
        }
    }
}
