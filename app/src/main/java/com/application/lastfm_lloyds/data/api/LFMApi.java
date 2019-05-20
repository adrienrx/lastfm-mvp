package com.application.lastfm_lloyds.data.api;

import com.application.lastfm_lloyds.data.model.detail.album.AlbumDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.artist.ArtistDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.track.TrackDetailResponse;
import com.application.lastfm_lloyds.data.model.search.albums.AlbumResponse;
import com.application.lastfm_lloyds.data.model.search.artists.ArtistsResponse;
import com.application.lastfm_lloyds.data.model.search.tracks.TrackResponse;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LFMApi {
    @POST("/2.0/?method=album.search")
    Flowable<AlbumResponse> searchAlbum(@Query("album") final String albumResearch, @Query("limit") final int limit);

    @POST("/2.0/?method=artist.search")
    Flowable<ArtistsResponse> searchArtist(@Query("artist") final String artistResearch, @Query("limit") final int limit);

    @POST("/2.0/?method=track.search")
    Flowable<TrackResponse> searchTrack(@Query("track") final String trackResearch, @Query("limit") final int limit);

    @POST("/2.0/?method=track.getinfo")
    Flowable<TrackDetailResponse> getTrackDetails(@Query("mbid") final String mbid);

    @POST("/2.0/?method=album.getinfo")
    Flowable<AlbumDetailResponse> getAlbumDetails(@Query("mbid") final String mbid);

    @POST("/2.0/?method=artist.getinfo")
    Flowable<ArtistDetailResponse> getArtistDetails(@Query("mbid") final String mbid);

}
