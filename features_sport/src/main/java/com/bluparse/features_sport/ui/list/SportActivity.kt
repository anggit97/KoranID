package com.bluparse.features_sport.ui.list

import android.os.Bundle
import android.util.Log.e
import androidx.appcompat.app.AppCompatActivity
import com.bluparse.core.extentions.coreComponent
import com.bluparse.features_sport.R
import com.bluparse.features_sport.data.AppDataManager
import com.bluparse.features_sport.data.entity.SportEntity
import com.bluparse.features_sport.di.DaggerSportComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_sport.*
import javax.inject.Inject

class SportActivity : AppCompatActivity(), SportContract.View {

    @Inject
    lateinit var presenter: SportPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)

        initInjection()

        initPresenter()

        fetchData()
    }

    private fun fetchData() {
        presenter.getNews("id", "sports")
    }

    private fun initPresenter() {
        presenter.attachView(this)
    }

    private fun initInjection() {
        DaggerSportComponent.builder().coreComponent(coreComponent()).build().inject(this)
    }

    override fun showLoading() {
        swipe_refresh_layout.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_layout.isRefreshing = false
    }

    override fun showResponseSuccess(response: SportEntity?) {
        e("DATA : ", response.toString())
    }

    override fun showError(throwable: Throwable) {
        e("DATA ERROR : ", throwable.message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}