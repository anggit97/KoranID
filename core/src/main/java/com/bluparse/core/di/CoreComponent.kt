package com.bluparse.core.di

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

    fun getString(): String
}
