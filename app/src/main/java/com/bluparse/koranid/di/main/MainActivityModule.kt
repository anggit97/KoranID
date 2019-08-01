package com.bluparse.koranid.di.main

import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.koranid.data.AppDataManager
import com.bluparse.koranid.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
@Module
class MainActivityModule {

    @Provides
    fun provideMainPresenter(
        appSchedulerProvider: AppSchedulerProvider,
        appDataManager: AppDataManager
    ): MainPresenter {
        return MainPresenter(appDataManager, appSchedulerProvider)
    }
}