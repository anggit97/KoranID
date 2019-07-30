package com.bluparse.koranid.ui

import com.bluparse.core.base.BaseView
import com.bluparse.koranid.data.entity.TopHeadline

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
interface MainContact {

    interface View : BaseView {

        fun showResponseSuccess(response: TopHeadline?)
    }

    interface Presenter {

        fun getTopHeadline(
            country: String,
            category: String
        )
    }
}