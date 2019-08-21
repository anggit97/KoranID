package com.bluparse.koranid

import com.bluparse.core.utils.FontConfig
import com.bluparse.koranid.di.DaggerMainComponenent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
class MainApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath(FontConfig.DEFAULT_FONT)
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponenent
            .builder()
            .bindApplication(this)
            .build()
    }
}
