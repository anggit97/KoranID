package com.bluparse.core.base

import android.content.Context
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    protected fun getProcessScheduler(): Scheduler {
        return Schedulers.io()
    }

    protected fun getAndroidScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}