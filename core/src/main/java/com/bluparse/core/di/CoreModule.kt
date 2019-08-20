package com.bluparse.core.di

import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.core.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
@Module
class CoreModule {

    @CoreScope
    @Provides
    fun provideAppScheduler(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}