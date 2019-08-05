package com.bluparse.koranid.data.remote

import com.bluparse.koranid.data.MainService
import com.bluparse.koranid.data.entity.TopHeadline
import com.bluparse.network.services
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.After
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
class MainRemoteRepositoryImplTest {

    @Mock
    lateinit var mainService: MainService

    private lateinit var mainRemoteRepositoryImpl: MainRemoteRepositoryImpl

    @Before
    fun setUp() {
        mainRemoteRepositoryImpl = MainRemoteRepositoryImpl(mainService)
    }

    @Test
    fun checkIsMainRepositoryNull() {
        assertNotNull(mainRemoteRepositoryImpl)
    }

    @Test
    fun checkIsRepository() {
//        val results: MutableList<TopHeadline> = mutableListOf()
//        mainRemoteRepositoryImpl.getTopHeadline("id", "sports")
//            .subscribeOn(Schedulers.trampoline())
//            .observeOn(Schedulers.trampoline())
//            .subscribe {
//                results.add(it)
//            }
//
//        assertEquals(results.size, 0)
    }
}