package com.bluparse.core.base

import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Anggit Prayogo on 2019-07-29.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    protected fun getProcessScheduler(): Scheduler {
        return Schedulers.io()
    }

    protected fun getAndroidScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}