package com.application.lastfm_lloyds.data;

import com.application.lastfm_lloyds.data.model.search.albums.AlbumResponse;
import com.application.lastfm_lloyds.data.model.search.artists.ArtistsResponse;
import com.application.lastfm_lloyds.data.model.search.tracks.TrackResponse;

public class CombinedSearchResult {
    private final AlbumResponse albumResponse;
    private final ArtistsResponse artistsResponse;
    private final TrackResponse trackResponse;

    public CombinedSearchResult(final AlbumResponse albumResponse, final ArtistsResponse artistsResponse, final TrackResponse trackResponse) {
        this.albumResponse = albumResponse;
        this.artistsResponse = artistsResponse;
        this.trackResponse = trackResponse;
    }

    public AlbumResponse getAlbumResponse() {
        return albumResponse;
    }

    public ArtistsResponse getArtistsResponse() {
        return artistsResponse;
    }

    public TrackResponse getTrackResponse() {
        return trackResponse;
    }

    public int getTotalsTruncatedResult() {
        return albumResponse.results.albummatches.album.size() + artistsResponse.results.artistmatches.artist.size() + trackResponse.results.trackmatches.track.size();
    }

}
