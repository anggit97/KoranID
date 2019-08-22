package com.bluparse.koranid.ui.main.home

import com.bluparse.core.base.BaseView
import com.bluparse.koranid.data.entity.TopHeadline

/**
 * Created by Anggit PRayogo on 2019-08-20.
 * github : @anggit97
 */
interface HomeContract {

    interface View : BaseView {

        fun showResponseSuccess(response: TopHeadline?)

        fun showLoading()

        fun hideLoading()

        fun showLoadingShimmer()

        fun hideLoadingShimmer()
    }

    interface Presenter {

        fun getTopHeadline(
            country: String,
            category: String,
            showShimmerLoading: Boolean
        )
    }
}