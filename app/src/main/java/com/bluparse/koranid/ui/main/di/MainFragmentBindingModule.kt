package com.bluparse.koranid.ui.main.di

import com.bluparse.koranid.ui.main.home.HomeFragment
import com.bluparse.koranid.ui.main.di.home.HomeFragmentAdapterModule
import com.bluparse.koranid.ui.main.di.home.HomeFragmentModule
import com.bluparse.koranid.ui.main.explore.ExploreFragment
import com.bluparse.koranid.ui.main.profil.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Anggit PRayogo on 2019-08-20.
 * github : @anggit97
 */
@Module
abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector(
        modules = [
            HomeFragmentAdapterModule::class,
            HomeFragmentModule::class
        ]
    )
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun contributeExploreFragment(): ExploreFragment

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun contributeProfileFragment(): ProfileFragment
}