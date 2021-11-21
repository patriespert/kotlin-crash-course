package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MediaAdapter(private val items: List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflar la vista
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_media_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //binding de la vista con el item correspondiente
        val item = items[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){

        val title: TextView = view.findViewById(R.id.mediaTitle)
        val thumb: ImageView = view.findViewById(R.id.mediaThumb)
        fun bind(mediaItem: MediaItem){
            title.text  = mediaItem.title
            Glide.with(thumb).load(mediaItem.url).into(thumb)
        }
    }
}