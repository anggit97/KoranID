package com.bluparse.koranid.di

import com.bluparse.koranid.di.main.MainActivityModule
import com.bluparse.koranid.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class
        ]
    )
    abstract fun provideMainActivity(): MainActivity
}