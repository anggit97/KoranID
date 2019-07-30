package com.bluparse.core.base

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
interface Presenter<V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}