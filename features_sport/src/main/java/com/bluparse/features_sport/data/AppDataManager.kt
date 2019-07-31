package com.bluparse.features_sport.data

import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.features_sport.data.entity.SportEntity
import com.bluparse.features_sport.data.remote.SportRemoteRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
class AppDataManager @Inject constructor(
    private val sportRemoteRepository: SportRemoteRepository
) : DataManager {

    override fun getSportNews(country: String, category: String): Observable<SportEntity> {
        return sportRemoteRepository.getSportNews(country, category)
    }
}