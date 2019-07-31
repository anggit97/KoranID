package com.bluparse.core.base

import androidx.appcompat.app.AppCompatActivity
import com.bluparse.core.di.CoreComponent
import com.bluparse.core.di.CoreComponentProvider
import com.bluparse.core.di.DaggerCoreComponent

/**
 * Created by Anggit Prayogo on 2019-07-31.
 */
abstract class BaseActivityFeature: AppCompatActivity(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .build()
        }
        return coreComponent
    }
}