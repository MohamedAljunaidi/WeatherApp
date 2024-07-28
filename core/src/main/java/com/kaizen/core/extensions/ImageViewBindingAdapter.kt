package com.kaizen.core.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("image_url", "default_image", requireAll = false)
fun ImageView.setImageUrl(url: String?, defaultImage: Int?) {
    Glide.with(this).load(url)
        .apply(RequestOptions().placeholder(defaultImage ?: DEFAULT_IMAGE_RES)).into(this)
}
