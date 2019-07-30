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

private const val SPORT_SAMPLE_CLASSNAME = "features_sport.SportActivity"

class MainActivity : BaseActivity(), MainContact.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()

        presenter.getTopHeadline("id", "sports")

        tv_hello_world.setOnClickListener {
            launchActivity(SPORT_SAMPLE_CLASSNAME)
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

    /** Launch an activity by its class name. */
    private fun launchActivity(className: String) {
        val uri = Uri.parse("koranid://sport")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
