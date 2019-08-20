package com.bluparse.koranid

import com.bluparse.koranid.di.DaggerMainComponenent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
class MainApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponenent
            .builder()
            .bindApplication(this)
            .build()
    }
}