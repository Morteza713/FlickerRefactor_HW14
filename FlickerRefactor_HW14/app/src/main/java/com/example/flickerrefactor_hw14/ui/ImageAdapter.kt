package com.example.flickerrefactor_hw14.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.flickerrefactor_hw14.R
import com.example.flickerrefactor_hw14.data.model.Photo
import com.example.flickerrefactor_hw14.databinding.ImageItemBinding

class ImageAdapter():RecyclerView.Adapter<ImageAdapter.ImageView>() {
    private var photos = emptyList<Photo>()
    inner class ImageView(itemView: View):RecyclerView.ViewHolder(itemView){
        var ivPic: android.widget.ImageView = itemView.findViewById(R.id.imageView)
        var txtSubject : TextView = itemView.findViewById(R.id.textView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageView {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val item = inflater.inflate(R.layout.image_item, parent, false)
        return ImageView(item)
    }
    override fun onBindViewHolder(holder: ImageView, position: Int) {
        loadImage(holder.ivPic, photos[position])
        holder.txtSubject.text = photos[position].title
    }
    override fun getItemCount(): Int {
        return photos.size
    }
    private fun loadImage(imageView: android.widget.ImageView, photo: Photo) {
        Glide.with(imageView.context)
            .setDefaultRequestOptions(RequestOptions.fitCenterTransform())
            .load(photo.url_s)
            .into(imageView)
    }
    fun pushPic(list : List<Photo>){
        this.photos = list
        this.notifyItemInserted(itemCount)
    }
    fun addAllPic(list: List<Photo>) {
        (photos as MutableList).addAll(list)
        this.notifyItemInserted(itemCount)
    }
}