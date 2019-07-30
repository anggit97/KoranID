package com.bluparse.koranid.di

import dagger.Module
import dagger.Provides

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
@Module
class MainModule {

    @MainScope
    @Provides
    fun provideInt() = 10
}