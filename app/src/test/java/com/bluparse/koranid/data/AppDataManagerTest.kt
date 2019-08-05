package com.bluparse.koranid.data

import com.bluparse.koranid.data.remote.MainRemoteRepository
import com.bluparse.koranid.data.remote.MainRemoteRepositoryImpl
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
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
class AppDataManagerTest {

    @Mock
    lateinit var mainRemoteRepository: MainRemoteRepositoryImpl

    lateinit var appDataManager: AppDataManager

    @Before
    fun setUp() {
        appDataManager = AppDataManager(mainRemoteRepository)
    }

    @Test
    fun checkAppDataManagerIsNotNull() {
        assertNotNull(appDataManager)
    }

//    @Test
//    fun checkIfAppDatManagerReturnResult(){
//        appDataManager.getTopHeadline("id", "sports")
//            .observeOn(Schedulers.trampoline())
//            .subscribeOn(Schedulers.trampoline())
//            .subscribe {  }
//    }
}