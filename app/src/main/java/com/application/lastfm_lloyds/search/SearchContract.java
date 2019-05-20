package com.application.lastfm_lloyds.search;

import com.application.lastfm_lloyds.data.model.LightSearchResult;
import com.application.lastfm_lloyds.base.BasePresenter;
import com.application.lastfm_lloyds.base.BaseView;

import java.util.List;

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        void refreshResults(final List<LightSearchResult> lightSearchResult);

        void showDetailView(final String mbid, final String type);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void search(final String search);

        void onSearchItemClicked(final int position);
    }

}
