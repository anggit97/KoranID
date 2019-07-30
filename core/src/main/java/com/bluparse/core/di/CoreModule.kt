package com.bluparse.core.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
@Module
class CoreModule {

    @Singleton
    @Provides
    fun provideStringCore(): String {
        return "Tester"
    }
}