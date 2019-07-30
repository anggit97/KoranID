package com.bluparse.core.extentions

import android.app.Activity
import com.bluparse.core.di.CoreComponentProvider

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
fun Activity.coreComponent() =
    (applicationContext as? CoreComponentProvider)?.provideCoreComponent()
        ?: throw IllegalStateException("CoreComponentProvider not implemented: $applicationContext")