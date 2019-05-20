package com.application.lastfm_lloyds.di;

import android.app.Application;

import com.LastFMApp;
import com.application.lastfm_lloyds.di.modules.ActivityBindingModule;
import com.application.lastfm_lloyds.di.modules.ApplicationModule;
import com.application.lastfm_lloyds.di.modules.NetworkModule;
import com.application.lastfm_lloyds.di.modules.SchedulerModule;
import com.application.lastfm_lloyds.di.modules.ServiceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        NetworkModule.class,
        ServiceModule.class,
        SchedulerModule.class})
public interface AppComponent extends AndroidInjector<LastFMApp> {

    //injections goes here

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
