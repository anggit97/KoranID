package com.bluparse.features_sport.di.module

import com.bluparse.features_sport.di.SportScope
import com.bluparse.features_sport.ui.list.SportAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit Prayogo on 2019-07-31.
 */
@Module
class AdapterModule {

    @SportScope
    @Provides
    fun provideSportAdapterScope(): SportAdapter{
        return SportAdapter()
    }
}