package com.bluparse.features_sport.data

import com.bluparse.features_sport.data.entity.SportEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
interface SportService {

    @Headers("Accept: application/json")
    @GET("top-headlines")
    fun getSportNews(
        @Query("country") country: String,
        @Query("category") category: String
    ): Observable<SportEntity>
}