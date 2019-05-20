package com.application.lastfm_lloyds.search;

import com.application.lastfm_lloyds.data.model.LightSearchResult;
import com.application.lastfm_lloyds.base.schedulers.BaseSchedulerProvider;
import com.application.lastfm_lloyds.data.repo.LFMDataSource;
import com.application.lastfm_lloyds.di.scopes.ActivityScoped;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@ActivityScoped
public class SearchPresenter implements SearchContract.Presenter {

    private final LFMDataSource LFMDataSource;
    private final BaseSchedulerProvider baseSchedulerProvider;
    private SearchContract.View searchView;
    private CompositeDisposable compositeDisposable;
    private List<LightSearchResult> localLightSearchResults;

    @Inject
    SearchPresenter(final LFMDataSource LFMDataSource, final BaseSchedulerProvider baseSchedulerProvider) {
        this.LFMDataSource = LFMDataSource;
        this.baseSchedulerProvider = baseSchedulerProvider;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void takeView(final SearchContract.View view) {
        this.searchView = view;
    }


    @Override
    public void dropView() {
        this.searchView = null;
        compositeDisposable.clear();
    }

    @Override
    public void search(final String search) {
        compositeDisposable.clear();
        Disposable disposable = LFMDataSource.combinedSearch(search, 10)
                .observeOn(baseSchedulerProvider.mainThread())
                .subscribeOn(baseSchedulerProvider.io())
                .subscribe(lightSearchResults -> {
                            this.localLightSearchResults = lightSearchResults;
                            searchView.refreshResults(lightSearchResults);
                        },
                        throwable -> searchView.showError());
        compositeDisposable.add(disposable);
    }

    @Override
    public void onSearchItemClicked(final int position) {
        if (localLightSearchResults != null) {
            final LightSearchResult searchResult = localLightSearchResults.get(position);
            searchView.showDetailView(searchResult.getMbid(), searchResult.getType());
        }
    }

    public void setLocalLightSearchResults(final List<LightSearchResult> localLightSearchResults) {
        this.localLightSearchResults = localLightSearchResults;
    }
}
