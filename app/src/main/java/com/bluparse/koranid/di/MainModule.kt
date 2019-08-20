package com.bluparse.koranid.di

import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.koranid.data.AppDataManager
import com.bluparse.koranid.data.MainService
import com.bluparse.koranid.data.remote.MainRemoteRepository
import com.bluparse.koranid.data.remote.MainRemoteRepositoryImpl
import com.bluparse.network.services
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
@Module
class MainModule {

    @MainScope
    @Provides
    fun provideService(retrofit: Retrofit): MainService {
        return retrofit.create(MainService::class.java)
    }

    @MainScope
    @Provides
    fun provideMainRemoteRepository(mainService: MainService): MainRemoteRepository {
        return MainRemoteRepositoryImpl(mainService)
    }

    @MainScope
    @Provides
    fun provideAppDataManager(mainRemoteRepository: MainRemoteRepository): AppDataManager {
        return AppDataManager(mainRemoteRepository)
    }

    @MainScope
    @Provides
    fun provideAppScheduler(): AppSchedulerProvider {
        return AppSchedulerProvider()
    }
}