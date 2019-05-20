package com.application.lastfm_lloyds.search;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.application.lastfm_lloyds.data.model.LightSearchResult;
import com.application.lastfm_lloyds.R;
import com.application.lastfm_lloyds.details.DetailActivity;
import com.application.lastfm_lloyds.di.scopes.ActivityScoped;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

import static android.view.View.VISIBLE;
import static com.application.lastfm_lloyds.details.DetailActivity.INTENT_DETAIL_MBID;
import static com.application.lastfm_lloyds.details.DetailActivity.INTENT_DETAIL_TYPE;


@ActivityScoped
public class SearchFragment extends DaggerFragment implements SearchContract.View, CombinedResultAdapter.OnItemClickListener {

    @BindView(R.id.FragmentSearch_RecyclerView_combinedSearch)
    RecyclerView combinedResultLv;
    @BindView(R.id.FragmentSearch_EditText_searchField)
    TextView searchFieldEt;

    @Inject
    SearchContract.Presenter presenter;

    private Unbinder unbinder;
    private CombinedResultAdapter combinedResultAdapter;
    private RecyclerView.LayoutManager combinedResultLayoutManager;

    @OnTextChanged(value = R.id.FragmentSearch_EditText_searchField, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onSearchFieldUpdated(final Editable s) {
        if(s.length() > 3) {
            presenter.search(s.toString());
        }
    }


    @Inject
    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        combinedResultLv.setHasFixedSize(true);
        combinedResultLayoutManager = new LinearLayoutManager(getContext());
        combinedResultLv.setLayoutManager(combinedResultLayoutManager);
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
    public void refreshResults(final List<LightSearchResult> lightSearchResult) {
        if(combinedResultLv != null) {
            if(combinedResultLv.getAdapter() == null) {
                combinedResultAdapter = new CombinedResultAdapter(lightSearchResult);
                combinedResultAdapter.setOnItemClickListener(this);
                combinedResultLv.setAdapter(combinedResultAdapter);
                combinedResultLv.setVisibility(VISIBLE);
            } else {
                combinedResultLv.removeAllViewsInLayout();
                combinedResultAdapter.addItems(lightSearchResult);
                combinedResultAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void showDetailView(final String mbid, final String type) {
        final Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(INTENT_DETAIL_MBID, mbid);
        intent.putExtra(INTENT_DETAIL_TYPE, type);
        startActivity(intent);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(final View itemView, final int position) {
        presenter.onSearchItemClicked(position);
    }
}
