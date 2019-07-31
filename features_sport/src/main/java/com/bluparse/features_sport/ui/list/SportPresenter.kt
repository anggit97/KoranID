package com.bluparse.features_sport.ui.list

import com.bluparse.core.base.BasePresenter
import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.features_sport.data.AppDataManager
import javax.inject.Inject

/**
 * Created by Anggit Prayogo on 2019-07-31.
 */
class SportPresenter @Inject constructor(
    private val appDataManager: AppDataManager,
    private val appSchedulerProvider: AppSchedulerProvider
) : BasePresenter<SportContract.View>(), SportContract.Presenter{

    override fun getNews(country: String, category: String) {
        view?.showLoading()
        compositeDisposable.addAll(
            appDataManager.getSportNews(country, category)
                .subscribeOn(appSchedulerProvider.io())
                .observeOn(appSchedulerProvider.mainThread())
                .subscribe(
                    {response ->
                        view?.hideLoading()
                        view?.showResponseSuccess(response)
                    },
                    {error ->
                        view?.hideLoading()
                        view?.showError(error)
                    }
                )
        )
    }
}