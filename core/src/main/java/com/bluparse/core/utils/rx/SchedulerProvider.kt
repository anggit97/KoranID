package com.bluparse.core.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun computation(): Scheduler

    fun trampoline(): Scheduler

    fun newThread(): Scheduler

    fun io(): Scheduler
}