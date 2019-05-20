package com.application.lastfm_lloyds.di.modules;

import com.application.lastfm_lloyds.details.DetailActivity;
import com.application.lastfm_lloyds.details.DetailModule;
import com.application.lastfm_lloyds.di.scopes.ActivityScoped;
import com.application.lastfm_lloyds.search.SearchActivity;
import com.application.lastfm_lloyds.search.SearchModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = SearchModule.class)
    abstract SearchActivity searchActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = DetailModule.class)
    abstract DetailActivity detailActivity();
}
