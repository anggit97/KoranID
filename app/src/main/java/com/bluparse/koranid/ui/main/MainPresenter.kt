package com.bluparse.koranid.ui.main

import com.bluparse.core.base.BasePresenter
import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.koranid.data.AppDataManager
import javax.inject.Inject

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
class MainPresenter @Inject constructor(
    val appDataManager: AppDataManager,
    val appScheduler: AppSchedulerProvider
) : BasePresenter<MainContact.View>(), MainContact.Presenter {

    override fun getTopHeadline(country: String, category: String) {
        compositeDisposable.addAll(
            appDataManager.getTopHeadline(country, category)
                .subscribeOn(appScheduler.io())
                .subscribeOn(appScheduler.mainThread())
                .subscribe(
                    { response ->
                        view?.showResponseSuccess(response)
                    }, { error ->
                        view?.showError(error)
                    }
                )
        )
    }
}