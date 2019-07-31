package com.bluparse.features_sport.di.module

import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.features_sport.data.AppDataManager
import com.bluparse.features_sport.di.SportScope
import com.bluparse.features_sport.ui.list.SportPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit Prayogo on 2019-07-31.
 */
@Module
class PresenterModule {

    @SportScope
    @Provides
    fun provideAppScheduler(): AppSchedulerProvider {
        return AppSchedulerProvider()
    }

    @SportScope
    @Provides
    fun provideSportPresenter(
        appDataManager: AppDataManager,
        appSchedulerProvider: AppSchedulerProvider
    )
            : SportPresenter {
        return SportPresenter(appDataManager, appSchedulerProvider)
    }
}