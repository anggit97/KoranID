package com.bluparse.core.di

import com.bluparse.core.utils.rx.SchedulerProvider
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
@Singleton
@Component(
    modules = [
        CoreModule::class
    ]
)
interface CoreComponent {

    fun appSchedulerProvider(): SchedulerProvider
}
