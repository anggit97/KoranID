package com.bluparse.features_sport.data.remote

import com.bluparse.features_sport.data.entity.SportEntity
import io.reactivex.Observable

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
interface SportRemoteRepository {

    fun getSportNews(country: String, category: String): Observable<SportEntity>
}