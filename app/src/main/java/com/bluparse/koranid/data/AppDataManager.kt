package com.bluparse.koranid.data

import com.bluparse.koranid.data.entity.TopHeadline
import com.bluparse.koranid.data.remote.MainRemoteRepository
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val mainRemoteRepository: MainRemoteRepository
) : DataManager {

    override fun getTopHeadline(country: String, category: String): Observable<TopHeadline> {
        return mainRemoteRepository.getTopHeadline(country, category)
    }
}