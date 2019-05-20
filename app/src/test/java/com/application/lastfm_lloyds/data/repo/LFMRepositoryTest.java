package com.application.lastfm_lloyds.data.repo;

import com.application.lastfm_lloyds.data.api.LFMApi;
import com.application.lastfm_lloyds.data.model.search.albums.AlbumResponse;
import com.application.lastfm_lloyds.data.model.search.artists.ArtistsResponse;
import com.application.lastfm_lloyds.data.model.search.tracks.TrackResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import io.reactivex.Flowable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LFMRepositoryTest {
    public static final int LIMIT = 10;
    private static String SEARCH = "keyword";

    private LFMRepository lfmRepository;

    @Mock
    LFMApi mockLfmApi;

    @Spy
    AlbumResponse mockAlbumResponse;

    @Mock
    ArtistsResponse mockArtistResponse;

    @Mock
    TrackResponse mockTrackResponse;

    @Before
    public void setUpLFMRepository() {
        MockitoAnnotations.initMocks(this);

        lfmRepository = LFMRepository.getInstance(mockLfmApi);
    }

    @Test
    public void destroyInstance() {
        LFMRepository.destroyInstance();
    }


    @Test
    public void shouldPerformCombinedSearch() {
        when(mockLfmApi.searchAlbum(SEARCH, LIMIT)).thenReturn(Flowable.just(mockAlbumResponse));
        when(mockLfmApi.searchArtist(SEARCH, LIMIT)).thenReturn(Flowable.just(mockArtistResponse));
        when(mockLfmApi.searchTrack(SEARCH, LIMIT)).thenReturn(Flowable.just(mockTrackResponse));

        lfmRepository.combinedSearch(SEARCH, LIMIT);

        verify(mockLfmApi, times(1)).searchAlbum(SEARCH, LIMIT);
        verify(mockLfmApi, times(1)).searchArtist(SEARCH, LIMIT);
        verify(mockLfmApi, times(1)).searchTrack(SEARCH, LIMIT);
    }
}