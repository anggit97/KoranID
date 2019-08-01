package com.bluparse.koranid.di.main

import com.bluparse.koranid.ui.main.CategoryAdapter
import com.bluparse.koranid.ui.main.TopHeadlineAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit Prayogo on 2019-08-01.
 */
@Module
class AdapterModule {

    @Provides
    fun provideCategoryAdapter(): CategoryAdapter {
        return CategoryAdapter()
    }

    @Provides
    fun provideTopHeadlineAdapter(): TopHeadlineAdapter {
        return TopHeadlineAdapter()
    }
}