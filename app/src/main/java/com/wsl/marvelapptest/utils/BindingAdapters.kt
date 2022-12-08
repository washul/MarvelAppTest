package com.wsl.marvelapptest.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.wsl.marvelapptest.R
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Picasso.get()
        .load(url)
        .fit()
        .placeholder(R.drawable.placeholder)
        .into(view)
}