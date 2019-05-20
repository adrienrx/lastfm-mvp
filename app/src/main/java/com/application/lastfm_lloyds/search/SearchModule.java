package com.application.lastfm_lloyds.search;

import com.application.lastfm_lloyds.di.scopes.ActivityScoped;
import com.application.lastfm_lloyds.di.scopes.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SearchModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SearchFragment searchFragment();

    @ActivityScoped
    @Binds abstract SearchContract.Presenter searchPresenter(SearchPresenter presenter);
}
