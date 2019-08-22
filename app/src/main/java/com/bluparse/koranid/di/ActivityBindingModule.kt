package com.bluparse.koranid.di

import com.bluparse.koranid.ui.detail.DetailNewsActivity
import com.bluparse.koranid.ui.main.MainActivity
import com.bluparse.koranid.ui.main.di.MainFragmentBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            MainFragmentBindingModule::class
        ]
    )
    abstract fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun provideDetailNews(): DetailNewsActivity
}