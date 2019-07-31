package com.bluparse.features_sport.di

import com.bluparse.core.di.CoreComponent
import com.bluparse.features_sport.di.module.AdapterModule
import com.bluparse.features_sport.di.module.DataModule
import com.bluparse.features_sport.di.module.PresenterModule
import com.bluparse.features_sport.ui.list.SportActivity
import dagger.Component

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
@SportScope
@Component(
    modules = [
        DataModule::class,
        PresenterModule::class,
        AdapterModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface SportComponent {

    fun inject(sportActivity: SportActivity)

    fun coreComponent(coreComponent: CoreComponent)
}