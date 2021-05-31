package com.andriuswill.mesa_news.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?){
    Glide
        .with(view.context)
        .load(url)
        .dontAnimate()
        .centerCrop()
        .into(view)
}