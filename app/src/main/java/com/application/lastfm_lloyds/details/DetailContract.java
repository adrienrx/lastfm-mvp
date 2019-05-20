package com.application.lastfm_lloyds.details;

import com.application.lastfm_lloyds.base.BasePresenter;
import com.application.lastfm_lloyds.base.BaseView;
import com.application.lastfm_lloyds.data.model.detail.album.AlbumDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.artist.ArtistDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.track.TrackDetailResponse;

public interface DetailContract {
    interface View extends BaseView<Presenter> {
        void setTrackInfoData(final TrackDetailResponse trackInfoData);

        void setAlbumInfoData(final AlbumDetailResponse albumInfoData);

        void setArtistInfoData(final ArtistDetailResponse artistInfoData);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {

        void setPayload(final String mbid, final String type);
    }
}
