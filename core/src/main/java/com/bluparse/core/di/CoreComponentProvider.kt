package com.bluparse.core.di

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
interface CoreComponentProvider {

    /**
     * Returns the CoreComponent / DI root.
     */
    fun provideCoreComponent(): CoreComponent
}