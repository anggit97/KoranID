package com.bluparse.koranid.data.remote

import com.bluparse.koranid.data.entity.TopHeadline
import io.reactivex.Observable

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
interface MainRemoteRepository {

    fun getTopHeadline(
        country: String,
        category: String
    ): Observable<TopHeadline>
}