package com.application.lastfm_lloyds.di.modules;

import com.application.lastfm_lloyds.base.schedulers.BaseSchedulerProvider;
import com.application.lastfm_lloyds.base.schedulers.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class SchedulerModule {

    @Provides
    public BaseSchedulerProvider provideBaseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
