package com.bluparse.koranid.data

import com.bluparse.koranid.data.entity.TopHeadline
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
interface MainService {

    /**
     * Get Top Headline
     */
    @Headers("Accept: application/json")
    @GET("top-headlines")
    fun getTopHeadline(
        @Query("country") country: String,
        @Query("category") category: String
    ): Observable<TopHeadline>
}