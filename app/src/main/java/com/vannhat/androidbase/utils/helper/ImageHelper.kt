package com.vannhat.androidbase.utils.helper

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.vannhat.androidbase.R


fun ImageView.setImageUrl(path: String?) {
    Glide.with(context)
        .load(path)
        .placeholder(R.drawable.ic_image)
        .into(this)
}
