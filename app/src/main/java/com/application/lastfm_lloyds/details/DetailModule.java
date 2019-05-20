package com.application.lastfm_lloyds.details;

import com.application.lastfm_lloyds.di.scopes.ActivityScoped;
import com.application.lastfm_lloyds.di.scopes.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DetailModule  {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract DetailFragment detailFragment();

    @ActivityScoped
    @Binds abstract DetailContract.Presenter detailPresenter(DetailPresenter detailPresenter);
}
