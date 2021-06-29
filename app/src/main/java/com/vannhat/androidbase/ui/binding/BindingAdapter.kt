package com.vannhat.androidbase.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.vannhat.androidbase.utils.helper.setImageUrl

@BindingAdapter("imageUrl")
fun setImageUrl(iv: ImageView, url: String?) {
    iv.setImageUrl(url)
}
