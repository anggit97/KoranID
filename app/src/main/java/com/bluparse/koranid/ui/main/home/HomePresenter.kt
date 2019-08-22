package com.bluparse.koranid.ui.main.home

import com.bluparse.core.base.BasePresenter
import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.koranid.data.AppDataManager
import javax.inject.Inject

/**
 * Created by Anggit PRayogo on 2019-08-20.
 * github : @anggit97
 */
class HomePresenter @Inject constructor(
    private val appDataManager: AppDataManager,
    private val appScheduler: AppSchedulerProvider
) : BasePresenter<HomeContract.View>(), HomeContract.Presenter {

    override fun getTopHeadline(country: String, category: String, showShimmerLoading: Boolean) {
        checkLoadingTypeShowState(showShimmerLoading)
        compositeDisposable.addAll(
            appDataManager.getTopHeadline(country, category)
                .subscribeOn(appScheduler.io())
                .observeOn(appScheduler.mainThread())
                .subscribe(
                    { response ->
                        checkLoadingTypeHideState(showShimmerLoading)
                        view?.showResponseSuccess(response)
                    }, { error ->
                        checkLoadingTypeHideState(showShimmerLoading)
                        view?.showError(error)
                    }
                )
        )
    }

    private fun checkLoadingTypeHideState(showShimmerLoading: Boolean) {
        if (showShimmerLoading) {
            view?.hideLoadingShimmer()
        } else {
            view?.hideLoading()
        }
    }

    private fun checkLoadingTypeShowState(showShimmerLoading: Boolean) {
        if (showShimmerLoading) {
            view?.showLoadingShimmer()
        } else {
            view?.showLoading()
        }
    }
}