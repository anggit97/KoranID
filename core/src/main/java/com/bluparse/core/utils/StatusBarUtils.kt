package com.bluparse.core.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager

/**
 * Created by Anggit PRayogo on 2019-08-22.
 * github : @anggit97
 */
fun changeStatusBarItemColor(activity: Activity?, isBackgroundDark: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val decor = activity?.window?.decorView
        if (!isBackgroundDark) {
            decor?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            // We want to change tint color to white again.
            // You can also record the flags in advance so that you can turn UI back completely if
            // you have set other flags before, such as translucent or full screen.
            decor?.systemUiVisibility = 0
        }
    }
}

fun changeStatusBarColor(activity: Activity?, color: Int) {
    if (Build.VERSION.SDK_INT >= 21) {
        val window = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window?.statusBarColor = color
    }
}
