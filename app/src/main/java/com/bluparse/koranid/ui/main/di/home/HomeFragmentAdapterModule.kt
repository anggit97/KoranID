package com.bluparse.koranid.ui.main.di.home

import com.bluparse.koranid.ui.main.CategoryAdapter
import com.bluparse.koranid.ui.main.TopHeadlineAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit PRayogo on 2019-08-20.
 * github : @anggit97
 */
@Module
class HomeFragmentAdapterModule {

    @Provides
    fun provideCategoryAdapter(): CategoryAdapter {
        return CategoryAdapter()
    }

    @Provides
    fun provideTopHeadlineAdapter(): TopHeadlineAdapter {
        return TopHeadlineAdapter()
    }
}