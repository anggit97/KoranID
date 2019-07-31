package com.bluparse.koranid.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.Directory.PACKAGE_NAME
import android.util.Log.e
import com.bluparse.core.base.BaseActivity
import com.bluparse.koranid.R
import com.bluparse.koranid.data.entity.TopHeadline
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

private const val CLASS_SPORT = "com.bluparse.features_sport.ui.list.SportActivity"

class MainActivity : BaseActivity(), MainContact.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()

        presenter.getTopHeadline("id", "sports")

        button.setOnClickListener {
            Intent().setClassName(packageName, CLASS_SPORT)
                .also {
                    startActivity(it)
                }
        }
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
