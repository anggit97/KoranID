package com.bluparse.core.utils

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bluparse.core.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
fun ImageView.showImage(context: Context, imageSource: Any?) {
    Glide.with(context)
        .load(imageSource)
        .error(R.drawable.icon_business)
        .into(this)
}

fun ImageView.showImageRounded(context: Context, imageSource: Any?) {
    Glide.with(context)
        .load(imageSource)
        .apply(
            RequestOptions()
                .transform(CenterCrop(), RoundedCorners(16))
        )
        .into(this)
}
