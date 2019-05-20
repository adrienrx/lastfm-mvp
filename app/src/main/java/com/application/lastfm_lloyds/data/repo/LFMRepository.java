package com.application.lastfm_lloyds.data.repo;

import com.application.lastfm_lloyds.data.model.LightSearchResult;
import com.application.lastfm_lloyds.data.CombinedSearchResult;
import com.application.lastfm_lloyds.data.api.LFMApi;
import com.application.lastfm_lloyds.data.model.detail.album.AlbumDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.artist.ArtistDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.track.TrackDetailResponse;
import com.application.lastfm_lloyds.data.model.search.albums.Album;
import com.application.lastfm_lloyds.data.model.search.albums.AlbumResponse;
import com.application.lastfm_lloyds.data.model.search.artists.Artist;
import com.application.lastfm_lloyds.data.model.search.artists.ArtistsResponse;
import com.application.lastfm_lloyds.data.model.search.tracks.Track;
import com.application.lastfm_lloyds.data.model.search.tracks.TrackResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

public class LFMRepository implements LFMDataSource {

    private static LFMRepository INSTANCE = null;

    private final LFMApi lfmApi;

    private LFMRepository(final LFMApi lfmApi) {
        this.lfmApi = lfmApi;
    }

    public static LFMRepository getInstance(final LFMApi lfmApi) {
        if(INSTANCE == null) {
            INSTANCE = new LFMRepository(lfmApi);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Flowable<List<LightSearchResult>> combinedSearch(final String search, final int limit) {
        return Flowable.zip(lfmApi.searchAlbum(search, limit), lfmApi.searchArtist(search, limit), lfmApi.searchTrack(search, limit), CombinedSearchResult::new)
                .map(combinedSearchResult -> {
                    final List<LightSearchResult> lightSearchResultsList = new ArrayList<>();

                    for(Album a : combinedSearchResult.getAlbumResponse().results.albummatches.album) {
                        lightSearchResultsList.add(new LightSearchResult(a.name, a.type, a.image.get(1).text, a.mbid));
                    }

                    for(Artist a : combinedSearchResult.getArtistsResponse().results.artistmatches.artist) {
                        lightSearchResultsList.add(new LightSearchResult(a.name, a.type, a.image.get(1).text, a.mbid));
                    }

                    for(Track a : combinedSearchResult.getTrackResponse().results.trackmatches.track) {
                        lightSearchResultsList.add(new LightSearchResult(a.name, a.type, a.image.get(1).text, a.mbid));
                    }

                    return lightSearchResultsList;
                });
    }

    @Override
    public Flowable<AlbumResponse> searchAlbum(final String search) {
        return lfmApi.searchAlbum(search, 30);
    }

    @Override
    public Flowable<ArtistsResponse> searchArtist(final String search) {
        return lfmApi.searchArtist(search, 30);
    }

    @Override
    public Flowable<TrackResponse> searchTrack(final String search) {
        return lfmApi.searchTrack(search, 30);
    }

    @Override
    public Flowable<TrackDetailResponse> getTrackDetails(final String mbid) {
        return lfmApi.getTrackDetails(mbid);
    }

    @Override
    public Flowable<AlbumDetailResponse> getAlbumDetails(final String mbid) {
        return lfmApi.getAlbumDetails(mbid);
    }

    @Override
    public Flowable<ArtistDetailResponse> getArtistDetails(final String mbid) {
        return lfmApi.getArtistDetails(mbid);
    }
}
