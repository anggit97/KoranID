package com.bluparse.koranid

import com.bluparse.core.di.CoreComponent
import com.bluparse.core.di.CoreComponentProvider
import com.bluparse.core.di.DaggerCoreComponent
import com.bluparse.koranid.di.DaggerMainComponenent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
class MainApplication : DaggerApplication(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponenent
            .builder()
            .bindApplication(this)
            .bindCoreModule(provideCoreComponent())
            .build()
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized){
            coreComponent = DaggerCoreComponent
                .builder()
                .build()
        }
        return coreComponent
    }
}