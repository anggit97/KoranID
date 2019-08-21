package com.bluparse.core.utils

import android.content.Context
import android.widget.ImageView
import com.bluparse.core.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

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
        .transform(RoundedCorners(5))
        .into(this)
}