package com.application.lastfm_lloyds.base.schedulers;

import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {

    Scheduler mainThread();

    Scheduler io();

    Scheduler computation();
}
