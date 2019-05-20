package com.application.lastfm_lloyds.data.repo;

import com.application.lastfm_lloyds.data.model.LightSearchResult;
import com.application.lastfm_lloyds.data.model.detail.album.AlbumDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.artist.ArtistDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.track.TrackDetailResponse;
import com.application.lastfm_lloyds.data.model.search.albums.AlbumResponse;
import com.application.lastfm_lloyds.data.model.search.artists.ArtistsResponse;
import com.application.lastfm_lloyds.data.model.search.tracks.TrackResponse;

import java.util.List;

import io.reactivex.Flowable;

public interface LFMDataSource {

    Flowable<List<LightSearchResult>> combinedSearch(final String search, final int limit);

    Flowable<AlbumResponse> searchAlbum(final String search);

    Flowable<ArtistsResponse> searchArtist(final String search);

    Flowable<TrackResponse> searchTrack(final String search);

    Flowable<TrackDetailResponse> getTrackDetails(final String mbid);

    Flowable<AlbumDetailResponse> getAlbumDetails(final String mbid);

    Flowable<ArtistDetailResponse> getArtistDetails(final String mbid);

}
