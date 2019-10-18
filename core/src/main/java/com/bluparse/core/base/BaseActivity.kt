package com.bluparse.core.base

import android.content.Context
import androidx.core.content.ContextCompat
import com.bluparse.core.R
import com.bluparse.core.utils.changeStatusBarColor
import com.bluparse.core.utils.changeStatusBarItemColor
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

    protected fun initStatusBarPref() {
        changeStatusBarColor(this, ContextCompat.getColor(this, R.color.colorWhite))
        changeStatusBarItemColor(this, false)
    }
}