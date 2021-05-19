package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

/**
 * The @BindingAdapter annotation tells data binding to execute this binding adapter
 * when a View item has the imageUrl attribute.
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        // Convert the URL string to a Uri object
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        // Coil method to load the image from the imgUri object into the imgView.
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation) // Placeholder to use while loading image.
            error(R.drawable.ic_broken_image) // Image to use if image loading fails.
        }
    }
}