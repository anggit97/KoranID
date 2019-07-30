package com.bluparse.koranid.di

import com.bluparse.koranid.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun provideMainActivity(): MainActivity
}