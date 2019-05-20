package com.application.lastfm_lloyds.details;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.application.lastfm_lloyds.R;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class DetailActivity extends DaggerAppCompatActivity {

    public static final String INTENT_DETAIL_MBID = "INTENT_DETAIL_MBID";
    public static final String INTENT_DETAIL_TYPE = "INTENT_DETAIL_TYPE";

    @Inject
    DetailPresenter presenter;

    @Inject
    Lazy<DetailFragment> detailFragmentProvider;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getIntent() != null && getIntent().hasExtra(INTENT_DETAIL_MBID) && getIntent().hasExtra(INTENT_DETAIL_TYPE)) {
            presenter.setPayload(getIntent().getStringExtra(INTENT_DETAIL_MBID), getIntent().getStringExtra(INTENT_DETAIL_TYPE));
        } else {
            finish();
        }

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.DetailActivity_FrameLayout_contentFrame);

        if(detailFragment == null) {
            detailFragment = detailFragmentProvider.get();
            getSupportFragmentManager().beginTransaction().add(R.id.DetailActivity_FrameLayout_contentFrame, detailFragment).commit();
        }

    }
}
