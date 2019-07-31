package com.bluparse.features_sport.ui.list

import com.bluparse.core.base.BaseView
import com.bluparse.features_sport.data.entity.SportEntity

/**
 * Created by Anggit Prayogo on 2019-07-31.
 */
interface SportContract {

    interface View: BaseView{

        fun showLoading()

        fun hideLoading()

        fun showResponseSuccess(response: SportEntity?)
    }

    interface Presenter{

        fun getNews(country: String, category: String)
    }
}