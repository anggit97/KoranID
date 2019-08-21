package com.bluparse.koranid.ui.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.bluparse.core.base.BaseActivity
import com.bluparse.koranid.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationUI.setupWithNavController(
            bottom_navigation,
            (supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment).navController
        )
    }
}
