package com.bluparse.core.utils

import kotlin.math.ceil

/**
 * Created by Anggit PRayogo on 2019-08-21.
 * github : @anggit97
 */
object ColorAlphaUtil {

    fun calculateAlphaColor(percent: Double): Int {
        val baseColor = 255
        return ceil(baseColor * percent).toInt()
    }
}