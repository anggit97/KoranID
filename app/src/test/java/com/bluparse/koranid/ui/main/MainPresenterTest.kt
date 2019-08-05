package com.bluparse.koranid.ui.main

import com.bluparse.core.utils.rx.AppSchedulerProvider
import com.bluparse.core.utils.rx.SchedulerProvider
import com.bluparse.koranid.data.AppDataManager
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Anggit Prayogo on 2019-08-05.
 */
@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Mock
    lateinit var dataManager: AppDataManager

    @Mock
    lateinit var appSchedulerProvider: AppSchedulerProvider

    @Mock
    lateinit var view: MainContact.View

    lateinit var presenterTest: MainPresenter

    @Before
    fun setUp() {
        appSchedulerProvider = AppSchedulerProvider()
        presenterTest = MainPresenter(dataManager, appSchedulerProvider)
        presenterTest.attachView(view)
    }

    @Test
    fun test_isPresenterNotNull() {
//        assertNotNull(presenterTest)
    }
}