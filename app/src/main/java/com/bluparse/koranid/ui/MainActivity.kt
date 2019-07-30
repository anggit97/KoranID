package com.bluparse.koranid.ui

import android.os.Bundle
import android.util.Log.e
import com.bluparse.core.base.BaseActivity
import com.bluparse.koranid.R
import com.bluparse.koranid.data.entity.TopHeadline
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContact.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()

        presenter.getTopHeadline("id", "sports")
    }

    private fun initPresenter() {
        presenter.attachView(this)
    }

    override fun showResponseSuccess(response: TopHeadline?) {
        e("DATA : ", response.toString())
    }

    override fun showError(throwable: Throwable) {
        e("DATA ERROR: ", throwable.message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
