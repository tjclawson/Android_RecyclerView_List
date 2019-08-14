package com.example.galleryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.image_item_layout.view.*



class ImageListAdapter(val views: Array<ImageView>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val image: ImageView = view.image_view

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return views.size
    }

    override fun onBindViewHolder(holder: ImageListAdapter.ViewHolder, position: Int) {
        holder.image.setImageDrawable(views[position].drawable)
    }
}
