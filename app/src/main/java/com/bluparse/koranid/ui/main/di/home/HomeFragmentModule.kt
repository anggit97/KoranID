package com.bluparse.koranid.ui.main.di.home

import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.koranid.data.AppDataManager
import com.bluparse.koranid.ui.main.CategoryAdapter
import com.bluparse.koranid.ui.main.MainPresenter
import com.bluparse.koranid.ui.main.TopHeadlineAdapter
import com.bluparse.koranid.ui.main.home.HomePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit PRayogo on 2019-08-20.
 * github : @anggit97
 */
@Module
class HomeFragmentModule {

    @Provides
    fun provideHomePresenter(
        appSchedulerProvider: AppSchedulerProvider,
        appDataManager: AppDataManager
    ): HomePresenter {
        return HomePresenter(appDataManager, appSchedulerProvider)
    }
}