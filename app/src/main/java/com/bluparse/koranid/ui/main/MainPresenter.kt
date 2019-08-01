package com.bluparse.koranid.ui.main

import com.bluparse.core.base.BasePresenter
import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.koranid.data.AppDataManager
import javax.inject.Inject

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
class MainPresenter @Inject constructor(
    private val appDataManager: AppDataManager,
    private val appScheduler: AppSchedulerProvider
) : BasePresenter<MainContact.View>(), MainContact.Presenter {

    override fun getTopHeadline(country: String, category: String) {
        view?.showLoading()
        compositeDisposable.addAll(
            appDataManager.getTopHeadline(country, category)
                .subscribeOn(appScheduler.io())
                .observeOn(appScheduler.mainThread())
                .subscribe(
                    { response ->
                        view?.hideLoading()
                        view?.showResponseSuccess(response)
                    }, { error ->
                        view?.hideLoading()
                        view?.showError(error)
                    }
                )
        )
    }
}