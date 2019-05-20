package com.application.lastfm_lloyds.details;

import com.application.lastfm_lloyds.base.schedulers.BaseSchedulerProvider;
import com.application.lastfm_lloyds.base.schedulers.ImmediateSchedulerProvider;
import com.application.lastfm_lloyds.data.model.detail.album.AlbumDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.artist.ArtistDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.track.TrackDetailResponse;
import com.application.lastfm_lloyds.data.repo.LFMRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Flowable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailPresenterTest {

    private static final String DEFAULT_MBID = "31623cce-9717-4513-9d83-1b5d04e44f9b";
    private static final String TYPE_ALBUM = "Album";
    private static final String TYPE_TRACK = "Track";
    private static final String TYPE_ARTIST = "Artist";

    private DetailPresenter presenter;

    @Mock
    private LFMRepository mockLfmRepository;

    @Mock
    private DetailContract.View mockView;

    @Mock
    TrackDetailResponse mockTrackDetailResponse;

    @Mock
    AlbumDetailResponse mockAlbumDetailResponse;

    @Mock
    ArtistDetailResponse mockArtistDetailResponse;

    private BaseSchedulerProvider baseSchedulerProvider;

    @Before
    public void setUpDetailPresenterException()  {
        MockitoAnnotations.initMocks(this);

        baseSchedulerProvider = new ImmediateSchedulerProvider();

        presenter = new DetailPresenter(mockLfmRepository, baseSchedulerProvider);
    }

    @Test
    public void shouldTakeViewAndSuccessfullyLoadAlbum() {
        when(mockLfmRepository.getAlbumDetails(DEFAULT_MBID)).thenReturn(Flowable.just(mockAlbumDetailResponse));
        presenter.setPayload(DEFAULT_MBID, TYPE_ALBUM);

        presenter.takeView(mockView);

        verify(mockLfmRepository, Mockito.times(1)).getAlbumDetails(DEFAULT_MBID);
        verify(mockView, times(1)).setAlbumInfoData(mockAlbumDetailResponse);
    }

    @Test
    public void shouldTakeViewAndFailLoadAlbum() throws Exception {
        when(mockLfmRepository.getAlbumDetails(DEFAULT_MBID)).thenReturn(Flowable.error(new Exception()));
        presenter.setPayload(DEFAULT_MBID, TYPE_ALBUM);

        presenter.takeView(mockView);

        verify(mockLfmRepository, Mockito.times(1)).getAlbumDetails(DEFAULT_MBID);
        verify(mockView, times(0)).setAlbumInfoData(mockAlbumDetailResponse);
        verify(mockView, times(1)).showError();
    }

    @Test
    public void shouldTakeViewAndSuccessfullyLoadArtist() {
        when(mockLfmRepository.getArtistDetails(DEFAULT_MBID)).thenReturn(Flowable.just(mockArtistDetailResponse));
        presenter.setPayload(DEFAULT_MBID, TYPE_ARTIST);

        presenter.takeView(mockView);

        verify(mockLfmRepository, Mockito.times(1)).getArtistDetails(DEFAULT_MBID);
        verify(mockView, times(1)).setArtistInfoData(mockArtistDetailResponse);
    }

    @Test
    public void shouldTakeViewAndFailLoadArtist() throws Exception {
        when(mockLfmRepository.getArtistDetails(DEFAULT_MBID)).thenReturn(Flowable.error(new Exception()));
        presenter.setPayload(DEFAULT_MBID, TYPE_ARTIST);

        presenter.takeView(mockView);

        verify(mockLfmRepository, Mockito.times(1)).getArtistDetails(DEFAULT_MBID);
        verify(mockView, times(0)).setArtistInfoData(mockArtistDetailResponse);
        verify(mockView, times(1)).showError();
    }

    @Test
    public void shouldTakeViewAndSuccessfullyLoadTrack() {
        when(mockLfmRepository.getTrackDetails(DEFAULT_MBID)).thenReturn(Flowable.just(mockTrackDetailResponse));
        presenter.setPayload(DEFAULT_MBID, TYPE_TRACK);

        presenter.takeView(mockView);

        verify(mockLfmRepository, Mockito.times(1)).getTrackDetails(DEFAULT_MBID);
        verify(mockView, times(1)).setTrackInfoData(mockTrackDetailResponse);
    }

    @Test
    public void shouldTakeViewAndFailLoadTrack() throws Exception {
        when(mockLfmRepository.getTrackDetails(DEFAULT_MBID)).thenReturn(Flowable.error(new Exception()));
        presenter.setPayload(DEFAULT_MBID, TYPE_TRACK);

        presenter.takeView(mockView);

        verify(mockLfmRepository, Mockito.times(1)).getTrackDetails(DEFAULT_MBID);
        verify(mockView, times(0)).setTrackInfoData(mockTrackDetailResponse);
        verify(mockView, times(1)).showError();
    }
}