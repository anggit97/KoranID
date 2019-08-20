package com.bluparse.koranid.di

import android.app.Application
import com.bluparse.core.di.CoreModule
import com.bluparse.koranid.MainApplication
import com.bluparse.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
@MainScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        CoreModule::class,
        NetworkModule::class,
        MainModule::class,
        ActivityBindingModule::class
    ]
)
interface MainComponenent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(application: Application): Builder

        fun build(): MainComponenent
    }
}