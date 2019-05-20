package com.application.lastfm_lloyds.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.lastfm_lloyds.R;
import com.application.lastfm_lloyds.data.model.detail.album.Album;
import com.application.lastfm_lloyds.data.model.detail.album.AlbumDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.artist.Artist;
import com.application.lastfm_lloyds.data.model.detail.artist.ArtistDetailResponse;
import com.application.lastfm_lloyds.data.model.detail.track.Track;
import com.application.lastfm_lloyds.data.model.detail.track.TrackDetailResponse;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

import static android.text.TextUtils.isEmpty;

public class DetailFragment extends DaggerFragment implements DetailContract.View {

    //usecase: Album/Track/Artist

    private Unbinder unbinder;

    @BindView(R.id.FragmentDetail_ImageView_header)
    ImageView headerImg;

    @BindView(R.id.FragmentDetail_TextView_title)
    TextView titleTv;

    @Inject
    DetailContract.Presenter presenter;

    @Inject
    public DetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
        if(unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void setTrackInfoData(final TrackDetailResponse trackInfoData) {
        final Track track = trackInfoData.track;
        feedUI(track.album.image.get(3).text, track.name);
    }

    @Override
    public void setAlbumInfoData(final AlbumDetailResponse albumInfoData) {
        final Album album = albumInfoData.album;
        feedUI(album.image.get(3).text, album.name);
    }

    @Override
    public void setArtistInfoData(final ArtistDetailResponse artistInfoData) {
        final Artist artist = artistInfoData.artist;
        feedUI(artist.image.get(3).text, artist.name);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
    }

    private void feedUI(final String headUrl, final String title) {
        if(!isEmpty(headUrl)) {
            Picasso.get().load(headUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(headerImg);
        }
        titleTv.setText(title);
    }
}
