package com.bluparse.koranid.data.remote

import com.bluparse.koranid.data.MainService
import com.bluparse.koranid.data.entity.TopHeadline
import io.reactivex.Observable
import javax.inject.Inject

class MainRemoteRepositoryImpl @Inject constructor(
    private val mainService: MainService
) : MainRemoteRepository {

    override fun getTopHeadline(country: String, category: String): Observable<TopHeadline> {
        return mainService.getTopHeadline(country, category)
    }
}