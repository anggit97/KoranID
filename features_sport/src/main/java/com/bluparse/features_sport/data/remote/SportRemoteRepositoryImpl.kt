package com.bluparse.features_sport.data.remote

import com.bluparse.features_sport.data.SportService
import com.bluparse.features_sport.data.entity.SportEntity
import io.reactivex.Observable
import javax.inject.Inject

class SportRemoteRepositoryImpl @Inject constructor(
    private val sportService: SportService
) : SportRemoteRepository {

    override fun getSportNews(country: String, category: String): Observable<SportEntity> {
        return sportService.getSportNews(country, category)
    }
}