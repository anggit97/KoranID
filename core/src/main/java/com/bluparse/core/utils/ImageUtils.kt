package com.bluparse.core.utils

import android.content.Context
import android.widget.ImageView
import com.bluparse.core.R
import com.bumptech.glide.Glide

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
fun ImageView.showImage(context: Context, imageSource: Any?) {
    Glide.with(context)
        .load(imageSource)
        .error(R.drawable.icon_business)
        .into(this)
}