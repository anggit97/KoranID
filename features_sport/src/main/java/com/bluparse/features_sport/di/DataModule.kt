package com.bluparse.features_sport.di

import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.core.utils.rx.SchedulerProvider
import com.bluparse.features_sport.data.AppDataManager
import com.bluparse.features_sport.data.DataManager
import com.bluparse.features_sport.data.SportService
import com.bluparse.features_sport.data.remote.SportRemoteRepository
import com.bluparse.features_sport.data.remote.SportRemoteRepositoryImpl
import com.bluparse.network.services
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit Prayogo on 2019-07-31.
 */
@Module
class DataModule {

    @SportScope
    @Provides
    fun provideSportService(): SportService {
        return services()
    }

    @SportScope
    @Provides
    fun provideAppScheduler(): SchedulerProvider{
        return AppSchedulerProvider()
    }

    @SportScope
    @Provides
    fun provideSportRepository(sportService: SportService): SportRemoteRepository {
        return SportRemoteRepositoryImpl(sportService)
    }

    @SportScope
    @Provides
    fun provideAppDataManager(
        sportRemoteRepository: SportRemoteRepository
    ): DataManager {
        return AppDataManager(sportRemoteRepository)
    }
}