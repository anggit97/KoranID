package com.bluparse.core.di

import androidx.fragment.app.Fragment
import com.bluparse.core.extentions.coreComponent

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
fun Fragment.coreComponent() = requireActivity().coreComponent()