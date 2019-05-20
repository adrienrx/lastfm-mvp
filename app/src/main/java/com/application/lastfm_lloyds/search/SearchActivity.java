package com.application.lastfm_lloyds.search;

import android.os.Bundle;

import com.application.lastfm_lloyds.R;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class SearchActivity extends DaggerAppCompatActivity {

    @Inject
    SearchPresenter searchPresenter;

    @Inject
    Lazy<SearchFragment> searchFragmentProvider;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchFragment searchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.SearchActivity_FrameLayout_contentFrame);

        if(searchFragment == null) {
            searchFragment = searchFragmentProvider.get();
            getSupportFragmentManager().beginTransaction().add(R.id.SearchActivity_FrameLayout_contentFrame, searchFragment).commit();
        }
    }
}
