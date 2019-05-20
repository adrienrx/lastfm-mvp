package com.application.lastfm_lloyds.details;

import com.application.lastfm_lloyds.base.schedulers.BaseSchedulerProvider;
import com.application.lastfm_lloyds.data.model.detail.album.AlbumDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.artist.ArtistDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.track.TrackDetailResponse;
import com.application.lastfm_lloyds.data.repo.LFMDataSource;
import com.application.lastfm_lloyds.di.scopes.ActivityScoped;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@ActivityScoped
public class DetailPresenter implements DetailContract.Presenter {
    private final LFMDataSource lfmDataSource;
    private final BaseSchedulerProvider baseSchedulerProvider;
    private DetailContract.View view;
    private CompositeDisposable compositeDisposable;
    private String mbid;
    private String type;
    private TrackDetailResponse trackDetailResponse;
    private ArtistDetailResponse artistDetailResponse;
    private AlbumDetailResponse albumDetailResponse;

    @Inject
    DetailPresenter(final LFMDataSource lfmDataSource, final BaseSchedulerProvider baseSchedulerProvider) {
        this.lfmDataSource = lfmDataSource;
        this.baseSchedulerProvider = baseSchedulerProvider;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void takeView(final DetailContract.View view) {
        this.view = view;

        compositeDisposable.clear();
        Disposable disposable = null;
        switch (type) {
            case "Track":
                disposable = lfmDataSource.getTrackDetails(mbid)
                        .subscribeOn(baseSchedulerProvider.io())
                        .observeOn(baseSchedulerProvider.mainThread())
                        .subscribe(trackDetailResponse -> {
                            this.trackDetailResponse = trackDetailResponse;
                            view.setTrackInfoData(trackDetailResponse);
                        }, throwable -> view.showError());
                break;
            case "Artist":
                disposable = lfmDataSource.getArtistDetails(mbid)
                        .subscribeOn(baseSchedulerProvider.io())
                        .observeOn(baseSchedulerProvider.mainThread())
                        .subscribe(artistDetailResponse -> {
                            this.artistDetailResponse = artistDetailResponse;
                            view.setArtistInfoData(artistDetailResponse);
                        }, throwable -> view.showError());
                break;
            case "Album":
                disposable = lfmDataSource.getAlbumDetails(mbid)
                        .subscribeOn(baseSchedulerProvider.io())
                        .observeOn(baseSchedulerProvider.mainThread())
                        .subscribe(albumDetailResponse -> {
                            this.albumDetailResponse = albumDetailResponse;
                            view.setAlbumInfoData(albumDetailResponse);
                        }, throwable -> view.showError());
                break;
        }

        compositeDisposable.add(disposable);
    }

    @Override
    public void dropView() {
        this.view = null;
        compositeDisposable.clear();
    }

    @Override
    public void setPayload(final String mbid, final String type) {
        this.mbid = mbid;
        this.type = type;
    }
}
